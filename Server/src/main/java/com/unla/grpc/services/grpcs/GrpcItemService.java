package com.unla.grpc.services.grpcs;

import com.unla.grpc.dtos.ItemDTO;
import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.services.implementations.InvoiceService;
import com.unla.grpc.services.implementations.ProductService;
import com.unla.grpc.services.interfaces.IItemService;
import com.unla.retroshopservicegrpc.grpc.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
@Slf4j
public class GrpcItemService extends itemServiceGrpc.itemServiceImplBase{
    @Autowired
    private IItemService iItemService;
    @Autowired
    ProductService productService;
    @Autowired
    InvoiceService invoiceService;

    @Override
    public void findOneById(IdItem request, StreamObserver<ResponseObjectItemData> responseObserver) {
        //super.findOneById(request, responseObserver);
        ResponseData<ItemDTO> itemDTOResponseData = iItemService.getById(request.getIdItem());
        log.info(itemDTOResponseData.toString());

        responseObserver.onNext(buildGrpcItem(itemDTOResponseData));
        responseObserver.onCompleted();
    }

    @Override
    public void findListByIdInvoice(IdInvoiceInItem request, StreamObserver<ResponseObjectItemDataList> responseObserver) {
        //super.findListByInvoice(request, responseObserver);
        ResponseData<ItemDTO> itemDTOResponseData = iItemService.getListByIdInvoice(request.getIdInvoice());
        log.info(itemDTOResponseData.toString());

        responseObserver.onNext(buildGrpcItemList(itemDTOResponseData));
        responseObserver.onCompleted();
    }

    public void createNewItem(ItemRequest request, StreamObserver<ResponseObjectItemData> responseObserver) {
        //super.createNewItem(request, responseObserver);
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setIdProduct(request.getIdProduct());
        itemDTO.setIdInvoice(request.getIdInvoice());
        itemDTO.setQuantity(request.getQuantity());
        itemDTO.setSubtotal(request.getSubTotal());

        ResponseData<ItemDTO> itemDTOResponseData = iItemService.createItem(itemDTO);
        responseObserver.onNext(buildGrpcItem(itemDTOResponseData));
        responseObserver.onCompleted();
    }

    @Override
    public void updateItem(DataItemToUpdateRequest request, StreamObserver<ResponseObjectItemData> responseObserver) {
        //super.updateItem(request, responseObserver);
        ResponseData<ItemDTO> itemDTOResponseData = iItemService.update(request.getId(), request.getQuantity(), request.getSubTotal());
        log.info(itemDTOResponseData.toString());
        if(!itemDTOResponseData.isEmptyData()){
            responseObserver.onNext(buildGrpcItem(itemDTOResponseData));
        }else {
            responseObserver.onNext(null);
        }
        responseObserver.onCompleted();
    }


    private ResponseObjectItemData buildGrpcItem(ResponseData<ItemDTO> itemDTOResponseData){
        ItemResponse itemResponse = ItemResponse.newBuilder().build();
        if(!itemDTOResponseData.isEmptyData()){
            itemResponse = ItemResponse.newBuilder()
                    .setId(itemDTOResponseData.getData().getId())
                    .setInvoiceResponse( invoiceService.getInvoiceResponseById(itemDTOResponseData.getData().getIdInvoice()))
                    .setProductResponse( productService.getProductResponseById(itemDTOResponseData.getData().getIdProduct()))
                    .setQuantity(itemDTOResponseData.getData().getQuantity())
                    .setSubTotal(itemDTOResponseData.getData().getSubtotal())
                    .build();
        }
        TransactionMessageItem description = TransactionMessageItem.newBuilder()
                .setMessage(itemDTOResponseData.getMessage())
                .build();
        return ResponseObjectItemData.newBuilder()
                .setItemResponse(itemResponse)
                .setDescription(description)
                .build();
    }

    private ResponseObjectItemDataList buildGrpcItemList(
            ResponseData<ItemDTO> itemDTOResponseData){
        ItemResponse itemResponse = ItemResponse.newBuilder().build();
        if(!itemDTOResponseData.isEmptyData()){
            itemResponse = ItemResponse.newBuilder()
                    .setId(itemDTOResponseData.getData().getId())
                    .setQuantity(itemDTOResponseData.getData().getQuantity())
                    .setSubTotal(itemDTOResponseData.getData().getSubtotal())
                    .build();
        }

        TransactionMessageItem description = TransactionMessageItem.newBuilder()
                .setMessage(itemDTOResponseData.getMessage())
                .build();
        return ResponseObjectItemDataList.newBuilder()
                .build();
    }
    
}
