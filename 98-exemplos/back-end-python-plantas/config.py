from flask import Flask, jsonify, request
from flask_sqlalchemy import SQLAlchemy 
import os 
app = Flask(__name__) 
caminho = os.path.dirname(os.path.abspath(__file__)) # sugestao do Kaue
arquivobd = os.path.join(caminho, "plantas.db") 
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///'+arquivobd 
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False # remover warnings 
db = SQLAlchemy(app)

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
    return jsonify(retorno)

@app.route("/incluir_planta", methods=['post'])
def incluir_planta():
    dados = request.get_json()
    nova_planta = Planta(**dados) #Planta(nome = dados['nome'], nome_cientifico = dados['nome_cientifico']...
    db.session.add(nova_planta)
    db.session.commit()
    return {"resultado":'ok'}

app.run(debug=True)