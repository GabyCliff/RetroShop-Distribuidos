package com.unla.grpc.converters;

import com.unla.grpc.dtos.InvoiceDTO;
import com.unla.grpc.models.Invoice;
import com.unla.retroshopservicegrpc.grpc.InvoiceResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class InvoiceConverter {

    public InvoiceConverter(){
    }

    public static Invoice fromInvoiceDTO_to_Invoice(InvoiceDTO invoiceDTO){
        Invoice invoice = new Invoice();
        invoice.setIdBuyer(invoiceDTO.getIdBuyer());
        invoice.setIdSeller(invoiceDTO.getIdSeller());
        invoice.setDatePurchase(invoiceDTO.getDatePurchase());
        invoice.setTotal(invoiceDTO.getTotal());

        return invoice;
    }

    public static InvoiceDTO fromInvoice_to_InvoiceDTO(Invoice invoice){
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setId(invoice.getId());
        invoiceDTO.setIdBuyer(invoice.getIdBuyer());
        invoiceDTO.setIdSeller(invoice.getIdSeller());
        invoiceDTO.setDatePurchase(invoice.getDatePurchase());
        invoiceDTO.setTotal(invoice.getTotal());

        return invoiceDTO;
    }

}
