package com.unla.grpc.converters;

import java.time.LocalDate;

public class DateConverter {

    private DateConverter(){

    }

    public static LocalDate fromString_to_LocalDate(String strDate) {
        return LocalDate.parse(strDate);
    }

    public static String LocalDate_to_String(LocalDate localDate) {
        return localDate.toString();
    }

}
