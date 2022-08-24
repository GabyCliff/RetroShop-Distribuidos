package com.unlauserservergrpc.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.1)",
    comments = "Source: usersgrpc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class userServiceGrpc {

  private userServiceGrpc() {}

  public static final String SERVICE_NAME = "userService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.username,
      com.unlauserservergrpc.grpc.UserObject> getGetOneByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getOneByUsername",
      requestType = com.unlauserservergrpc.grpc.username.class,
      responseType = com.unlauserservergrpc.grpc.UserObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.username,
      com.unlauserservergrpc.grpc.UserObject> getGetOneByUsernameMethod() {
    io.grpc.MethodDescriptor<com.unlauserservergrpc.grpc.username, com.unlauserservergrpc.grpc.UserObject> getGetOneByUsernameMethod;
    if ((getGetOneByUsernameMethod = userServiceGrpc.getGetOneByUsernameMethod) == null) {
      synchronized (userServiceGrpc.class) {
        if ((getGetOneByUsernameMethod = userServiceGrpc.getGetOneByUsernameMethod) == null) {
          userServiceGrpc.getGetOneByUsernameMethod = getGetOneByUsernameMethod =
              io.grpc.MethodDescriptor.<com.unlauserservergrpc.grpc.username, com.unlauserservergrpc.grpc.UserObject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getOneByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlauserservergrpc.grpc.username.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.unlauserservergrpc.grpc.UserObject.getDefaultInstance()))
              .setSchemaDescriptor(new userServiceMethodDescriptorSupplier("getOneByUsername"))
              .build();
        }
      }
    }
    return getGetOneByUsernameMethod;
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
    public void getOneByUsername(com.unlauserservergrpc.grpc.username request,
        io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.UserObject> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOneByUsernameMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetOneByUsernameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.unlauserservergrpc.grpc.username,
                com.unlauserservergrpc.grpc.UserObject>(
                  this, METHODID_GET_ONE_BY_USERNAME)))
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
    public void getOneByUsername(com.unlauserservergrpc.grpc.username request,
        io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.UserObject> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOneByUsernameMethod(), getCallOptions()), request, responseObserver);
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
    public com.unlauserservergrpc.grpc.UserObject getOneByUsername(com.unlauserservergrpc.grpc.username request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOneByUsernameMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.unlauserservergrpc.grpc.UserObject> getOneByUsername(
        com.unlauserservergrpc.grpc.username request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOneByUsernameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ONE_BY_USERNAME = 0;

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
        case METHODID_GET_ONE_BY_USERNAME:
          serviceImpl.getOneByUsername((com.unlauserservergrpc.grpc.username) request,
              (io.grpc.stub.StreamObserver<com.unlauserservergrpc.grpc.UserObject>) responseObserver);
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
      return com.unlauserservergrpc.grpc.Usersgrpc.getDescriptor();
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
              .addMethod(getGetOneByUsernameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
