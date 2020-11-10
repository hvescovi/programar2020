from flask_sqlalchemy import SQLAlchemy
from flask import Flask, jsonify
import os
app = Flask(__name__)
caminho = os.path.dirname(os.path.abspath(__file__))
arquivobd = os.path.join(caminho, "plantas.db")
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///' + arquivobd
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
db = SQLAlchemy(app)