package com.unla.grpc.services.grpcs;

import com.unla.grpc.converters.DateConverter;
import com.unla.grpc.dtos.InvoiceDTO;
import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.services.implementations.UserService;
import com.unla.grpc.services.interfaces.IInvoiceService;
import com.unla.retroshopservicegrpc.grpc.*;
import io.grpc.stub.StreamObserver;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
@Slf4j
public class GrpcInvoiceService extends invoiceServiceGrpc.invoiceServiceImplBase {

    @Autowired
    IInvoiceService iInvoiceService;
    @Autowired
    UserService userService;

    @Override
    public void findOneById(IdInvoice request, StreamObserver<ResponseObjectInvoiceData> responseObserver) {
        responseObserver.onNext(buildGrpcInvoice(iInvoiceService.getById(request.getIdInvoice())));
        responseObserver.onCompleted();
    }

    @Override
    public void findListByIdBuyer(IdUserBuyer request, StreamObserver<ResponseObjectInvoiceDataList> responseObserver) {
        //super.findListByIdBuyer(request, responseObserver);
    }

    @Override
    public void findListByIdSeller(IdUserSeller request, StreamObserver<ResponseObjectInvoiceDataList> responseObserver) {
        //super.findListByIdSeller(request, responseObserver);
    }


    @Override
    public void findListByDatePurchase(DatePurchase request, StreamObserver<ResponseObjectInvoiceDataList> responseObserver) {
        //super.findListByDatePurchase(request, responseObserver);
    }

    @Override
    public void createNewInvoice(InvoiceRequest request, StreamObserver<ResponseObjectInvoiceData> responseObserver) {
        //super.createNewInvoice(request, responseObserver);
        String datePurchase = request.getDatePurchase();
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setDatePurchase(DateConverter.fromString_to_LocalDate(datePurchase));
        invoiceDTO.setIdBuyer(request.getIdUserBuyer());
        invoiceDTO.setIdSeller(request.getIdUserSeller());
        invoiceDTO.setTotal(request.getTotal());

        ResponseData<InvoiceDTO> invoiceDTOResponseData = iInvoiceService.createNewInvoice(invoiceDTO);

        responseObserver.onNext(buildGrpcInvoice(invoiceDTOResponseData));
        responseObserver.onCompleted();


    }

    @Override
    public void updateInvoice(DataInvoiceToUpdateRequest request, StreamObserver<ResponseObjectInvoiceData> responseObserver) {
        //super.updateInvoice(request, responseObserver);
        ResponseData<InvoiceDTO> invoiceDTOResponseData = iInvoiceService.update(request.getId(), request.getTotal());
        log.info(invoiceDTOResponseData.toString());
        if(!invoiceDTOResponseData.isEmptyData()){
            responseObserver.onNext(buildGrpcInvoice(invoiceDTOResponseData));
        }else {
            responseObserver.onNext(null);
        }
        responseObserver.onCompleted();
    }

    private ResponseObjectInvoiceData buildGrpcInvoice(ResponseData<InvoiceDTO> invoiceDTOResponseData){
        InvoiceResponse invoiceResponse = InvoiceResponse.newBuilder().build();
        if(!invoiceDTOResponseData.isEmptyData()){
            invoiceResponse = iInvoiceService.getInvoiceResponseById(invoiceDTOResponseData.getData().getId());
        }
        TransactionMessageInvoice description = TransactionMessageInvoice.newBuilder()
                .setMessage(invoiceDTOResponseData.getMessage())
                .build();
        return ResponseObjectInvoiceData.newBuilder()
                .setInvoiceResponse(invoiceResponse)
                .setDescription(description)
                .build();
    }


    private ResponseObjectInvoiceDataList buildGrpcInvoiceList(
            ResponseData<InvoiceDTO> invoiceDTOResponseData){
        InvoiceResponse invoiceResponse = InvoiceResponse.newBuilder().build();
        if(!invoiceDTOResponseData.isEmptyData()){
            invoiceResponse = InvoiceResponse.newBuilder()
                    .setId(invoiceDTOResponseData.getData().getId())
                    .build();
        }
        TransactionMessageInvoice description = TransactionMessageInvoice.newBuilder()
                .setMessage(invoiceDTOResponseData.getMessage())
                .build();
        return ResponseObjectInvoiceDataList.newBuilder()
                .build();
    }


}
