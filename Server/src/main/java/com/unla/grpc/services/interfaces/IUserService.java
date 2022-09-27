package com.unla.grpc.services.interfaces;

import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.dtos.UserDTO;
import com.unla.retroshopservicegrpc.grpc.UserResponse;
import java.util.List;
import java.util.Map;

public interface IUserService {

    ResponseData<UserDTO> createUser(UserDTO userDTO);

    ResponseData<UserDTO> getUser(String username, String password, String userToFind);

    UserDTO getUserById(long id);

    UserResponse getUserResponseById(long idUser);

    ResponseData<UserDTO> getCurrentUser(String username, String password);

    ResponseData<String> buyProducts(long userId, Map<Long, Long> productAndQuantity);

    void setup(UserDTO userDTO);

}
