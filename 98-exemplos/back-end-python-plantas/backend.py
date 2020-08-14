from config import *
from modelo import Planta

@app.route("/")
def padrao():
    return "bem vindo ao backend"

@app.route("/listar_plantas")
def listar_plantas():
    plantas = db.session.query(Planta).all()
    retorno = []    
    for p in plantas:
        retorno.append(p.json())
    resposta = jsonify(retorno)
    resposta.headers.add("Access-Control-Allow-Origin", "*")
    return resposta

@app.route("/incluir_planta", methods=['post'])
def incluir_planta():
    dados = request.get_json()
    nova_planta = Planta(**dados) #Planta(nome = dados['nome'], nome_cientifico = dados['nome_cientifico']...
    db.session.add(nova_planta)
    db.session.commit()
    return {"resultado":'ok'}

app.run(debug=True)
