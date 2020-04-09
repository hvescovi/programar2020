# importações
from flask import Flask, render_template, jsonify
from flask_sqlalchemy import SQLAlchemy
import json
import os
import requests # para fazer requisição http

# configurações
app = Flask(__name__)
# sqlalchemy
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite://' # em memória!
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False # remover warnings
db = SQLAlchemy(app)