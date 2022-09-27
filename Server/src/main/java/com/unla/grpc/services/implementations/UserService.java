package com.unla.grpc.services.implementations;

import com.unla.grpc.constants.UserConstants;
import com.unla.grpc.converters.UserConverter;
import com.unla.grpc.dtos.InvoiceDTO;
import com.unla.grpc.dtos.ItemDTO;
import com.unla.grpc.dtos.ProductDTO;
import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.dtos.UserDTO;
import com.unla.grpc.models.User;
import com.unla.grpc.repositories.UserRepository;
import com.unla.grpc.services.interfaces.IInvoiceService;
import com.unla.grpc.services.interfaces.IItemService;
import com.unla.grpc.services.interfaces.IProductService;
import com.unla.grpc.services.interfaces.IUserService;
import com.unla.grpc.services.interfaces.IVirtualWalletService;
import com.unla.grpc.utils.AESUtils;
import com.unla.retroshopservicegrpc.grpc.UserResponse;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Value("${encrypt.key.value}")
    private String encryptKey;

    @Value("${encrypt.iv.value}")
    private String encryptIv;

    @Value("${encrypt.algorithm.value}")
    private String encryptAlgorithm;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IItemService itemService;

    @Autowired
    private IInvoiceService invoiceService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IVirtualWalletService walletService;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ResponseData<UserDTO> createUser(UserDTO userDTO) {

        String requestValidation = validateUserRequest(userDTO);
        if (!UserConstants.OK.equals(requestValidation)){
            return new ResponseData<>(null, requestValidation);
        }
        if (validateDuplicatedUser(userDTO.getUsername(), userDTO.getEmail(), userDTO.getDni())){
            return new ResponseData<>(null, UserConstants.DUPLICATED_USER_ERROR_MESSAGE);
        }

        String passEncoded = encryptPass(userDTO.getPassword());
        userDTO.setPassword(passEncoded);
        User createdUser = userRepository.save(UserConverter.fromUserDTOtoUser(userDTO));
        return new ResponseData<>(UserConverter.fromUserToUserDTO(createdUser), UserConstants.OK);
    }

    @Override
    public ResponseData<UserDTO> getUser(String username, String password, String userToFind) {
        if (!validateAccess(username, true)){
            return new ResponseData<>(null, UserConstants.ACCESS_VALIDATION_ERROR_MESSAGE);
        }
        Optional<User> userResult = userRepository.findByUsername(userToFind);
        return userResult.map(
                        user -> new ResponseData<>(UserConverter.fromUserToUserDTO(user),
                                UserConstants.OK))
                .orElseGet(
                        () -> new ResponseData<>(null, UserConstants.USER_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public ResponseData<UserDTO> getCurrentUser(String username, String password) {
        String passEncoded = encryptPass(password);
        Optional<User> userResult = userRepository.findByUsernameAndPassword(username, passEncoded);
        return userResult.map(
                        user -> new ResponseData<>(UserConverter.fromUserToUserDTO(user),
                                UserConstants.OK))
                .orElseGet(
                        () -> new ResponseData<>(null, UserConstants.USER_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public ResponseData<String> buyProducts(long userId, Map<Long, Long> productAndQuantity) {

        Map<Long, List<ProductDTO>> sellers = new LinkedHashMap<>();
        float totalADescontarWallet = 0;

        //Me traigo todos los productos que coincidan con los ids de la lista
        List<ProductDTO> productDTOS = productService.getAllByListIds(new ArrayList<>(productAndQuantity.keySet()));

        //Itero todos los productos y los colecciono en un map agrupandolos por sellerId
        for (ProductDTO prod : productDTOS){
            sellers.putIfAbsent(prod.getIdUser(), new ArrayList<>());
            sellers.get(prod.getIdUser()).add(prod);
        }

        //Itero el map agrupado
        for (Entry<Long, List<ProductDTO>> entry : sellers.entrySet()){
            float total = 0;

            //Calculo el total del invoice iterando los productos de un seller en particular
            for (ProductDTO prod : entry.getValue()){
                total = total + (prod.getPrice() * productAndQuantity.get(prod.getId()));
            }
            //Creo el nuevo invoice para ese seller
            ResponseData<InvoiceDTO> invoiceResponse = invoiceService.createNewInvoice(
                    new InvoiceDTO(0, userId, entry.getKey(), total, LocalDate.now()));
            //Itero todos los productos de ese seller y creo los items, luego hago el update de las cantidades
            for (ProductDTO prod : entry.getValue()){
                itemService.createItem(
                        new ItemDTO(0, prod.getId(), productAndQuantity.get(prod.getId()),
                                prod.getPrice()*productAndQuantity.get(prod.getId()),
                                invoiceResponse.getData().getId()));
                prod.setQuantity(prod.getQuantity() - productAndQuantity.get(prod.getId()));
                productService.updateProduct(prod, prod.getId());
            }

            totalADescontarWallet = totalADescontarWallet + total;
        }

        if (walletService.getByIdUser(userId).getData().getBalance() < totalADescontarWallet){
            return new ResponseData<>("", "Fondos Insuficientes");
        }

        walletService.update(userId, false, (long)totalADescontarWallet);
        return new ResponseData<>("OK", "Compra realizada satisfactoriamente");
    }

    @Override
    public void setup(UserDTO userDTO) {
        String passEncoded = encryptPass(userDTO.getPassword());
        userDTO.setPassword(passEncoded);
        userRepository.save(UserConverter.fromUserDTOtoUser(userDTO));
    }

    private String encryptPass(String pass){
        SecretKey key = new SecretKeySpec(encryptKey.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec iv = new IvParameterSpec(encryptIv.getBytes(StandardCharsets.UTF_8));

        String encrypted = "";
        try {
            encrypted = AESUtils.encrypt(encryptAlgorithm, pass, key, iv);
        } catch (NoSuchPaddingException |
                NoSuchAlgorithmException |
                InvalidAlgorithmParameterException |
                InvalidKeyException |
                BadPaddingException |
                IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return encrypted;
    }

    private boolean validateAccess(String username, boolean admin){
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent();
    }

    private String validateUserRequest(UserDTO request){

        if (StringUtils.isEmpty(request.getName())){
            return UserConstants.REQUEST_NAME_ERROR_MESSAGE;
        }
        if (StringUtils.isEmpty(request.getSurname())){
            return UserConstants.REQUEST_SURNAME_ERROR_MESSAGE;
        }
        if (request.getDni() < 1000000){
            return UserConstants.REQUEST_DNI_ERROR_MESSAGE;
        }
        if (StringUtils.isEmpty(request.getUsername())){
            return UserConstants.REQUEST_USERNAME_ERROR_MESSAGE;
        }
        if (StringUtils.isEmpty(request.getPassword())){
            return UserConstants.REQUEST_PASS_ERROR_MESSAGE;
        }
        if (StringUtils.isEmpty(request.getEmail())){
            return UserConstants.REQUEST_EMAIL_ERROR_MESSAGE;
        }

        return UserConstants.OK;
    }

    private boolean validateDuplicatedUser(String username, String email, int dni){
        return userRepository.findByUsernameOrEmailOrDni(username, email, dni).isPresent();
    }

    @Override
    public UserDTO getUserById(long id){
        User aux = userRepository.findById(id).get();
        return modelMapper.map(aux, UserDTO.class);
    }

    @Override
    public UserResponse getUserResponseById(long idUser) {
        UserDTO userDTO = getUserById(idUser);
        return UserResponse.newBuilder()
                .setId(userDTO.getId())
                .setDni(userDTO.getDni())
                .setSurname(userDTO.getSurname())
                .setName(userDTO.getName())
                .setEmail(userDTO.getEmail())
                .setUsername(userDTO.getUsername())
                .setPassword(userDTO.getPassword())
                .setRole(userDTO.getRole())
                .build();
    }

}
