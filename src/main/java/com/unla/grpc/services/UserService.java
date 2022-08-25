package com.unla.grpc.services;

import com.unla.grpc.converters.UserConverter;
import com.unla.grpc.dtos.UserDTO;
import com.unla.grpc.models.User;
import com.unla.grpc.repositories.UserRepository;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Value("${encrypt.key.value}")
    private String encryptKey;

    @Value("${encrypt.iv.value}")
    private String encryptIv;

    @Value("${encrypt.algorithm.value}")
    private String encryptAlgorithm;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(String username, String password, UserDTO userDTO) {
        if (!validateAccess(username, password, true)){
            return "Incorrect user and pass OR Permission insufficient";
        }
        String passEncoded = encryptPass(userDTO.getPassword());
        userDTO.setPassword(passEncoded);
        userRepository.save(UserConverter.fromUserDTOtoUser(userDTO));
        return "User created successfully";
    }

    @Override
    public UserDTO getUser(String username, String password, String userToFind) {
        if (!validateAccess(username, password, true)){
            return null;
        }
        Optional<User> userResult = userRepository.findByUsername(userToFind);
        return userResult.map(UserConverter::fromUserToUserDTO).orElse(null);
    }

    @Override
    public UserDTO getCurrentUser(String username, String password) {
        String passEncoded = encryptPass(password);
        Optional<User> userResult = userRepository.findByUsernameAndPassword(username, passEncoded);
        return userResult.map(UserConverter::fromUserToUserDTO).orElse(null);
    }

    @Override
    public void setup(UserDTO userDTO) {
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
        System.out.println(encrypted);
        return encrypted;
    }

    private boolean validateAccess(String username, String password, boolean admin){
        String passEncoded = encryptPass(password);
        Optional<User> user = userRepository.findByUsernameAndPasswordAndRole(
                username, passEncoded, admin ? "ADMIN" : "STANDARD");
        return user.isPresent();
    }

}
