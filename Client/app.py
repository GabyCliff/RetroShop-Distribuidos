from flask import Flask, request
from flask_cors import CORS, cross_origin
from google.protobuf.json_format import MessageToJson
from grpcProductClient import ProductClient
from grpcVirtualValletClient import VirtualWalletClient
from grpcUserClient import UserClient
from grpcItemClient import ItemClient
from grpcInvoiceClient import InvoiceClient


app = Flask(__name__)
CORS(app)

base_url_user = ""
base_url_item = "/item"
base_url_invoice = "/invoice"
base_url_vitual_wallet = "/vw"#lo que se ponga acá se agrega al inicio de todas las urls

@app.route('/', methods=['GET'])
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
    grpc_vir_wal_client = VirtualWalletClient()
    result = grpc_vir_wal_client.createNew_v_w(request.json)
    return MessageToJson(result)


@app.route(base_url_vitual_wallet+'/findOneById', methods=['POST'])
@cross_origin()
def findOne_v_w_ById():
    grpc_vir_wal_client = VirtualWalletClient()
    result = grpc_vir_wal_client.findOneById_v_w(request.json)
    return MessageToJson(result)


@app.route(base_url_vitual_wallet+'/findByIdUser', methods=['POST'])
@cross_origin()
def findOne_v_w_ByIdUser():
    grpc_vir_wal_client = VirtualWalletClient()
    result = grpc_vir_wal_client.find_v_w_ByIdUser(request.json)
    return MessageToJson(result)


@app.route(base_url_vitual_wallet+'/update', methods=['POST'])
@cross_origin()
def update_v_w():
    grpc_vir_wal_client = VirtualWalletClient()
    result = grpc_vir_wal_client.v_w_update(request.json)
    return MessageToJson(result)


#///////////// Productos /////////////////

@app.route('/saveProduct', methods=['POST'])
@cross_origin()
def saveProduct():
    print(request.json)
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

@app.route('/getListProductsByIdUser', methods=['POST'])
@cross_origin()
def getListProductsForUser():
    #product = ProductClient()
    #result = product.findByIdUser(request.json)
    #return MessageToJson(result)
    return MessageToJson['****************************message Falta terminar de implentar: debe Retornar una lista productos  *^************************************']

@app.route('/allProducts', methods=['POST'])
@cross_origin()
def findAll():
    #product = ProductClient()
    #result = product.getAll(request.json)
    #return MessageToJson(result)
    return MessageToJson['**************************** message: Falta terminar de implentar:n debe Retornar todos los productos*^************************************']


#///////////// item /////////////////

@app.route(base_url_item+'/create', methods=['POST'])
@cross_origin()
def newItem():
    item = ItemClient()
    result = item.create(request.json)
    return MessageToJson(result)

@app.route(base_url_item+'/findById', methods=['POST'])
@cross_origin()
def getItemById():
    item = ItemClient()
    result = item.getOneById(request.json)
    return MessageToJson(result)


@app.route(base_url_item+'/update', methods=['POST'])
@cross_origin()
def updateItem():
    item = ItemClient()
    result = item.update(request.json)
    return MessageToJson(result)

@app.route(base_url_item+'/findByIdInvioce', methods=['POST'])
@cross_origin()
def getItemByIdInvoice():
    #item = ItemClient()
    #result = item.findByIdInvoice(request.json)
    #return MessageToJson(result)
    return MessageToJson['**************************** message: Falta terminar de implentar:n debe Retornar una lista de ítems de una factura*^************************************']


#///////////// invoice /////////////////

@app.route(base_url_invoice+'/create', methods=['POST'])
@cross_origin()
def newInvoice():
    invoice = InvoiceClient()
    result = invoice.create(request.json)
    return MessageToJson(result)

@app.route(base_url_invoice+'/findById', methods=['POST'])
@cross_origin()
def getInvoiceById():
    invoice = InvoiceClient()
    result = invoice.getOneById(request.json)
    return MessageToJson(result)

@app.route(base_url_invoice+'/update', methods=['POST'])
@cross_origin()
def updateInvoice():
    invoice = InvoiceClient()
    result = invoice.update(request.json)
    return MessageToJson(result)

@app.route(base_url_invoice+'/getListByIdBuyer', methods=['POST'])
@cross_origin()
def findLisByIdBuyerInInvoice():
    #invoice = InvoiceClient()
    #result = invoice.getListByIdUserBuyer(request.json)
    #return MessageToJson(result)
    return MessageToJson['**************************** message: Falta terminar de implentar:n debe Retornar una lista*************************************']

@app.route(base_url_invoice+'/getListByIdSeller', methods=['POST'])
@cross_origin()
def findLisByIdSellerInInvoice():
    #invoice = InvoiceClient()
    #result = invoice.getListByIdUserSeller(request.json)
    #return MessageToJson(result)
    return MessageToJson['**************************** message: Falta terminar de implentar:n debe Retornar una lista*************************************']

@app.route(base_url_invoice+'/getListByDatePurchase', methods=['POST'])
@cross_origin()
def findLisByDatePurchaseOfInvoice():
    #invoice = InvoiceClient()
    #result = invoice.getListByDatePurchase(request.json)
    #return MessageToJson(result)
    return MessageToJson['**************************** message: Falta terminar de implentar:n debe Retornar una lista*************************************']



if __name__ == '__main__':
    app.run()