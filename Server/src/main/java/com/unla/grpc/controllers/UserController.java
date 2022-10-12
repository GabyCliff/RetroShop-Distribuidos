package com.unla.grpc.controllers;

import com.unla.grpc.dtos.UserDTO;
import com.unla.grpc.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/byId")
    public UserDTO getUserById(@RequestBody UserDTO userDTO){
        return userService.getUserByIdREST(userDTO.getId());
    }



}
