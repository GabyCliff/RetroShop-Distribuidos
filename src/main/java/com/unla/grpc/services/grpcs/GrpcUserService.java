package com.unla.grpc.services.grpcs;

import com.unla.grpc.dtos.UserDTO;
import com.unla.grpc.services.IUserService;
import com.unlauserservergrpc.grpc.UserObject;
import com.unlauserservergrpc.grpc.userServiceGrpc.userServiceImplBase;
import com.unlauserservergrpc.grpc.username;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class GrpcUserService extends userServiceImplBase {

    @Autowired
    private IUserService userService;

    @Override
    public void getOneByUsername(username request, StreamObserver<UserObject> responseObserver) {

        UserDTO user = userService.getUser(request.getUsername());

        UserObject object = UserObject.newBuilder()
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setEmail(user.getEmail())
                .build();
        responseObserver.onNext(object);
        responseObserver.onCompleted();
    }
}
