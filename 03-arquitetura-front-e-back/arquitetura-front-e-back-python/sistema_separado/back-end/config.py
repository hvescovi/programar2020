# importações
from flask import Flask, jsonify # preparar resposta HTTP no formato json
from flask_sqlalchemy import SQLAlchemy
import json # ajustar conteúdo para o formato json
import os

# configurações
app = Flask(__name__)
# caminho do arquivo de banco de dados
arquivobd = "/home/friend/01-github/programar2020/03-arquitetura-front-e-back/arquitetura-front-e-back-python/sistema_separado/back-end/pessoas.db"
# sqlalchemy
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///'+arquivobd
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False # remover warnings
db = SQLAlchemy(app)