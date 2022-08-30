package com.unlavirtualwalletservergrpc.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *defino un servicio
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.1)",
    comments = "Source: virtualVallet_grpc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class virtualWalletServiceGrpc {

  private virtualWalletServiceGrpc() {}

  public static final String SERVICE_NAME = "virtualWalletService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.unlavirtualwalletservergrpc.grpc.id,
      com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> getFindOneByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findOneById",
      requestType = com.unlavirtualwalletservergrpc.grpc.id.class,
      responseType = com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.unlavirtualwalletservergrpc.grpc.id,
      com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> getFindOneByIdMethod() {
    io.grpc.MethodDescriptor<com.unlavirtualwalletservergrpc.grpc.id, com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> getFindOneByIdMethod;
    if ((getFindOneByIdMethod = virtualWalletServiceGrpc.getFindOneByIdMethod) == null) {
      synchronized (virtualWalletServiceGrpc.class) {
        if ((getFindOneByIdMethod = virtualWalletServiceGrpc.getFindOneByIdMethod) == null) {
          virtualWalletServiceGrpc.getFindOneByIdMethod = getFindOneByIdMethod =
              io.grpc.MethodDescriptor.<com.unlavirtualwalletservergrpc.grpc.id, com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "findOneById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlavirtualwalletservergrpc.grpc.id.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData.getDefaultInstance()))
              .setSchemaDescriptor(new virtualWalletServiceMethodDescriptorSupplier("findOneById"))
              .build();
        }
      }
    }
    return getFindOneByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.unlavirtualwalletservergrpc.grpc.number,
      com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> getFindVirtualWalletByNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findVirtualWalletByNumber",
      requestType = com.unlavirtualwalletservergrpc.grpc.number.class,
      responseType = com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.unlavirtualwalletservergrpc.grpc.number,
      com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> getFindVirtualWalletByNumberMethod() {
    io.grpc.MethodDescriptor<com.unlavirtualwalletservergrpc.grpc.number, com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> getFindVirtualWalletByNumberMethod;
    if ((getFindVirtualWalletByNumberMethod = virtualWalletServiceGrpc.getFindVirtualWalletByNumberMethod) == null) {
      synchronized (virtualWalletServiceGrpc.class) {
        if ((getFindVirtualWalletByNumberMethod = virtualWalletServiceGrpc.getFindVirtualWalletByNumberMethod) == null) {
          virtualWalletServiceGrpc.getFindVirtualWalletByNumberMethod = getFindVirtualWalletByNumberMethod =
              io.grpc.MethodDescriptor.<com.unlavirtualwalletservergrpc.grpc.number, com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "findVirtualWalletByNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlavirtualwalletservergrpc.grpc.number.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData.getDefaultInstance()))
              .setSchemaDescriptor(new virtualWalletServiceMethodDescriptorSupplier("findVirtualWalletByNumber"))
              .build();
        }
      }
    }
    return getFindVirtualWalletByNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.unlavirtualwalletservergrpc.grpc.VirtualWalletRequest,
      com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> getCreateNewVirtualWalletMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createNewVirtualWallet",
      requestType = com.unlavirtualwalletservergrpc.grpc.VirtualWalletRequest.class,
      responseType = com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.unlavirtualwalletservergrpc.grpc.VirtualWalletRequest,
      com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> getCreateNewVirtualWalletMethod() {
    io.grpc.MethodDescriptor<com.unlavirtualwalletservergrpc.grpc.VirtualWalletRequest, com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> getCreateNewVirtualWalletMethod;
    if ((getCreateNewVirtualWalletMethod = virtualWalletServiceGrpc.getCreateNewVirtualWalletMethod) == null) {
      synchronized (virtualWalletServiceGrpc.class) {
        if ((getCreateNewVirtualWalletMethod = virtualWalletServiceGrpc.getCreateNewVirtualWalletMethod) == null) {
          virtualWalletServiceGrpc.getCreateNewVirtualWalletMethod = getCreateNewVirtualWalletMethod =
              io.grpc.MethodDescriptor.<com.unlavirtualwalletservergrpc.grpc.VirtualWalletRequest, com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createNewVirtualWallet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlavirtualwalletservergrpc.grpc.VirtualWalletRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData.getDefaultInstance()))
              .setSchemaDescriptor(new virtualWalletServiceMethodDescriptorSupplier("createNewVirtualWallet"))
              .build();
        }
      }
    }
    return getCreateNewVirtualWalletMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.unlavirtualwalletservergrpc.grpc.DataToUpdateRequest,
      com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> getUpdateVirtualWalletMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateVirtualWallet",
      requestType = com.unlavirtualwalletservergrpc.grpc.DataToUpdateRequest.class,
      responseType = com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.unlavirtualwalletservergrpc.grpc.DataToUpdateRequest,
      com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> getUpdateVirtualWalletMethod() {
    io.grpc.MethodDescriptor<com.unlavirtualwalletservergrpc.grpc.DataToUpdateRequest, com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> getUpdateVirtualWalletMethod;
    if ((getUpdateVirtualWalletMethod = virtualWalletServiceGrpc.getUpdateVirtualWalletMethod) == null) {
      synchronized (virtualWalletServiceGrpc.class) {
        if ((getUpdateVirtualWalletMethod = virtualWalletServiceGrpc.getUpdateVirtualWalletMethod) == null) {
          virtualWalletServiceGrpc.getUpdateVirtualWalletMethod = getUpdateVirtualWalletMethod =
              io.grpc.MethodDescriptor.<com.unlavirtualwalletservergrpc.grpc.DataToUpdateRequest, com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateVirtualWallet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlavirtualwalletservergrpc.grpc.DataToUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData.getDefaultInstance()))
              .setSchemaDescriptor(new virtualWalletServiceMethodDescriptorSupplier("updateVirtualWallet"))
              .build();
        }
      }
    }
    return getUpdateVirtualWalletMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static virtualWalletServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<virtualWalletServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<virtualWalletServiceStub>() {
        @java.lang.Override
        public virtualWalletServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new virtualWalletServiceStub(channel, callOptions);
        }
      };
    return virtualWalletServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static virtualWalletServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<virtualWalletServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<virtualWalletServiceBlockingStub>() {
        @java.lang.Override
        public virtualWalletServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new virtualWalletServiceBlockingStub(channel, callOptions);
        }
      };
    return virtualWalletServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static virtualWalletServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<virtualWalletServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<virtualWalletServiceFutureStub>() {
        @java.lang.Override
        public virtualWalletServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new virtualWalletServiceFutureStub(channel, callOptions);
        }
      };
    return virtualWalletServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *defino un servicio
   * </pre>
   */
  public static abstract class virtualWalletServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findOneById(com.unlavirtualwalletservergrpc.grpc.id request,
        io.grpc.stub.StreamObserver<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindOneByIdMethod(), responseObserver);
    }

    /**
     */
    public void findVirtualWalletByNumber(com.unlavirtualwalletservergrpc.grpc.number request,
        io.grpc.stub.StreamObserver<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindVirtualWalletByNumberMethod(), responseObserver);
    }

    /**
     */
    public void createNewVirtualWallet(com.unlavirtualwalletservergrpc.grpc.VirtualWalletRequest request,
        io.grpc.stub.StreamObserver<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateNewVirtualWalletMethod(), responseObserver);
    }

    /**
     */
    public void updateVirtualWallet(com.unlavirtualwalletservergrpc.grpc.DataToUpdateRequest request,
        io.grpc.stub.StreamObserver<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateVirtualWalletMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindOneByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.unlavirtualwalletservergrpc.grpc.id,
                com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData>(
                  this, METHODID_FIND_ONE_BY_ID)))
          .addMethod(
            getFindVirtualWalletByNumberMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.unlavirtualwalletservergrpc.grpc.number,
                com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData>(
                  this, METHODID_FIND_VIRTUAL_WALLET_BY_NUMBER)))
          .addMethod(
            getCreateNewVirtualWalletMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.unlavirtualwalletservergrpc.grpc.VirtualWalletRequest,
                com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData>(
                  this, METHODID_CREATE_NEW_VIRTUAL_WALLET)))
          .addMethod(
            getUpdateVirtualWalletMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.unlavirtualwalletservergrpc.grpc.DataToUpdateRequest,
                com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData>(
                  this, METHODID_UPDATE_VIRTUAL_WALLET)))
          .build();
    }
  }

  /**
   * <pre>
   *defino un servicio
   * </pre>
   */
  public static final class virtualWalletServiceStub extends io.grpc.stub.AbstractAsyncStub<virtualWalletServiceStub> {
    private virtualWalletServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected virtualWalletServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new virtualWalletServiceStub(channel, callOptions);
    }

    /**
     */
    public void findOneById(com.unlavirtualwalletservergrpc.grpc.id request,
        io.grpc.stub.StreamObserver<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindOneByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findVirtualWalletByNumber(com.unlavirtualwalletservergrpc.grpc.number request,
        io.grpc.stub.StreamObserver<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindVirtualWalletByNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createNewVirtualWallet(com.unlavirtualwalletservergrpc.grpc.VirtualWalletRequest request,
        io.grpc.stub.StreamObserver<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNewVirtualWalletMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateVirtualWallet(com.unlavirtualwalletservergrpc.grpc.DataToUpdateRequest request,
        io.grpc.stub.StreamObserver<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVirtualWalletMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *defino un servicio
   * </pre>
   */
  public static final class virtualWalletServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<virtualWalletServiceBlockingStub> {
    private virtualWalletServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected virtualWalletServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new virtualWalletServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData findOneById(com.unlavirtualwalletservergrpc.grpc.id request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindOneByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData findVirtualWalletByNumber(com.unlavirtualwalletservergrpc.grpc.number request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindVirtualWalletByNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData createNewVirtualWallet(com.unlavirtualwalletservergrpc.grpc.VirtualWalletRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNewVirtualWalletMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData updateVirtualWallet(com.unlavirtualwalletservergrpc.grpc.DataToUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVirtualWalletMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *defino un servicio
   * </pre>
   */
  public static final class virtualWalletServiceFutureStub extends io.grpc.stub.AbstractFutureStub<virtualWalletServiceFutureStub> {
    private virtualWalletServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected virtualWalletServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new virtualWalletServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> findOneById(
        com.unlavirtualwalletservergrpc.grpc.id request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindOneByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> findVirtualWalletByNumber(
        com.unlavirtualwalletservergrpc.grpc.number request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindVirtualWalletByNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> createNewVirtualWallet(
        com.unlavirtualwalletservergrpc.grpc.VirtualWalletRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNewVirtualWalletMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData> updateVirtualWallet(
        com.unlavirtualwalletservergrpc.grpc.DataToUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVirtualWalletMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_ONE_BY_ID = 0;
  private static final int METHODID_FIND_VIRTUAL_WALLET_BY_NUMBER = 1;
  private static final int METHODID_CREATE_NEW_VIRTUAL_WALLET = 2;
  private static final int METHODID_UPDATE_VIRTUAL_WALLET = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final virtualWalletServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(virtualWalletServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_ONE_BY_ID:
          serviceImpl.findOneById((com.unlavirtualwalletservergrpc.grpc.id) request,
              (io.grpc.stub.StreamObserver<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData>) responseObserver);
          break;
        case METHODID_FIND_VIRTUAL_WALLET_BY_NUMBER:
          serviceImpl.findVirtualWalletByNumber((com.unlavirtualwalletservergrpc.grpc.number) request,
              (io.grpc.stub.StreamObserver<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData>) responseObserver);
          break;
        case METHODID_CREATE_NEW_VIRTUAL_WALLET:
          serviceImpl.createNewVirtualWallet((com.unlavirtualwalletservergrpc.grpc.VirtualWalletRequest) request,
              (io.grpc.stub.StreamObserver<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData>) responseObserver);
          break;
        case METHODID_UPDATE_VIRTUAL_WALLET:
          serviceImpl.updateVirtualWallet((com.unlavirtualwalletservergrpc.grpc.DataToUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.unlavirtualwalletservergrpc.grpc.ResponseObjectVirtualWalletData>) responseObserver);
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

  private static abstract class virtualWalletServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    virtualWalletServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.unlavirtualwalletservergrpc.grpc.VirtualValletGrpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("virtualWalletService");
    }
  }

  private static final class virtualWalletServiceFileDescriptorSupplier
      extends virtualWalletServiceBaseDescriptorSupplier {
    virtualWalletServiceFileDescriptorSupplier() {}
  }

  private static final class virtualWalletServiceMethodDescriptorSupplier
      extends virtualWalletServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    virtualWalletServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (virtualWalletServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new virtualWalletServiceFileDescriptorSupplier())
              .addMethod(getFindOneByIdMethod())
              .addMethod(getFindVirtualWalletByNumberMethod())
              .addMethod(getCreateNewVirtualWalletMethod())
              .addMethod(getUpdateVirtualWalletMethod())
              .build();
        }
      }
    }
    return result;
  }
}
