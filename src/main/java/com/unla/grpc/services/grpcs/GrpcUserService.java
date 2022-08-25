package com.unla.grpc.services.grpcs;

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
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class GrpcUserService extends userServiceImplBase {

    @Autowired
    private IUserService userService;

    @Override
    public void createUser(UserRequest request,
            StreamObserver<TransactionMessage> responseObserver) {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(request.getUsername());
        userDTO.setPassword(request.getPassword());
        userDTO.setName(request.getName());
        userDTO.setSurname(request.getSurname());
        userDTO.setEmail(request.getEmail());
        userDTO.setDni(request.getDni());

        String result = userService.createUser(request.getUsernameAdmin(), request.getPasswordAdmin(), userDTO);

        TransactionMessage object = TransactionMessage.newBuilder()
                .setMessge(result)
                .build();
        responseObserver.onNext(object);
        responseObserver.onCompleted();
    }

    @Override
    public void findCurrentUser(CurrentUser request,
            StreamObserver<ResponseObjectUserData> responseObserver) {
        UserDTO user = userService.getCurrentUser(request.getUsername(), request.getPassword());

        UserResponse userResponse = UserResponse.newBuilder().build();
        TransactionMessage description = TransactionMessage.newBuilder().build();
        if (user != null){
            userResponse = UserResponse.newBuilder()
                    .setId(user.getId())
                    .setDni(user.getDni())
                    .setUsername(user.getUsername())
                    .setName(user.getName())
                    .setSurname(user.getSurname())
                    .setEmail(user.getEmail())
                    .setRole(user.getRole())
                    .build();
        } else {
            description = TransactionMessage.newBuilder()
                    .setMessge("Incorrect username or password")
                    .build();
        }

        ResponseObjectUserData objectUserData = ResponseObjectUserData.newBuilder()
                .setUser(userResponse)
                .setDescription(description)
                .build();
        responseObserver.onNext(objectUserData);
        responseObserver.onCompleted();
    }

    @Override
    public void findUserByUsername(UserToFind request,
            StreamObserver<ResponseObjectUserData> responseObserver) {
        UserDTO user = userService.getUser(request.getUsername(), request.getPassword(),
                request.getUsernameToFind());

        UserResponse userResponse = UserResponse.newBuilder().build();
        TransactionMessage description = TransactionMessage.newBuilder().build();
        if (user != null){
            userResponse = UserResponse.newBuilder()
                    .setId(user.getId())
                    .setDni(user.getDni())
                    .setUsername(user.getUsername())
                    .setName(user.getName())
                    .setSurname(user.getSurname())
                    .setEmail(user.getEmail())
                    .setRole(user.getRole())
                    .build();
        } else {
            description = TransactionMessage.newBuilder()
                    .setMessge("Incorrect username or password OR Insufficient Permission")
                    .build();
        }

        ResponseObjectUserData objectUserData = ResponseObjectUserData.newBuilder()
                .setUser(userResponse)
                .setDescription(description)
                .build();
        responseObserver.onNext(objectUserData);
        responseObserver.onCompleted();
    }
}
