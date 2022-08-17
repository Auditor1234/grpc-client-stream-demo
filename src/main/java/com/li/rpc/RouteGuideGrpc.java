package com.li.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: FileTransport.proto")
public final class RouteGuideGrpc {

  private RouteGuideGrpc() {}

  public static final String SERVICE_NAME = "com.li.rpc.RouteGuide";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.li.rpc.FileInfo,
      com.li.rpc.Info> getSendFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendFile",
      requestType = com.li.rpc.FileInfo.class,
      responseType = com.li.rpc.Info.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.li.rpc.FileInfo,
      com.li.rpc.Info> getSendFileMethod() {
    io.grpc.MethodDescriptor<com.li.rpc.FileInfo, com.li.rpc.Info> getSendFileMethod;
    if ((getSendFileMethod = RouteGuideGrpc.getSendFileMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getSendFileMethod = RouteGuideGrpc.getSendFileMethod) == null) {
          RouteGuideGrpc.getSendFileMethod = getSendFileMethod =
              io.grpc.MethodDescriptor.<com.li.rpc.FileInfo, com.li.rpc.Info>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.li.rpc.FileInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.li.rpc.Info.getDefaultInstance()))
              .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("sendFile"))
              .build();
        }
      }
    }
    return getSendFileMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RouteGuideStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RouteGuideStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RouteGuideStub>() {
        @java.lang.Override
        public RouteGuideStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RouteGuideStub(channel, callOptions);
        }
      };
    return RouteGuideStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RouteGuideBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RouteGuideBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RouteGuideBlockingStub>() {
        @java.lang.Override
        public RouteGuideBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RouteGuideBlockingStub(channel, callOptions);
        }
      };
    return RouteGuideBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RouteGuideFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RouteGuideFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RouteGuideFutureStub>() {
        @java.lang.Override
        public RouteGuideFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RouteGuideFutureStub(channel, callOptions);
        }
      };
    return RouteGuideFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RouteGuideImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 客户端文件流例子
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.li.rpc.FileInfo> sendFile(
        io.grpc.stub.StreamObserver<com.li.rpc.Info> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSendFileMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendFileMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                com.li.rpc.FileInfo,
                com.li.rpc.Info>(
                  this, METHODID_SEND_FILE)))
          .build();
    }
  }

  /**
   */
  public static final class RouteGuideStub extends io.grpc.stub.AbstractAsyncStub<RouteGuideStub> {
    private RouteGuideStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RouteGuideStub(channel, callOptions);
    }

    /**
     * <pre>
     * 客户端文件流例子
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.li.rpc.FileInfo> sendFile(
        io.grpc.stub.StreamObserver<com.li.rpc.Info> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSendFileMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class RouteGuideBlockingStub extends io.grpc.stub.AbstractBlockingStub<RouteGuideBlockingStub> {
    private RouteGuideBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RouteGuideBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class RouteGuideFutureStub extends io.grpc.stub.AbstractFutureStub<RouteGuideFutureStub> {
    private RouteGuideFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RouteGuideFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_FILE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RouteGuideImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RouteGuideImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_FILE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendFile(
              (io.grpc.stub.StreamObserver<com.li.rpc.Info>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RouteGuideBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RouteGuideBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.li.rpc.FileTransportApi.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RouteGuide");
    }
  }

  private static final class RouteGuideFileDescriptorSupplier
      extends RouteGuideBaseDescriptorSupplier {
    RouteGuideFileDescriptorSupplier() {}
  }

  private static final class RouteGuideMethodDescriptorSupplier
      extends RouteGuideBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RouteGuideMethodDescriptorSupplier(String methodName) {
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
      synchronized (RouteGuideGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RouteGuideFileDescriptorSupplier())
              .addMethod(getSendFileMethod())
              .build();
        }
      }
    }
    return result;
  }
}
