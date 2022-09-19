package com.unla.grpc.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {

    private long id;

    private long idBuyer;

    private long idSeller;

    private float total;

    private LocalDate datePurchase;
    
}
