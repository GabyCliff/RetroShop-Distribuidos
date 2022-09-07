package com.unlauserservergrpc.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.1)",
    comments = "Source: productgrpc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class productServiceGrpc {

  private productServiceGrpc() {}

  public static final String SERVICE_NAME = "productService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.ProductSaveRequest,
      com.unlauserservergrpc.grpc.Response> getSaveProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveProduct",
      requestType = com.unlauserservergrpc.grpc.ProductSaveRequest.class,
      responseType = com.unlauserservergrpc.grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.ProductSaveRequest,
      com.unlauserservergrpc.grpc.Response> getSaveProductMethod() {
    io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.ProductSaveRequest, com.unlauserservergrpc.grpc.Response> getSaveProductMethod;
    if ((getSaveProductMethod = productServiceGrpc.getSaveProductMethod) == null) {
      synchronized (productServiceGrpc.class) {
        if ((getSaveProductMethod = productServiceGrpc.getSaveProductMethod) == null) {
          productServiceGrpc.getSaveProductMethod = getSaveProductMethod =
              io.grpc.MethodDescriptor.<com.unlauserservergrpc.grpc.ProductSaveRequest, com.unlauserservergrpc.grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "saveProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlauserservergrpc.grpc.ProductSaveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlauserservergrpc.grpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new productServiceMethodDescriptorSupplier("saveProduct"))
              .build();
        }
      }
    }
    return getSaveProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.ProductUpdateRequest,
      com.unlauserservergrpc.grpc.Response> getUpdateProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateProduct",
      requestType = com.unlauserservergrpc.grpc.ProductUpdateRequest.class,
      responseType = com.unlauserservergrpc.grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.ProductUpdateRequest,
      com.unlauserservergrpc.grpc.Response> getUpdateProductMethod() {
    io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.ProductUpdateRequest, com.unlauserservergrpc.grpc.Response> getUpdateProductMethod;
    if ((getUpdateProductMethod = productServiceGrpc.getUpdateProductMethod) == null) {
      synchronized (productServiceGrpc.class) {
        if ((getUpdateProductMethod = productServiceGrpc.getUpdateProductMethod) == null) {
          productServiceGrpc.getUpdateProductMethod = getUpdateProductMethod =
              io.grpc.MethodDescriptor.<com.unlauserservergrpc.grpc.ProductUpdateRequest, com.unlauserservergrpc.grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlauserservergrpc.grpc.ProductUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlauserservergrpc.grpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new productServiceMethodDescriptorSupplier("updateProduct"))
              .build();
        }
      }
    }
    return getUpdateProductMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static productServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<productServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<productServiceStub>() {
        @java.lang.Override
        public productServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new productServiceStub(channel, callOptions);
        }
      };
    return productServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static productServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<productServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<productServiceBlockingStub>() {
        @java.lang.Override
        public productServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new productServiceBlockingStub(channel, callOptions);
        }
      };
    return productServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static productServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<productServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<productServiceFutureStub>() {
        @java.lang.Override
        public productServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new productServiceFutureStub(channel, callOptions);
        }
      };
    return productServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class productServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *FUNCION( PARAMETRO QUE RECIBE) RETORNO( QUE RETORNA)
     * </pre>
     */
    public void saveProduct(com.unlauserservergrpc.grpc.ProductSaveRequest request,
        io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSaveProductMethod(), responseObserver);
    }

    /**
     */
    public void updateProduct(com.unlauserservergrpc.grpc.ProductUpdateRequest request,
        io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateProductMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSaveProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.unlauserservergrpc.grpc.ProductSaveRequest,
                com.unlauserservergrpc.grpc.Response>(
                  this, METHODID_SAVE_PRODUCT)))
          .addMethod(
            getUpdateProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.unlauserservergrpc.grpc.ProductUpdateRequest,
                com.unlauserservergrpc.grpc.Response>(
                  this, METHODID_UPDATE_PRODUCT)))
          .build();
    }
  }

  /**
   */
  public static final class productServiceStub extends io.grpc.stub.AbstractAsyncStub<productServiceStub> {
    private productServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected productServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new productServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *FUNCION( PARAMETRO QUE RECIBE) RETORNO( QUE RETORNA)
     * </pre>
     */
    public void saveProduct(com.unlauserservergrpc.grpc.ProductSaveRequest request,
        io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateProduct(com.unlauserservergrpc.grpc.ProductUpdateRequest request,
        io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProductMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class productServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<productServiceBlockingStub> {
    private productServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected productServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new productServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *FUNCION( PARAMETRO QUE RECIBE) RETORNO( QUE RETORNA)
     * </pre>
     */
    public com.unlauserservergrpc.grpc.Response saveProduct(com.unlauserservergrpc.grpc.ProductSaveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.unlauserservergrpc.grpc.Response updateProduct(com.unlauserservergrpc.grpc.ProductUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProductMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class productServiceFutureStub extends io.grpc.stub.AbstractFutureStub<productServiceFutureStub> {
    private productServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected productServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new productServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *FUNCION( PARAMETRO QUE RECIBE) RETORNO( QUE RETORNA)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.unlauserservergrpc.grpc.Response> saveProduct(
        com.unlauserservergrpc.grpc.ProductSaveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.unlauserservergrpc.grpc.Response> updateProduct(
        com.unlauserservergrpc.grpc.ProductUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProductMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAVE_PRODUCT = 0;
  private static final int METHODID_UPDATE_PRODUCT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final productServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(productServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVE_PRODUCT:
          serviceImpl.saveProduct((com.unlauserservergrpc.grpc.ProductSaveRequest) request,
              (io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.Response>) responseObserver);
          break;
        case METHODID_UPDATE_PRODUCT:
          serviceImpl.updateProduct((com.unlauserservergrpc.grpc.ProductUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.Response>) responseObserver);
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

  private static abstract class productServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    productServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.unlauserservergrpc.grpc.Productgrpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("productService");
    }
  }

  private static final class productServiceFileDescriptorSupplier
      extends productServiceBaseDescriptorSupplier {
    productServiceFileDescriptorSupplier() {}
  }

  private static final class productServiceMethodDescriptorSupplier
      extends productServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    productServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (productServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new productServiceFileDescriptorSupplier())
              .addMethod(getSaveProductMethod())
              .addMethod(getUpdateProductMethod())
              .build();
        }
      }
    }
    return result;
  }
}
