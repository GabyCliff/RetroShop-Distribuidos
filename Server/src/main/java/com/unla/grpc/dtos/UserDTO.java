package com.unla.grpc.dtos;

import lombok.Data;

@Data
public class UserDTO {

    private long id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private String email;

    private String role;

    private int dni;
}
