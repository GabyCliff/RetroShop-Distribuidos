package com.unla.grpc.services;

import com.unla.grpc.dtos.UserDTO;

public interface IUserService {

    String createUser(String username, String password, UserDTO userDTO);

    UserDTO getUser(String username, String password, String userToFind);

    UserDTO getCurrentUser(String username, String password);

    void setup(UserDTO userDTO);

}
