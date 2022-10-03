package com.unla.grpc.services.implementations;

import com.unla.grpc.constants.Constants;
import com.unla.grpc.converters.DateConverter;
import com.unla.grpc.converters.InvoiceConverter;
import com.unla.grpc.converters.UserConverter;
import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.dtos.InvoiceDTO;
import com.unla.grpc.models.Invoice;
import com.unla.grpc.repositories.InvoiceRepository;
import com.unla.grpc.repositories.UserRepository;
import com.unla.grpc.services.interfaces.IInvoiceService;
import com.unla.retroshopservicegrpc.grpc.InvoiceResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService implements IInvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseData<InvoiceDTO> createNewInvoice(InvoiceDTO invoiceDTO) {
        if (userRepository.findById(invoiceDTO.getIdBuyer()).isPresent() && userRepository.findById(invoiceDTO.getIdSeller()).isPresent() ) {
            Invoice createdInvoice = invoiceRepository.save(InvoiceConverter.fromInvoiceDTO_to_Invoice(invoiceDTO));
            return new ResponseData<>(InvoiceConverter.fromInvoice_to_InvoiceDTO(createdInvoice), Constants.OK);
        }else{
            return new ResponseData<>(null, Constants.INVOICE_BUYER_AND_OR_SELLER_NOT_REGISTERED_MESSAGE);
        }
    }

    @Override
    public ResponseData<InvoiceDTO> getListByIdBuyer(long idUserBuyer) {
        Optional<Invoice> invoiceResult = invoiceRepository.findByIdBuyer(idUserBuyer);
        return invoiceResult.map(
                        invoice -> new ResponseData<>(InvoiceConverter.fromInvoice_to_InvoiceDTO(invoice),
                                Constants.OK))
                .orElseGet(
                        () -> new ResponseData<>(null, Constants.INVOICE_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public ResponseData<InvoiceDTO> getListByIdSeller(long idUserSeller) {
        Optional<Invoice> invoiceResult = invoiceRepository.findByIdSeller(idUserSeller);
        return invoiceResult.map(
                        invoice -> new ResponseData<>(InvoiceConverter.fromInvoice_to_InvoiceDTO(invoice),
                                Constants.OK))
                .orElseGet(
                        () -> new ResponseData<>(null, Constants.INVOICE_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public  ResponseData<InvoiceDTO> getById(long id){
         Optional<Invoice> invoiceResult = invoiceRepository.findById(id);
        return invoiceResult.map(
                        invoice -> new ResponseData<>(InvoiceConverter.fromInvoice_to_InvoiceDTO(invoice),
                                Constants.OK))
                .orElseGet(
                        () -> new ResponseData<>(null, Constants.INVOICE_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public ResponseData<InvoiceDTO> update(long id, float total) {
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
        if(invoiceOptional.isPresent()) {
            Invoice invoice = invoiceOptional.get();
            invoice.setTotal(total);
            Invoice created_v_w = invoiceRepository.save(invoice);
            return new ResponseData<>(InvoiceConverter.fromInvoice_to_InvoiceDTO(created_v_w), Constants.OK);
        }

        return new ResponseData<>();
    }

    @Override
    public InvoiceResponse getInvoiceResponseById(long id) {
        ResponseData<InvoiceDTO> invoiceDTOResponseData = getById(id);
        return InvoiceResponse.newBuilder()
                .setId(invoiceDTOResponseData.getData().getId())
                .setDatePurchase(DateConverter.LocalDate_to_String(invoiceDTOResponseData.getData().getDatePurchase()))
                .setTotal(invoiceDTOResponseData.getData().getTotal())
                .setUserBuyer(UserConverter.fromOptionalUser_to_UserResponse(
                        userRepository.findById(invoiceDTOResponseData.getData().getIdBuyer())))
                .setUserSeller(UserConverter.fromOptionalUser_to_UserResponse(
                        userRepository.findById(invoiceDTOResponseData.getData().getIdSeller())))
                .build();
    }

    @Override
    public void setup(InvoiceDTO invoiceDTO){

    }

    @Override
    public List<InvoiceDTO> getInvoicesByBuyer(long userId) {
        return invoiceRepository.findAllByIdBuyer(userId).stream().map(
                InvoiceConverter::fromInvoice_to_InvoiceDTO).collect(
                Collectors.toList());
    }
}
