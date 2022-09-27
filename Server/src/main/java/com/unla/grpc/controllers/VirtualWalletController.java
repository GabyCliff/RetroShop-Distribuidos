package com.unla.grpc.controllers;


import com.unla.grpc.constants.Constants;
import com.unla.grpc.dtos.VirtualWalletDTO;
import com.unla.grpc.services.interfaces.IVirtualWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/virtual_wallet")
public class VirtualWalletController {

    @Autowired
    private IVirtualWalletService iVirtualWalletService;

    @PostMapping
    public String createVirtualWallet(@RequestBody VirtualWalletDTO virtualWalletDTO){
        iVirtualWalletService.setup(virtualWalletDTO);
        return Constants.SETUP_OK;
    }
}
