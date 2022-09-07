package com.unla.grpc.services;

import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.dtos.VirtualWalletDTO;

public interface IVirtualWalletService {

    ResponseData<VirtualWalletDTO> createVirtualWallet(String number, long balance, String name, String surname, VirtualWalletDTO virtualWalletDTO);

    ResponseData<VirtualWalletDTO> getVirtualWalletByNumber(String number);

    ResponseData<VirtualWalletDTO> getVirtualWalletByDni(String numDni);

    ResponseData<VirtualWalletDTO> getVirtualWalletById(long id);

    ResponseData<VirtualWalletDTO> updateVirtualWallet(String number, boolean isMoneyIncome, long value);

    void setup(VirtualWalletDTO virtualWalletDTO);
}
