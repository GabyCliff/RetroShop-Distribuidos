package com.unla.grpc.dtos;

import lombok.Data;

@Data
public class VirtualWalletDTO {

    private long id;

    private long balance;

    private long idUser;

}
