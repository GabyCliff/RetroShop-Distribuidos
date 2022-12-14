from flask import Flask, request
from flask_cors import CORS, cross_origin
from google.protobuf.json_format import MessageToJson
from grpcProductClient import ProductClient
from grpcVirtualValletClient import GrpcVirtualWalletClient as Grpc_vir_wal_client
from grpcUserClient import UserClient


app = Flask(__name__)
CORS(app)

base_url_user = ""
base_url_vitual_wallet = ""#lo que se ponga acá se agrega al inicio de todas las urls

@app.route('/')
def hello():
    return "Service (OK)"

#///////////// user /////////////////

@app.route(base_url_user+'/createUser', methods=['POST'])
@cross_origin()
def createUser():
    user = UserClient()
    result = user.createUser(request.json)
    return MessageToJson(result)

@app.route(base_url_user+'/findCurrentUser', methods=['POST'])
@cross_origin()
def findCurrentUser():
    user = UserClient()
    result = user.findCurrentUser(request.json)
    return MessageToJson(result)

@app.route(base_url_user+'/findUserByUsername', methods=['POST'])
@cross_origin()
def findUserByUsername():
    user = UserClient()
    result = user.findUserByUsername(request.json)
    return MessageToJson(result)


#///////////// Billetera  /////////////////


@app.route(base_url_vitual_wallet+'/create', methods=['POST'])
@cross_origin()
def create_v_w():
    grpc_vir_wal_client = Grpc_vir_wal_client()
    result = grpc_vir_wal_client.createNew_v_w(request.json)
    return MessageToJson(result)


@app.route(base_url_vitual_wallet+'/findOneById', methods=['GET'])
@cross_origin()
def findOne_v_w_ById():
    grpc_vir_wal_client = Grpc_vir_wal_client()
    result = grpc_vir_wal_client.findOneById_v_w(request.json)
    return MessageToJson(result)


@app.route(base_url_vitual_wallet+'/findByNumber', methods=['POST'])
@cross_origin()
def find_v_w_ByNumber():
    grpc_vir_wal_client = Grpc_vir_wal_client()
    result = grpc_vir_wal_client.findByNumber_v_w(request.json)
    return MessageToJson(result)

@app.route(base_url_vitual_wallet+'/findByDni', methods=['POST'])
@cross_origin()
def find_v_w_ByDni():
    grpc_vir_wal_client = Grpc_vir_wal_client()
    result = grpc_vir_wal_client.findByDni_v_w(request.json)
    return MessageToJson(result)


@app.route(base_url_vitual_wallet+'/update', methods=['POST'])
@cross_origin()
def update_v_w():
    grpc_vir_wal_client = Grpc_vir_wal_client()
    result = grpc_vir_wal_client.v_w_update(request.json)
    return MessageToJson(result)


#///////////// Productos /////////////////

@app.route('/saveProduct', methods=['POST'])
@cross_origin()
def saveProduct():
    product = ProductClient()
    result = product.saveProduct(request.json)
    return MessageToJson(result)

@app.route('/updateProduct', methods=['POST'])
@cross_origin()
def updateProduct():
    product = ProductClient()
    result = product.updateProduct(request.json)
    return MessageToJson(result)

@app.route('/getProduct', methods=['POST'])
@cross_origin()
def getProduct():
    product = ProductClient()
    result = product.getProduct(request.json)
    return MessageToJson(result)

if __name__ == '__main__':
    app.run()