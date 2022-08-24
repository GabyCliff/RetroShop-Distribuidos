package com.unla.grpc.services;

import com.unla.grpc.dtos.UserDTO;

public interface IUserService {

    String createUser(UserDTO userDTO);

    UserDTO getUser(String username);

}
