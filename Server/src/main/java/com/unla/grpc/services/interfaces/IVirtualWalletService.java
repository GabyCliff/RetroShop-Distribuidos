package com.unla.grpc.services.interfaces;

import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.dtos.VirtualWalletDTO;

public interface IVirtualWalletService {

    ResponseData<VirtualWalletDTO> createVirtualWallet(VirtualWalletDTO virtualWalletDTO);

    ResponseData<VirtualWalletDTO> getByIdUser(long idUser);

    ResponseData<VirtualWalletDTO> getById(long id);

    ResponseData<VirtualWalletDTO> update(long idUser, boolean isMoneyIncome, long value);

    void setup(VirtualWalletDTO virtualWalletDTO);
}
