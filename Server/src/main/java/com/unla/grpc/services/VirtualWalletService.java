package com.unla.grpc.services;

import com.unla.grpc.constants.VirtualWalletConstants;
import com.unla.grpc.converter.VirtualWalletConverter;
import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.dtos.VirtualWalletDTO;
import com.unla.grpc.models.VirtualWallet;
import com.unla.grpc.repositories.VirtualWalletRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VirtualWalletService implements IVirtualWalletService{

    @Autowired
    private VirtualWalletRepository virtualWalletRepository;

    @Override
    public ResponseData<VirtualWalletDTO> createVirtualWallet(String number, long balance, String name, String surname, VirtualWalletDTO virtualWalletDTO){
        VirtualWallet created_v_w = virtualWalletRepository.save(VirtualWalletConverter.fromVirtualWalletDTO_to_VirtualWallet(virtualWalletDTO));
        return new ResponseData<>(VirtualWalletConverter.fromVirtualWallet_to_VirtualWalletDTO(created_v_w), VirtualWalletConstants.OK);
    }

    @Override
    public ResponseData<VirtualWalletDTO> getVirtualWalletByNumber(String number){
        Optional<VirtualWallet> virtualWalletResult = virtualWalletRepository.findByNumber(number);
        return virtualWalletResult.map(
                        virtualWallet -> new ResponseData<>(VirtualWalletConverter.fromVirtualWallet_to_VirtualWalletDTO(virtualWallet),
                                VirtualWalletConstants.OK))
                .orElseGet(
                        () -> new ResponseData<>(null, VirtualWalletConstants.USER_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public ResponseData<VirtualWalletDTO> getVirtualWalletById(long id){
        Optional<VirtualWallet> virtualWalletResult = virtualWalletRepository.findById(id);
        return virtualWalletResult.map(
                        virtualWallet -> new ResponseData<>(VirtualWalletConverter.fromVirtualWallet_to_VirtualWalletDTO(virtualWallet),
                                VirtualWalletConstants.OK))
                .orElseGet(
                        () -> new ResponseData<>(null, VirtualWalletConstants.USER_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public ResponseData<VirtualWalletDTO> updateVirtualWallet(String number, boolean isMoneyIncome, long value) {
        Optional<VirtualWallet> virtualWallet = virtualWalletRepository.findByNumber(number);
        if(virtualWallet.isPresent()) {
            if (isMoneyIncome) {
                virtualWallet.get().setBalance(virtualWallet.get().getBalance() + value);
            } else {
                virtualWallet.get().setBalance(virtualWallet.get().getBalance() - value);
            }
            VirtualWallet created_v_w = virtualWalletRepository.save(virtualWallet.get());
            return new ResponseData<>(VirtualWalletConverter.fromVirtualWallet_to_VirtualWalletDTO(created_v_w), VirtualWalletConstants.OK);
        }

        return new ResponseData<>();
    }

    @Override
    public void setup(VirtualWalletDTO virtualWalletDTO){

    }
}










