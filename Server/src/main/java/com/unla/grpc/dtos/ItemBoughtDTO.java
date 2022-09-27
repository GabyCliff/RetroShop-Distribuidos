package com.unla.grpc.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemBoughtDTO {

    long id;

    ProductDTO product;

    long quantity;

    float subtotal;

    long idInvoice;

}
