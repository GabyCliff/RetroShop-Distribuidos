package com.unla.grpc.services.grpcs;

import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.dtos.UserDTO;
import com.unla.grpc.services.IUserService;
import com.unlauserservergrpc.grpc.CurrentUser;
import com.unlauserservergrpc.grpc.ResponseObjectUserData;
import com.unlauserservergrpc.grpc.TransactionMessage;
import com.unlauserservergrpc.grpc.UserRequest;
import com.unlauserservergrpc.grpc.UserResponse;
import com.unlauserservergrpc.grpc.UserToFind;
import com.unlauserservergrpc.grpc.userServiceGrpc.userServiceImplBase;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
@Slf4j
public class GrpcUserService extends userServiceImplBase {

    @Autowired
    private IUserService userService;

    @Override
    public void createNewUser(UserRequest request,
            StreamObserver<ResponseObjectUserData> responseObserver) {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(request.getUsername());
        userDTO.setPassword(request.getPassword());
        userDTO.setName(request.getName());
        userDTO.setSurname(request.getSurname());
        userDTO.setEmail(request.getEmail());
        userDTO.setDni(request.getDni());

        ResponseData<UserDTO> userData = userService.createUser(request.getUsernameAdmin(), request.getPasswordAdmin(), userDTO);
        log.info(userData.toString());

        responseObserver.onNext(buildGrpcUserResponse(userData));
        responseObserver.onCompleted();
    }

    @Override
    public void findCurrentUser(CurrentUser request,
            StreamObserver<ResponseObjectUserData> responseObserver) {

        ResponseData<UserDTO> userData = userService.getCurrentUser(request.getUsername(), request.getPassword());
        log.info(userData.toString());

        responseObserver.onNext(buildGrpcUserResponse(userData));
        responseObserver.onCompleted();
    }

    @Override
    public void findUserByUsername(UserToFind request,
            StreamObserver<ResponseObjectUserData> responseObserver) {

        ResponseData<UserDTO> userData = userService.getUser(request.getUsername(), request.getPassword(),
                request.getUsernameToFind());
        log.info(userData.toString());

        responseObserver.onNext(buildGrpcUserResponse(userData));
        responseObserver.onCompleted();
    }

    private ResponseObjectUserData buildGrpcUserResponse(ResponseData<UserDTO> userData){

        UserResponse userResponse = UserResponse.newBuilder().build();
        if (!userData.isEmptyData()){
            userResponse = UserResponse.newBuilder()
                    .setId(userData.getData().getId())
                    .setDni(userData.getData().getDni())
                    .setUsername(userData.getData().getUsername())
                    .setName(userData.getData().getName())
                    .setSurname(userData.getData().getSurname())
                    .setEmail(userData.getData().getEmail())
                    .setRole(userData.getData().getRole())
                    .build();
        }

        TransactionMessage description = TransactionMessage.newBuilder()
                .setMessge(userData.getMessage())
                .build();

        return ResponseObjectUserData.newBuilder()
                .setUser(userResponse)
                .setDescription(description)
                .build();
    }
}
