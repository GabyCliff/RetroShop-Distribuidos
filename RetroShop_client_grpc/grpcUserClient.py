from importlib.abc import Finder
import grpc
import proto.user.client_grpc_pb2 as service_pb2
import proto.user.client_grpc_pb2_grpc as service_grpc

class UserClient(object):
   
   def __init__(self):
      self.host = 'localhost'
      self.server_port = 9090

      #Canal de comunicación con el servidor
      self.channel = grpc.insecure_channel('{}:{}'.format(self.host,self.server_port))
      self.stub = service_grpc.userServiceStub(self.channel)

   def getList(self):
      param = service_pb2.Empty()
      return self.stub.GetList(param)
   
   def createUser(self, user):
      userRequest = service_pb2.UserRequest(
            username = user['username'],
            password = user['password'],
            name = user['name'],
            surname = user['surname'],
            email = user['email'],
            dni = int(user['dni'])
      )
      return self.stub.createNewUser(userRequest)
   
   def findCurrentUser(self, user):
      findUser = service_pb2.CurrentUser(
         username = user['username'],
         password = user['password'],
      )
      return self.stub.findCurrentUser(findUser)

UserClient()
