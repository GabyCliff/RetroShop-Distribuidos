package com.unla.grpc.converters;

import com.unla.grpc.dtos.VirtualWalletDTO;
import com.unla.grpc.models.VirtualWallet;

public class VirtualWalletConverter {

    public VirtualWalletConverter(){

    }

    public static VirtualWallet fromVirtualWalletDTO_to_VirtualWallet(VirtualWalletDTO virtualWalletDTO){
        VirtualWallet virtualWallet = new VirtualWallet();
        virtualWallet.setIdUser(virtualWalletDTO.getIdUser());
        virtualWallet.setBalance(virtualWalletDTO.getBalance());

        return virtualWallet;
    }

    public static VirtualWalletDTO fromVirtualWallet_to_VirtualWalletDTO(VirtualWallet virtualWallet){
        VirtualWalletDTO virtualWalletDTO = new VirtualWalletDTO();
        virtualWalletDTO.setId(virtualWallet.getId());
        virtualWalletDTO.setBalance(virtualWallet.getBalance());
        virtualWalletDTO.setIdUser(virtualWallet.getIdUser());

        return virtualWalletDTO;
    }

}
