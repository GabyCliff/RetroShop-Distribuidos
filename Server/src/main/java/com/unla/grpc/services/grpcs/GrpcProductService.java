package com.unla.grpc.services.grpcs;

import com.unla.grpc.converters.DateConverter;
import com.unla.grpc.dtos.ProductDTO;
import com.unla.grpc.services.implementations.ProductService;
import com.unla.retroshopservicegrpc.grpc.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@GrpcService
public class GrpcProductService extends productServiceGrpc.productServiceImplBase {

    @Autowired
    ProductService productService;

    @Override
    public void saveProduct(ProductSaveRequest request, StreamObserver<Response> responseObserver) {

        ProductDTO productAux = new ProductDTO();

        productAux.setName(request.getName());
        productAux.setDescription(request.getDescription());
        productAux.setPhotos(request.getListPhotoList());
        productAux.setPrice(request.getPrice());
        productAux.setQuantity(request.getQuantity());
        productAux.setDate(DateConverter.fromString_to_LocalDate(request.getDate()));
        productAux.setIdUser(request.getIdUser());
        productAux.setCategory(request.getCategory());

        HttpStatus state = productService.saveProduct(productAux).getStatusCode();

        Response responseUser = Response.newBuilder()
                .setMessage(String.valueOf(state))
                .build();

        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();
    }

    @Override
    public void updateProduct(ProductUpdateRequest request, StreamObserver<Response> responseObserver) {

        ProductDTO productAux = productService.getProduct(request.getId());

        productAux.setName(request.getName());
        productAux.setDescription(request.getDescription());
        productAux.setPhotos(request.getListPhotoList());
        productAux.setPrice(request.getPrice());
        productAux.setQuantity(request.getQuantity());
        productAux.setQuantity(request.getQuantity());
        productAux.setDate(DateConverter.fromString_to_LocalDate(request.getDate()));
        productAux.setIdUser(request.getIdUser());
        productAux.setCategory(request.getCategory());

        HttpStatus state = productService.saveProduct(productAux).getStatusCode();

        Response responseUser = Response.newBuilder()
                .setMessage(String.valueOf(state))
                .build();

        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();
    }

    @Override
    public void getProduct(IdProduct request, StreamObserver<ProductResponse> responseObserver) {
        ProductDTO productAux = productService.getProduct(request.getIdProduct());
        setAttributesProductResponse(productAux, responseObserver);
    }

    @Override
    public void findByIdUser(IdUserInProduct request, StreamObserver<ProductResponseList> responseObserver) {
        super.findByIdUser(request, responseObserver);
       // List<ProductDTO> productDTOList = productService.getByIdUser(request.getIdUser());
    }

    @Override
    public void getAll(EmptyProduct request, StreamObserver<ProductResponseList> responseObserver) {
        super.getAll(request, responseObserver);
    }

    public void setAttributesProductResponse(ProductDTO productAux, StreamObserver<ProductResponse> responseObserver){
        ProductResponse productResponse = productService.getProductResponseById(productAux.getId());
        responseObserver.onNext(productResponse);
        responseObserver.onCompleted();
    }

}