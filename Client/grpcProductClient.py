from importlib.abc import Finder
import grpc
import proto.retroShop_grpc_pb2 as service_pb2
import proto.retroShop_grpc_pb2_grpc as service_grpc

class ProductClient(object):
   
   def __init__(self):
      self.host = 'localhost'
      self.server_port = 9090

      #Canal de comunicación con el servidor
      self.channel = grpc.insecure_channel('{}:{}'.format(self.host,self.server_port))
      self.stub = service_grpc.productServiceStub(self.channel)
   
   def saveProduct(self, product):
      productSave = service_pb2.ProductSaveRequest(
            name = product['name'],
            description = product['description'],
            listPhoto = product['listPhoto'],
            price = product['price'],
            quantity = product['quantity'],
            date = product['date'],
            idUser = product['idUser'],
            category = product['category']
      )
      return self.stub.saveProduct(productSave)
   
   def updateProduct(self, product):
      productUpdate = service_pb2.ProductUpdateRequest(
            id = product['id'],
            name = product['name'],
            description = product['description'],
            listPhoto = product['listPhoto'],
            price = product['price'],
            quantity = product['quantity'],
            date = product['date'],
            idUser = product['idUser'],
            category = product['category']
      )
      return self.stub.updateProduct(productUpdate)

   def getProduct(self, product):
      idProduct = service_pb2.IdProduct(
         idProduct = product['idProduct'],
      )
      return self.stub.getProduct(idProduct)

   def findByIdUser(self, product):
      id_UserInP = service_pb2.IdUserInProduct(
         idUser = product['idUser'],
      )
      return self.stub.findByIdUser(id_UserInP)

   def getAll(self, product):
      paramVoid = service_pb2.EmptyProduct()
      return self.stub.getAll(paramVoid)

ProductClient()
