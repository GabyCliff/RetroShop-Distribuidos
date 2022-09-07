package com.unla.grpc.services;

import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.dtos.UserDTO;

public interface IUserService {

    ResponseData<UserDTO> createUser(String username, UserDTO userDTO);

    ResponseData<UserDTO> getUser(String username, String password, String userToFind);

    ResponseData<UserDTO> getCurrentUser(String username, String password);

    void setup(UserDTO userDTO);

}
