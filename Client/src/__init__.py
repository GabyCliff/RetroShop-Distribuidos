from flask import Flask, request, make_response, jsonify
from flask_cors import CORS, cross_origin
from google.protobuf.json_format import MessageToJson
from grpcClient import UserClient

app = Flask(__name__)
CORS(app)

@app.route("/")
def hello():
    return "Si"

@app.route('/getUsers', methods=["GET"])
@cross_origin()
def getUsers():
    user = UserClient()
    result = user.getList()
    return MessageToJson(result)