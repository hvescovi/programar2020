# importações
from flask import Flask, render_template
from flask_sqlalchemy import SQLAlchemy
import json # usar json.loads para transformar texto json em dicionário python
import requests # para fazer requisição http; pip3 install requests

# configurações
app = Flask(__name__)
# sqlalchemy
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite://' # em memória!
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False # remover warnings
db = SQLAlchemy(app)