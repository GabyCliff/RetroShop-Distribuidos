# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

from proto.virtualWallet import client_grpc_pb2 as proto_dot_virtualWallet_dot_client__grpc__pb2


class virtualWalletServiceStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.findOneById = channel.unary_unary(
                '/virtualWalletService/findOneById',
                request_serializer=proto_dot_virtualWallet_dot_client__grpc__pb2.id.SerializeToString,
                response_deserializer=proto_dot_virtualWallet_dot_client__grpc__pb2.ResponseObjectVirtualWalletData.FromString,
                )
        self.findVirtualWalletByNumber = channel.unary_unary(
                '/virtualWalletService/findVirtualWalletByNumber',
                request_serializer=proto_dot_virtualWallet_dot_client__grpc__pb2.number.SerializeToString,
                response_deserializer=proto_dot_virtualWallet_dot_client__grpc__pb2.ResponseObjectVirtualWalletData.FromString,
                )
        self.createNewVirtualWallet = channel.unary_unary(
                '/virtualWalletService/createNewVirtualWallet',
                request_serializer=proto_dot_virtualWallet_dot_client__grpc__pb2.VirtualWalletRequest.SerializeToString,
                response_deserializer=proto_dot_virtualWallet_dot_client__grpc__pb2.ResponseObjectVirtualWalletData.FromString,
                )
        self.updateVirtualWallet = channel.unary_unary(
                '/virtualWalletService/updateVirtualWallet',
                request_serializer=proto_dot_virtualWallet_dot_client__grpc__pb2.DataToUpdateRequest.SerializeToString,
                response_deserializer=proto_dot_virtualWallet_dot_client__grpc__pb2.ResponseObjectVirtualWalletData.FromString,
                )


class virtualWalletServiceServicer(object):
    """Missing associated documentation comment in .proto file."""

    def findOneById(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def findVirtualWalletByNumber(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def createNewVirtualWallet(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def updateVirtualWallet(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_virtualWalletServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'findOneById': grpc.unary_unary_rpc_method_handler(
                    servicer.findOneById,
                    request_deserializer=proto_dot_virtualWallet_dot_client__grpc__pb2.id.FromString,
                    response_serializer=proto_dot_virtualWallet_dot_client__grpc__pb2.ResponseObjectVirtualWalletData.SerializeToString,
            ),
            'findVirtualWalletByNumber': grpc.unary_unary_rpc_method_handler(
                    servicer.findVirtualWalletByNumber,
                    request_deserializer=proto_dot_virtualWallet_dot_client__grpc__pb2.number.FromString,
                    response_serializer=proto_dot_virtualWallet_dot_client__grpc__pb2.ResponseObjectVirtualWalletData.SerializeToString,
            ),
            'createNewVirtualWallet': grpc.unary_unary_rpc_method_handler(
                    servicer.createNewVirtualWallet,
                    request_deserializer=proto_dot_virtualWallet_dot_client__grpc__pb2.VirtualWalletRequest.FromString,
                    response_serializer=proto_dot_virtualWallet_dot_client__grpc__pb2.ResponseObjectVirtualWalletData.SerializeToString,
            ),
            'updateVirtualWallet': grpc.unary_unary_rpc_method_handler(
                    servicer.updateVirtualWallet,
                    request_deserializer=proto_dot_virtualWallet_dot_client__grpc__pb2.DataToUpdateRequest.FromString,
                    response_serializer=proto_dot_virtualWallet_dot_client__grpc__pb2.ResponseObjectVirtualWalletData.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'virtualWalletService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class virtualWalletService(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def findOneById(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/virtualWalletService/findOneById',
            proto_dot_virtualWallet_dot_client__grpc__pb2.id.SerializeToString,
            proto_dot_virtualWallet_dot_client__grpc__pb2.ResponseObjectVirtualWalletData.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def findVirtualWalletByNumber(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/virtualWalletService/findVirtualWalletByNumber',
            proto_dot_virtualWallet_dot_client__grpc__pb2.number.SerializeToString,
            proto_dot_virtualWallet_dot_client__grpc__pb2.ResponseObjectVirtualWalletData.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def createNewVirtualWallet(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/virtualWalletService/createNewVirtualWallet',
            proto_dot_virtualWallet_dot_client__grpc__pb2.VirtualWalletRequest.SerializeToString,
            proto_dot_virtualWallet_dot_client__grpc__pb2.ResponseObjectVirtualWalletData.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def updateVirtualWallet(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/virtualWalletService/updateVirtualWallet',
            proto_dot_virtualWallet_dot_client__grpc__pb2.DataToUpdateRequest.SerializeToString,
            proto_dot_virtualWallet_dot_client__grpc__pb2.ResponseObjectVirtualWalletData.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
