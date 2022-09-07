package com.unla.grpc.constants;

public class UserConstants {

    private UserConstants() {
    }

    public static final String OK = "OK";

    public static final String ACCESS_VALIDATION_ERROR_MESSAGE = "Incorrect user and pass OR Permission insufficient";
    public static final String USER_NOT_FOUND_ERROR_MESSAGE = "User not found";
    public static final String REQUEST_NAME_ERROR_MESSAGE = "The field 'name' is mandatory";
    public static final String REQUEST_SURNAME_ERROR_MESSAGE = "The field 'surname' is mandatory";
    public static final String REQUEST_DNI_ERROR_MESSAGE = "The field 'dni' is mandatory";
    public static final String REQUEST_USERNAME_ERROR_MESSAGE = "The field 'username' is mandatory";
    public static final String REQUEST_PASS_ERROR_MESSAGE = "The field 'password' is mandatory";
    public static final String REQUEST_EMAIL_ERROR_MESSAGE = "The field 'email' is mandatory";
    public static final String DUPLICATED_USER_ERROR_MESSAGE = "The user already exists";

}
