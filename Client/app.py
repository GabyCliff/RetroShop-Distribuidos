from flask import Flask, request
from flask_cors import CORS, cross_origin
from google.protobuf.json_format import MessageToJson
from grpcClient import UserClient

app = Flask(__name__)
CORS(app)

@app.route("/")
def hello():
    return "Si"

@app.route('/getUsers')
@cross_origin()
def getUsers():
    user = UserClient()
    result = user.getList()
    return MessageToJson(result)

@app.route('/createUser', methods=['POST'])
@cross_origin()
def createUser():
    user = UserClient()
    result = user.createUser(request.json)
    return MessageToJson(result)

@app.route('/findCurrentUser', methods=['POST'])
@cross_origin()
def findCurrentUser():
    user = UserClient()
    result = user.findCurrentUser(request.json)
    return MessageToJson(result)


if __name__ == '__main__':
    app.run()