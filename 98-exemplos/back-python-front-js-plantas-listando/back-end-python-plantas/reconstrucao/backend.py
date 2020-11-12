from config import *
from modelo import Planta

@app.route("/")
def padrao():
    return "backend operante"

@app.route("/listar_plantas")
def listar_plantas():
    plantas = db.session.query(Planta).all()
    retorno = []
    for p in plantas:
        retorno.append(p.json())
    resposta = jsonify(retorno)
    return resposta

app.run(debug = True)