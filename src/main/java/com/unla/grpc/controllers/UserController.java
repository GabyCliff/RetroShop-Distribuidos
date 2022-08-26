package com.unla.grpc.controllers;

import com.unla.grpc.converters.UserConverter;
import com.unla.grpc.dtos.UserDTO;
import com.unla.grpc.repositories.UserRepository;
import com.unla.grpc.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public String createUser(@RequestBody UserDTO userDTO){
        userService.setup(userDTO);
        return "SETUP OK";
    }

}
