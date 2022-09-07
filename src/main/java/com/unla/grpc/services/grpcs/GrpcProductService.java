package com.unla.grpc.services.grpcs;

import com.unla.grpc.dtos.ProductDTO;
import com.unla.grpc.services.ProductService;
import com.unlauserservergrpc.grpc.*;
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
        productAux.setAvailable(request.getAvailable());

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
        productAux.setAvailable(request.getAvailable());

        HttpStatus state = productService.saveProduct(productAux).getStatusCode();

        Response responseUser = Response.newBuilder()
                .setMessage(String.valueOf(state))
                .build();

        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();
    }

}
