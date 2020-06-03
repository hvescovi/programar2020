# importações
from flask import Flask, render_template
from flask_sqlalchemy import SQLAlchemy
import os

# configurações
app = Flask(__name__)
# caminho do arquivo de banco de dados
arquivobd = "/home/friend/01-github/programar2020/03-arquitetura-front-e-back/arquitetura-front-e-back-python/sistema_integrado/pessoas.db"
# sqlalchemy
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///'+arquivobd
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False # remover warnings
db = SQLAlchemy(app)