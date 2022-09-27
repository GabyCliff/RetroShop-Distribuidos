package com.unla.grpc.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    long id;

    long idProduct;

    long quantity;

    float subtotal;

    long idInvoice;

}
