package com.unla.grpc.converters;

import com.unla.grpc.dtos.UserDTO;
import com.unla.grpc.models.User;

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

}
