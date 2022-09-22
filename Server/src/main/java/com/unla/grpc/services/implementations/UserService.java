package com.unla.grpc.services.implementations;

import com.unla.grpc.constants.UserConstants;
import com.unla.grpc.converters.UserConverter;
import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.dtos.UserDTO;
import com.unla.grpc.models.User;
import com.unla.grpc.repositories.UserRepository;
import com.unla.grpc.services.interfaces.IUserService;
import com.unla.grpc.utils.AESUtils;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.unla.retroshopservicegrpc.grpc.UserResponse;
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
