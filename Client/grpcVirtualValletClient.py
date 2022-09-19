from curses import echo
from importlib.abc import Finder
from tokenize import Double
import grpc
import proto.retroShop_grpc_pb2 as service_pb2
import proto.retroShop_grpc_pb2_grpc as service_grpc

class VirtualWalletClient(object):
   
   def __init__(self):
      self.host = 'localhost'
      self.server_port = 9090

      #Canal de comunicación con el servidor
      self.channel = grpc.insecure_channel('{}:{}'.format(self.host,self.server_port))
      self.stub = service_grpc.virtualWalletServiceStub(self.channel)

   def createNew_v_w(self, virtualWallet):
      virtualWalletRequest = service_pb2.VirtualWalletRequest(
            balance = virtualWallet['balance'],
            idUser = virtualWallet['idUser']
      )
      return self.stub.createNewVirtualWallet(virtualWalletRequest)
   
   def findOneById_v_w(self, inputId):
      idRequest = service_pb2.IdVirtualWallet(
         idVirWall = inputId['idVW']
      )
      return self.stub.findOneById(idRequest)
      
   def v_w_update(self, dataToUpdate):
      dataToUpdateRequest = service_pb2.DataToUpdateRequest(
            idUser = dataToUpdate['idUser'],
            is_money_income = dataToUpdate['is_money_income'],
            value = dataToUpdate['value']
      )
      return self.stub.updateVirtualWallet(dataToUpdateRequest)
      
   def find_v_w_ByIdUser(self, dataToUpdate):
      idRequest = service_pb2.IdUserInVW(
            idUser = dataToUpdate['idUser']
      )
      return self.stub.findByIdUser(idRequest)

VirtualWalletClient()

