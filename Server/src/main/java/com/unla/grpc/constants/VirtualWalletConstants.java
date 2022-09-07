package com.unla.grpc.constants;

public class VirtualWalletConstants {

    private  VirtualWalletConstants(){

    }
    public static final String OK  = "Ok";

    public static final String SETUP_OK = "VIRTUAL WALLET SETUP OK";

    public static final String ACCESS_VALIDATION_ERROR_MESSAGE = "Incorrect user and pass OR Permission insufficient";

    public static final String USER_NOT_FOUND_ERROR_MESSAGE = "User not found";

    public static final String REQUEST_NAME_ERROR_MESSAGE = "The field 'name' is mandatory";

    public static final String REQUEST_SURNAME_ERROR_MESSAGE = "The field 'surname' is mandatory";

    public static final String DUPLICATED_VIRTUAL_WALLET_ERROR_MESSAGE = "The user already exists";
}
