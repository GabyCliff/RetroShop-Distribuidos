from curses import echo
from importlib.abc import Finder
from tokenize import Double
import grpc
import proto.retroShop_grpc_pb2 as service_pb2
import proto.retroShop_grpc_pb2_grpc as service_grpc

class InvoiceClient(object):
  
  def __init__(self):
      self.host = 'localhost'
      self.server_port = 9090

      #Canal de comunicación con el servidor
      self.channel = grpc.insecure_channel('{}:{}'.format(self.host,self.server_port))
      self.stub = service_grpc.invoiceServiceStub(self.channel)

  def create(self, invoice):
        print(invoice)
        invoiceRequest = service_pb2.InvoiceRequest(
            idUserBuyer = invoice['idUserBuyer'],
            idUserSeller = invoice['idUserSeller'],
            total = invoice['total'],
            datePurchase = invoice['datePurchase'],
        )
        return self.stub.createNewInvoice(invoiceRequest)
  
  def getOneById(self, inputId):
      idRequest = service_pb2.IdInvoice(
        idInvoice = inputId['idInvoice']
      )
      return self.stub.findOneById(idRequest)
      
  def update(self, dataToUpdate):
      dataToUpdateRequest = service_pb2.DataInvoiceToUpdateRequest(
            id = dataToUpdate['id'],
            total = dataToUpdate['total']
      )
      return self.stub.updateInvoice(dataToUpdateRequest)
      
  def getListByIdUserBuyer(self, inputId):
      idRequest = service_pb2.IdUserBuyer(
            idUserBuyer = inputId['idUserBuyer']
      )
      return self.stub.findListByIdBuyer(idRequest)
      
  def getListByIdUserSeller(self, inputId):
      idRequest = service_pb2.IdUserSeller(
            idUserSeller = inputId['idUserSeller'],
      )
      return self.stub.findListByIdSeller(idRequest)
      
  def getListByDatePurchase(self, inputDatePurchase):
      datePurchaseRequest = service_pb2.DatePurchase(
            datePurchase = inputDatePurchase['datePurchase']
      )
      return self.stub.findListByDatePurchase(datePurchaseRequest)


InvoiceClient()

