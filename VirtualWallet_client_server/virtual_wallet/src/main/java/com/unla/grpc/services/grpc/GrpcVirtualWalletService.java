package com.unla.grpc.services.grpc;

import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.dtos.VirtualWalletDTO;
import com.unla.grpc.services.IVirtualWalletService;
import com.unlavirtualwalletservergrpc.grpc.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService //Para que cuando levante la aplicación esto se levante como un servicio de Spring y permita levantar el servidor
@Slf4j
public class GrpcVirtualWalletService extends virtualWalletServiceGrpc.virtualWalletServiceImplBase {
    @Autowired
    private IVirtualWalletService iVirtualWalletService;

    @Override
    public void createNewVirtualWallet(VirtualWalletRequest request, StreamObserver<ResponseObjectVirtualWalletData> responseObserver) {
        VirtualWalletDTO virtualWalletDTO = new VirtualWalletDTO();
        virtualWalletDTO.setNumber(request.getNumber());
        virtualWalletDTO.setBalance(request.getBalance());
        virtualWalletDTO.setName(request.getName());
        virtualWalletDTO.setSurname(request.getSurname());
        virtualWalletDTO.setDni(request.getDni());
        virtualWalletDTO.setValidFrom(request.getValidFrom());
        virtualWalletDTO.setValidUntil(request.getValidUntil());

        ResponseData<VirtualWalletDTO> virtualWalletDTOResponseData = iVirtualWalletService.createVirtualWallet(request.getNumber(), request.getBalance(), request.getName(), request.getSurname(), virtualWalletDTO);
        log.info(virtualWalletDTOResponseData.toString());

        responseObserver.onNext(buildGrpcVirtualWallet(virtualWalletDTOResponseData));
        responseObserver.onCompleted();
    }

    @Override
    public void findOneById(id request, StreamObserver<ResponseObjectVirtualWalletData> responseObserver) {
        //super.findOneById(request, responseObserver);
        ResponseData<VirtualWalletDTO> virtualWalletDTOResponseData = iVirtualWalletService.getVirtualWalletById(request.getId());
        log.info(virtualWalletDTOResponseData.toString());

        responseObserver.onNext(buildGrpcVirtualWallet(virtualWalletDTOResponseData));
        responseObserver.onCompleted();
    }

    @Override
    public void findVirtualWalletByNumber(number request, StreamObserver<ResponseObjectVirtualWalletData> responseObserver) {
        //super.findVirtualWalletByNumber(request, responseObserver);
        ResponseData<VirtualWalletDTO> virtualWalletDTOResponseData = iVirtualWalletService.getVirtualWalletByNumber(request.getNumber());
        log.info(virtualWalletDTOResponseData.toString());

        responseObserver.onNext(buildGrpcVirtualWallet(virtualWalletDTOResponseData));
        responseObserver.onCompleted();
    }

    @Override
    public void updateVirtualWallet(DataToUpdateRequest request, StreamObserver<ResponseObjectVirtualWalletData> responseObserver) {
        ResponseData<VirtualWalletDTO> virtualWalletDTOResponseData = iVirtualWalletService.updateVirtualWallet(request.getNumber(),
                request.getIsMoneyIncome(), request.getValue());
        log.info(virtualWalletDTOResponseData.toString());
        if(!virtualWalletDTOResponseData.isEmptyData()){
            responseObserver.onNext(buildGrpcVirtualWallet(virtualWalletDTOResponseData));
        }else {
            responseObserver.onNext(null);
        }
        responseObserver.onCompleted();
    }


    private ResponseObjectVirtualWalletData buildGrpcVirtualWallet(ResponseData<VirtualWalletDTO> virtualWalletDTOResponseData){
        VirtualWalletResponse virtualWalletResponse = VirtualWalletResponse.newBuilder().build();
        if(!virtualWalletDTOResponseData.isEmptyData()){
            virtualWalletResponse = VirtualWalletResponse.newBuilder()
                    .setId(virtualWalletDTOResponseData.getData().getId())
                    .setNumber(virtualWalletDTOResponseData.getData().getNumber())
                    .setBalance(virtualWalletDTOResponseData.getData().getBalance())
                    .setName(virtualWalletDTOResponseData.getData().getName())
                    .setSurname(virtualWalletDTOResponseData.getData().getSurname())
                    .setDni(virtualWalletDTOResponseData.getData().getDni())
                    .setValidFrom(virtualWalletDTOResponseData.getData().getValidFrom())
                    .setValidUntil(virtualWalletDTOResponseData.getData().getValidUntil())
                    .build();
        }

        TransactionMessage description = TransactionMessage.newBuilder()
                .setMessage(virtualWalletDTOResponseData.getMessage())
                .build();
        return ResponseObjectVirtualWalletData.newBuilder()
                .setVirtualWalletResponse(virtualWalletResponse)
                .setDescription(description)
                .build();
    }
}
