package com.unla.grpc.converters;

import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.dtos.UserDTO;
import com.unla.grpc.models.User;
import com.unla.retroshopservicegrpc.grpc.UserResponse;

import java.util.Optional;

public class UserConverter {

    public UserConverter(){

    }

    public static User fromUserDTOtoUser(UserDTO dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());
        user.setRole("STANDARD");
        user.setDni(dto.getDni());
        return user;
    }

    public static UserDTO fromUserToUserDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setDni(user.getDni());
        return dto;
    }

    public static UserResponse fromOptionalUser_to_UserResponse(Optional<User> user){
        return UserResponse.newBuilder()
                .setId(user.get().getId())
                .setDni(user.get().getDni())
                .setSurname(user.get().getSurname())
                .setName(user.get().getName())
                .setEmail(user.get().getEmail())
                .setUsername(user.get().getUsername())
                .setPassword(user.get().getPassword())
                .setRole(user.get().getRole())
                .build();
    }

    public static UserResponse fromUserDTO_to_UserResponse(ResponseData user){
        return null;
    }
}
