package com.unla.grpc.services.implementations;

import com.unla.grpc.constants.Constants;
import com.unla.grpc.converters.VirtualWalletConverter;
import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.dtos.VirtualWalletDTO;
import com.unla.grpc.models.User;
import com.unla.grpc.models.VirtualWallet;
import com.unla.grpc.repositories.UserRepository;
import com.unla.grpc.repositories.VirtualWalletRepository;

import com.unla.grpc.services.interfaces.IVirtualWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VirtualWalletService implements IVirtualWalletService {

    @Autowired
    private VirtualWalletRepository virtualWalletRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseData<VirtualWalletDTO> createVirtualWallet(VirtualWalletDTO virtualWalletDTO){
        Optional<User> user = userRepository.findById(virtualWalletDTO.getIdUser());
        if (user.isPresent()) {
            Optional<VirtualWallet> virtualWalletResult = virtualWalletRepository.findByIdUser(virtualWalletDTO.getIdUser());
            if(virtualWalletResult.isPresent()){
                return new ResponseData<>(null, Constants.USER_ALREADY_VIRTUAL_WALLET_MESSAGE);
            } else {
                VirtualWallet created_v_w = virtualWalletRepository.save(VirtualWalletConverter.fromVirtualWalletDTO_to_VirtualWallet(virtualWalletDTO));
                return new ResponseData<>(VirtualWalletConverter.fromVirtualWallet_to_VirtualWalletDTO(created_v_w), Constants.OK);
            }
        } else {
            return new ResponseData<>(null, Constants.USER_NO_REGISTERED_MESSAGE);
        }
    }

    @Override
    public ResponseData<VirtualWalletDTO> getByIdUser(long idUser){
        Optional<VirtualWallet> virtualWalletResult = virtualWalletRepository.findByIdUser(idUser);
        return virtualWalletResult.map(
                        virtualWallet -> new ResponseData<>(VirtualWalletConverter.fromVirtualWallet_to_VirtualWalletDTO(virtualWallet),
                                Constants.OK))
                .orElseGet(
                        () -> new ResponseData<>(null, Constants.VIRTUAL_WALLET_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public ResponseData<VirtualWalletDTO> getById(long id){
        Optional<VirtualWallet> virtualWalletResult = virtualWalletRepository.findById(id);
        return virtualWalletResult.map(
                        virtualWallet -> new ResponseData<>(VirtualWalletConverter.fromVirtualWallet_to_VirtualWalletDTO(virtualWallet),
                                Constants.OK))
                .orElseGet(
                        () -> new ResponseData<>(null, Constants.VIRTUAL_WALLET_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public ResponseData<VirtualWalletDTO> update(long idUser, boolean isMoneyIncome, long value) {
        Optional<VirtualWallet> virtualWallet = virtualWalletRepository.findByIdUser(idUser);
        if(virtualWallet.isPresent()) {
            if (isMoneyIncome) {
                virtualWallet.get().setBalance(virtualWallet.get().getBalance() + value);
            } else {
                virtualWallet.get().setBalance(virtualWallet.get().getBalance() - value);
            }
            VirtualWallet created_v_w = virtualWalletRepository.save(virtualWallet.get());
            return new ResponseData<>(VirtualWalletConverter.fromVirtualWallet_to_VirtualWalletDTO(created_v_w), Constants.OK);
        }

        return new ResponseData<>();
    }

    @Override
    public void setup(VirtualWalletDTO virtualWalletDTO){

    }
}










