package com.unla.grpc.dtos;

import lombok.Data;

@Data
public class UserDTO {

    private long id;

    private String username;

    private String name;

    private String surname;

    private String email;

    private String role;

    private String password;

    private int dni;
}
