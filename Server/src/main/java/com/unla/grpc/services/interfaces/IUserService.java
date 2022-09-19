package com.unla.grpc.services.interfaces;

import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.dtos.UserDTO;
import com.unla.retroshopservicegrpc.grpc.UserResponse;

public interface IUserService {

    ResponseData<UserDTO> createUser(String username, UserDTO userDTO);

    ResponseData<UserDTO> getUser(String username, String password, String userToFind);

    UserDTO getUserById(long id);

    UserResponse getUserResponseById(long idUser);

    ResponseData<UserDTO> getCurrentUser(String username, String password);

    void setup(UserDTO userDTO);

}
