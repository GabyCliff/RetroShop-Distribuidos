from curses import echo
from importlib.abc import Finder
from tokenize import Double
import grpc
import proto.virtualValletClient_grpc_pb2 as service_pb2
import proto.virtualValletClient_grpc_pb2_grpc as service_grpc

class GrpcVirtualWalletClient(object):
   
   def __init__(self):
      self.host = 'localhost'
      self.server_port = 9090

      #Canal de comunicación con el servidor
      self.channel = grpc.insecure_channel('{}:{}'.format(self.host,self.server_port))
      self.stub = service_grpc.virtualWalletServiceStub(self.channel)

   def createNew_v_w(self, virtualWallet):
      virtualWalletRequest = service_pb2.VirtualWalletRequest(
            number = virtualWallet['number'],
            balance = virtualWallet['balance'],
            name = virtualWallet['name'],
            surname = virtualWallet['surname'],
            dni = int(virtualWallet['dni']),
            valid_from = virtualWallet['valid_from'],
            valid_until = virtualWallet['valid_until']
      )
      return self.stub.createNewVirtualWallet(virtualWalletRequest)
   
   def findOneById_v_w(self, inputId):
      idRequest = service_pb2.id(id = inputId['id'])
      return self.stub.findOneById(idRequest)

   def findByNumber_v_w(sef, inputNumber):
    numberRequest = service_pb2.number( number = inputNumber['number'])
    return sef.stub.findVirtualWalletByNumber(numberRequest)

      
   def v_w_update(self, dataToUpdate):
      dataToUpdateRequest = service_pb2.DataToUpdateRequest(
            number = dataToUpdate['number'],
            is_money_income = dataToUpdate['is_money_income'],
            value = int(dataToUpdate['value'])
      )
      return self.stub.updateVirtualWallet(dataToUpdateRequest)

GrpcVirtualWalletClient()

