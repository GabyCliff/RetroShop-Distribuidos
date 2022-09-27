package com.unla.grpc.services.interfaces;

import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.dtos.InvoiceDTO;
import com.unla.retroshopservicegrpc.grpc.InvoiceResponse;
import java.util.List;

public interface IInvoiceService {

    ResponseData<InvoiceDTO> createNewInvoice(InvoiceDTO invoiceDTO);

    ResponseData<InvoiceDTO> getListByIdBuyer(long idUserBuyer);

    ResponseData<InvoiceDTO> getListByIdSeller(long idUserSeller);

    ResponseData<InvoiceDTO> getById(long id);

    InvoiceResponse getInvoiceResponseById(long id);

    ResponseData<InvoiceDTO> update(long id, float total);

    public void setup(InvoiceDTO invoiceDTO);

    List<InvoiceDTO> getInvoicesByBuyer(long userId);

}
