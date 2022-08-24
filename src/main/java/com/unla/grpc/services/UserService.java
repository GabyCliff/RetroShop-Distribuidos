package com.unla.grpc.services;

import com.unla.grpc.converters.UserConverter;
import com.unla.grpc.dtos.UserDTO;
import com.unla.grpc.models.User;
import com.unla.grpc.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(UserDTO userDTO) {

        userRepository.save(UserConverter.fromUserDTOtoUser(userDTO));

        return "User created successfully";
    }

    @Override
    public UserDTO getUser(String username) {

        Optional<User> user = userRepository.findByUsername(username);

        return user.map(UserConverter::fromUserToUserDTO).orElseGet(UserDTO::new);
    }
}
