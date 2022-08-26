package com.unlauserservergrpc.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.1)",
    comments = "Source: usergrpc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class userServiceGrpc {

  private userServiceGrpc() {}

  public static final String SERVICE_NAME = "userService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.CurrentUser,
      com.unlauserservergrpc.grpc.ResponseObjectUserData> getFindCurrentUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findCurrentUser",
      requestType = com.unlauserservergrpc.grpc.CurrentUser.class,
      responseType = com.unlauserservergrpc.grpc.ResponseObjectUserData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.CurrentUser,
      com.unlauserservergrpc.grpc.ResponseObjectUserData> getFindCurrentUserMethod() {
    io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.CurrentUser, com.unlauserservergrpc.grpc.ResponseObjectUserData> getFindCurrentUserMethod;
    if ((getFindCurrentUserMethod = userServiceGrpc.getFindCurrentUserMethod) == null) {
      synchronized (userServiceGrpc.class) {
        if ((getFindCurrentUserMethod = userServiceGrpc.getFindCurrentUserMethod) == null) {
          userServiceGrpc.getFindCurrentUserMethod = getFindCurrentUserMethod =
              io.grpc.MethodDescriptor.<com.unlauserservergrpc.grpc.CurrentUser, com.unlauserservergrpc.grpc.ResponseObjectUserData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "findCurrentUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlauserservergrpc.grpc.CurrentUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlauserservergrpc.grpc.ResponseObjectUserData.getDefaultInstance()))
              .setSchemaDescriptor(new userServiceMethodDescriptorSupplier("findCurrentUser"))
              .build();
        }
      }
    }
    return getFindCurrentUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.UserToFind,
      com.unlauserservergrpc.grpc.ResponseObjectUserData> getFindUserByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findUserByUsername",
      requestType = com.unlauserservergrpc.grpc.UserToFind.class,
      responseType = com.unlauserservergrpc.grpc.ResponseObjectUserData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.UserToFind,
      com.unlauserservergrpc.grpc.ResponseObjectUserData> getFindUserByUsernameMethod() {
    io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.UserToFind, com.unlauserservergrpc.grpc.ResponseObjectUserData> getFindUserByUsernameMethod;
    if ((getFindUserByUsernameMethod = userServiceGrpc.getFindUserByUsernameMethod) == null) {
      synchronized (userServiceGrpc.class) {
        if ((getFindUserByUsernameMethod = userServiceGrpc.getFindUserByUsernameMethod) == null) {
          userServiceGrpc.getFindUserByUsernameMethod = getFindUserByUsernameMethod =
              io.grpc.MethodDescriptor.<com.unlauserservergrpc.grpc.UserToFind, com.unlauserservergrpc.grpc.ResponseObjectUserData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "findUserByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlauserservergrpc.grpc.UserToFind.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlauserservergrpc.grpc.ResponseObjectUserData.getDefaultInstance()))
              .setSchemaDescriptor(new userServiceMethodDescriptorSupplier("findUserByUsername"))
              .build();
        }
      }
    }
    return getFindUserByUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.UserRequest,
      com.unlauserservergrpc.grpc.ResponseObjectUserData> getCreateNewUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createNewUser",
      requestType = com.unlauserservergrpc.grpc.UserRequest.class,
      responseType = com.unlauserservergrpc.grpc.ResponseObjectUserData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.UserRequest,
      com.unlauserservergrpc.grpc.ResponseObjectUserData> getCreateNewUserMethod() {
    io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.UserRequest, com.unlauserservergrpc.grpc.ResponseObjectUserData> getCreateNewUserMethod;
    if ((getCreateNewUserMethod = userServiceGrpc.getCreateNewUserMethod) == null) {
      synchronized (userServiceGrpc.class) {
        if ((getCreateNewUserMethod = userServiceGrpc.getCreateNewUserMethod) == null) {
          userServiceGrpc.getCreateNewUserMethod = getCreateNewUserMethod =
              io.grpc.MethodDescriptor.<com.unlauserservergrpc.grpc.UserRequest, com.unlauserservergrpc.grpc.ResponseObjectUserData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createNewUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlauserservergrpc.grpc.UserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlauserservergrpc.grpc.ResponseObjectUserData.getDefaultInstance()))
              .setSchemaDescriptor(new userServiceMethodDescriptorSupplier("createNewUser"))
              .build();
        }
      }
    }
    return getCreateNewUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static userServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<userServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<userServiceStub>() {
        @java.lang.Override
        public userServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new userServiceStub(channel, callOptions);
        }
      };
    return userServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static userServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<userServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<userServiceBlockingStub>() {
        @java.lang.Override
        public userServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new userServiceBlockingStub(channel, callOptions);
        }
      };
    return userServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static userServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<userServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<userServiceFutureStub>() {
        @java.lang.Override
        public userServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new userServiceFutureStub(channel, callOptions);
        }
      };
    return userServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class userServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findCurrentUser(com.unlauserservergrpc.grpc.CurrentUser request,
        io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.ResponseObjectUserData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindCurrentUserMethod(), responseObserver);
    }

    /**
     */
    public void findUserByUsername(com.unlauserservergrpc.grpc.UserToFind request,
        io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.ResponseObjectUserData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindUserByUsernameMethod(), responseObserver);
    }

    /**
     */
    public void createNewUser(com.unlauserservergrpc.grpc.UserRequest request,
        io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.ResponseObjectUserData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateNewUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindCurrentUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.unlauserservergrpc.grpc.CurrentUser,
                com.unlauserservergrpc.grpc.ResponseObjectUserData>(
                  this, METHODID_FIND_CURRENT_USER)))
          .addMethod(
            getFindUserByUsernameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.unlauserservergrpc.grpc.UserToFind,
                com.unlauserservergrpc.grpc.ResponseObjectUserData>(
                  this, METHODID_FIND_USER_BY_USERNAME)))
          .addMethod(
            getCreateNewUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.unlauserservergrpc.grpc.UserRequest,
                com.unlauserservergrpc.grpc.ResponseObjectUserData>(
                  this, METHODID_CREATE_NEW_USER)))
          .build();
    }
  }

  /**
   */
  public static final class userServiceStub extends io.grpc.stub.AbstractAsyncStub<userServiceStub> {
    private userServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected userServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new userServiceStub(channel, callOptions);
    }

    /**
     */
    public void findCurrentUser(com.unlauserservergrpc.grpc.CurrentUser request,
        io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.ResponseObjectUserData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindCurrentUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findUserByUsername(com.unlauserservergrpc.grpc.UserToFind request,
        io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.ResponseObjectUserData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindUserByUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createNewUser(com.unlauserservergrpc.grpc.UserRequest request,
        io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.ResponseObjectUserData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNewUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class userServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<userServiceBlockingStub> {
    private userServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected userServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new userServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.unlauserservergrpc.grpc.ResponseObjectUserData findCurrentUser(com.unlauserservergrpc.grpc.CurrentUser request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindCurrentUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.unlauserservergrpc.grpc.ResponseObjectUserData findUserByUsername(com.unlauserservergrpc.grpc.UserToFind request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindUserByUsernameMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.unlauserservergrpc.grpc.ResponseObjectUserData createNewUser(com.unlauserservergrpc.grpc.UserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNewUserMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class userServiceFutureStub extends io.grpc.stub.AbstractFutureStub<userServiceFutureStub> {
    private userServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected userServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new userServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.unlauserservergrpc.grpc.ResponseObjectUserData> findCurrentUser(
        com.unlauserservergrpc.grpc.CurrentUser request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindCurrentUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.unlauserservergrpc.grpc.ResponseObjectUserData> findUserByUsername(
        com.unlauserservergrpc.grpc.UserToFind request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindUserByUsernameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.unlauserservergrpc.grpc.ResponseObjectUserData> createNewUser(
        com.unlauserservergrpc.grpc.UserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNewUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_CURRENT_USER = 0;
  private static final int METHODID_FIND_USER_BY_USERNAME = 1;
  private static final int METHODID_CREATE_NEW_USER = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final userServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(userServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_CURRENT_USER:
          serviceImpl.findCurrentUser((com.unlauserservergrpc.grpc.CurrentUser) request,
              (io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.ResponseObjectUserData>) responseObserver);
          break;
        case METHODID_FIND_USER_BY_USERNAME:
          serviceImpl.findUserByUsername((com.unlauserservergrpc.grpc.UserToFind) request,
              (io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.ResponseObjectUserData>) responseObserver);
          break;
        case METHODID_CREATE_NEW_USER:
          serviceImpl.createNewUser((com.unlauserservergrpc.grpc.UserRequest) request,
              (io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.ResponseObjectUserData>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class userServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    userServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.unlauserservergrpc.grpc.Usergrpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("userService");
    }
  }

  private static final class userServiceFileDescriptorSupplier
      extends userServiceBaseDescriptorSupplier {
    userServiceFileDescriptorSupplier() {}
  }

  private static final class userServiceMethodDescriptorSupplier
      extends userServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    userServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (userServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new userServiceFileDescriptorSupplier())
              .addMethod(getFindCurrentUserMethod())
              .addMethod(getFindUserByUsernameMethod())
              .addMethod(getCreateNewUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
