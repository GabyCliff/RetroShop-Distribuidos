from importlib.abc import Finder
import grpc
import proto.retroShop_grpc_pb2 as service_pb2
import proto.retroShop_grpc_pb2_grpc as service_grpc

class ItemClient(object):
  
  def __init__(self):
      self.host = 'localhost'
      self.server_port = 9090

      #Canal de comunicación con el servidor
      self.channel = grpc.insecure_channel('{}:{}'.format(self.host,self.server_port))
      self.stub = service_grpc.itemServiceStub(self.channel)

  def getOneById(self, item):
      var_idItem = service_pb2.IdItem(
        idItem = item['idItem']
      )
      return self.stub.findOneById(var_idItem)

  def findByIdInvoice(self, item):
      var_idInvoiceInItem = service_pb2.IdInvoiceInItem(
        idInvoice = item['idInvoice']
      )
      return self.stub.findListByIdInvoice(var_idInvoiceInItem)

  def create(self, item):
      var_itemReq = service_pb2.ItemRequest(
        idProduct = item['idProduct'],
        quantity = item['quantity'],
        subTotal = item['subTotal'],
        idInvoice = item['idInvoice']
      )
      return self.stub.createNewItem(var_itemReq)

  def update(self, item):
      var_data = service_pb2.DataItemToUpdateRequest(
        id = item['idItem'],
        quantity = item['quantity'],
        subTotal = item['subtotal']
      )
      return self.stub.updateItem(var_data)


ItemClient()