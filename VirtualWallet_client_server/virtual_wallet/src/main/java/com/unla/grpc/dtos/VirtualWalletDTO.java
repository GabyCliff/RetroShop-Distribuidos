package com.unla.grpc.dtos;

import lombok.Data;

@Data
public class VirtualWalletDTO {

    private long id;

    private String number;

    private long balance;

    private String name;

    private String surname;

    private int dni;

    private String validFrom;

    private String validUntil;

}
