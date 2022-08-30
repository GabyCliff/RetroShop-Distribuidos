from flask import Flask, request
from flask_cors import CORS, cross_origin
from google.protobuf.json_format import MessageToJson
from grpcVirtualValletClient import GrpcVirtualWalletClient as Grpc_v_w_client

app = Flask(__name__)
CORS(app)

base_url = ""#lo que se ponga acá se agrega al inicio de todas las urls

@app.route(base_url+'/')
def hello():
    return "Service virtual wallet (OK)"


@app.route(base_url+'/create', methods=['POST'])
@cross_origin()
def create_v_w():
    grpc_v_w_client = Grpc_v_w_client()
    result = grpc_v_w_client.createNew_v_w(request.json)
    return MessageToJson(result)


@app.route(base_url+'/findOneById', methods=['GET'])
@cross_origin()
def findOne_v_w_ById():
    grpc_v_w_client = Grpc_v_w_client()
    result = grpc_v_w_client.findOneById_v_w(request.json)
    return MessageToJson(result)


@app.route(base_url+'/findByNumber', methods=['POST'])
@cross_origin()
def find_v_w_ByNumber():
    grpc_v_w_client = Grpc_v_w_client()
    result = grpc_v_w_client.findByNumber_v_w(request.json)
    return MessageToJson(result)


@app.route(base_url+'/update', methods=['POST'])
@cross_origin()
def update_v_w():
    grpc_v_w_client = Grpc_v_w_client()
    result = grpc_v_w_client.v_w_update(request.json)
    return MessageToJson(result)


if __name__ == '__main__':
    app.run()