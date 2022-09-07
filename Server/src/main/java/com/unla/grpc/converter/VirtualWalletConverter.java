package com.unla.grpc.converter;

import com.unla.grpc.dtos.VirtualWalletDTO;
import com.unla.grpc.models.VirtualWallet;

public class VirtualWalletConverter {

    public VirtualWalletConverter(){

    }

    public static VirtualWallet fromVirtualWalletDTO_to_VirtualWallet(VirtualWalletDTO virtualWalletDTO){
        VirtualWallet virtualWallet = new VirtualWallet();
        virtualWallet.setNumber(virtualWalletDTO.getNumber());
        virtualWallet.setBalance(virtualWalletDTO.getBalance());
        virtualWallet.setName(virtualWalletDTO.getName());
        virtualWallet.setSurname(virtualWalletDTO.getSurname());
        virtualWallet.setDni(virtualWalletDTO.getDni());
        virtualWallet.setValidFrom(virtualWalletDTO.getValidFrom());
        virtualWallet.setValidUntil(virtualWalletDTO.getValidUntil());

        return virtualWallet;
    }

    public static VirtualWalletDTO fromVirtualWallet_to_VirtualWalletDTO(VirtualWallet virtualWallet){
        VirtualWalletDTO virtualWalletDTO = new VirtualWalletDTO();
        virtualWalletDTO.setId(virtualWallet.getId());
        virtualWalletDTO.setNumber(virtualWallet.getNumber());
        virtualWalletDTO.setBalance(virtualWallet.getBalance());
        virtualWalletDTO.setName(virtualWallet.getName());
        virtualWalletDTO.setSurname(virtualWallet.getSurname());
        virtualWalletDTO.setDni(virtualWallet.getDni());
        virtualWalletDTO.setValidFrom(virtualWallet.getValidFrom());
        virtualWalletDTO.setValidUntil(virtualWallet.getValidUntil());

        return virtualWalletDTO;
    }

}
