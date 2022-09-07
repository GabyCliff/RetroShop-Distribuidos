from importlib.abc import Finder
import grpc
import proto.product.client_grpc_pb2 as service_pb2
import proto.product.client_grpc_pb2_grpc as service_grpc

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
            available = product['available'],
      )
      return self.stub.saveProduct(productSave)
   
   def updateProduct(self, product):
      productUpdate = service_pb2.ProductUpdateRequest(
            id = product['id'],
            name = product['name'],
            description = product['description'],
            listPhoto = product['listPhoto'],
            price = product['price'],
            available = product['available'],
      )
      return self.stub.updateProduct(productUpdate)

   def getProduct(self, product):
      id = service_pb2.idProducto(
         id = product['id'],
      )
      return self.stub.getProduct(id)

ProductClient()
