package com.unla.grpc.services.grpcs;

import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.dtos.VirtualWalletDTO;
import com.unla.grpc.services.interfaces.IVirtualWalletService;
import com.unla.grpc.services.implementations.UserService;
import com.unla.retroshopservicegrpc.grpc.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService //Para que cuando levante la aplicación esto se levante como un servicio de Spring y permita levantar el servidor
@Slf4j
public class GrpcVirtualWalletService extends virtualWalletServiceGrpc.virtualWalletServiceImplBase {
    @Autowired
    private IVirtualWalletService iVirtualWalletService;

    @Autowired
    UserService userService;

    @Override
    public void createNewVirtualWallet(VirtualWalletRequest request, StreamObserver<ResponseObjectVirtualWalletData> responseObserver) {
        VirtualWalletDTO virtualWalletDTO = new VirtualWalletDTO();
        virtualWalletDTO.setIdUser(request.getIdUser());
        virtualWalletDTO.setBalance(request.getBalance());

        ResponseData<VirtualWalletDTO> virtualWalletDTOResponseData = iVirtualWalletService.createVirtualWallet(virtualWalletDTO);
        log.info(virtualWalletDTOResponseData.toString());

        responseObserver.onNext(buildGrpcVirtualWallet(virtualWalletDTOResponseData));
        responseObserver.onCompleted();
    }

    @Override
    public void findOneById(IdVirtualWallet request, StreamObserver<ResponseObjectVirtualWalletData> responseObserver) {
        //super.findOneById(request, responseObserver);
        ResponseData<VirtualWalletDTO> virtualWalletDTOResponseData = iVirtualWalletService.getById(request.getIdVirWall());
        log.info(virtualWalletDTOResponseData.toString());

        responseObserver.onNext(buildGrpcVirtualWallet(virtualWalletDTOResponseData));
        responseObserver.onCompleted();
    }

    @Override
    public void findByIdUser(IdUserInVW request, StreamObserver<ResponseObjectVirtualWalletData> responseObserver) {
        //super.findOneByDni(request, responseObserver);
        ResponseData<VirtualWalletDTO> virtualWalletDTOResponseData = iVirtualWalletService.getByIdUser(request.getIdUser());
        log.info(virtualWalletDTOResponseData.toString());

        responseObserver.onNext(buildGrpcVirtualWallet(virtualWalletDTOResponseData));
        responseObserver.onCompleted();
    }

    @Override
    public void updateVirtualWallet(DataToUpdateRequest request, StreamObserver<ResponseObjectVirtualWalletData> responseObserver) {
        ResponseData<VirtualWalletDTO> virtualWalletDTOResponseData = iVirtualWalletService.update(
                request.getIdUser(), request.getIsMoneyIncome(), request.getValue()
        );
        log.info(virtualWalletDTOResponseData.toString());
        if(!virtualWalletDTOResponseData.isEmptyData()){
            responseObserver.onNext(buildGrpcVirtualWallet(virtualWalletDTOResponseData));
        }else {
            responseObserver.onNext(null);
        }
        responseObserver.onCompleted();
    }


    private ResponseObjectVirtualWalletData buildGrpcVirtualWallet(
            ResponseData<VirtualWalletDTO> virtualWalletDTOResponseData){
        VirtualWalletResponse virtualWalletResponse = VirtualWalletResponse.newBuilder().build();
        if(!virtualWalletDTOResponseData.isEmptyData()){
            virtualWalletResponse = VirtualWalletResponse.newBuilder()
                    .setId(virtualWalletDTOResponseData.getData().getId())
                    .setBalance(virtualWalletDTOResponseData.getData().getBalance())
                    .setUserResponse(userService.getUserResponseById(virtualWalletDTOResponseData.getData().getIdUser()))
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
