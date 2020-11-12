from flask_sqlalchemy import SQLAlchemy
import os

app = Flask(__name__)
path = os.path.dirname(os.path.abspath(__file__)) # sugestao do Kaue
arquivobd = os.path.join(path, 'pessoas.db')
app.config['SQLALCHEMY_DATABASE_URI'] = "sqlite:///"+arquivobd
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False # remover warnings
db = SQLAlchemy(app)

class Pessoa(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(254))
    telefone = db.Column(db.String(254))
    email = db.Column(db.String(254))
    def __str__(self):
        return f'{self.nome}, {self.telefone}, {self.email}'

class Vendedor(Pessoa):
    def __init__(self, nome="", fone="", email="", comissao=0):
        super().__init__(nome, fone, email)
        self.comissao = comissao # percentual    
    def __str__(self):
        return super().__str__() + f", comissão={self.comissao}"

class Motorista(Pessoa):
    def __init__(self, cnh="", **kwargs):
        self.cnh = cnh
        super().__init__(kwargs.get('nome'), 
            kwargs.get('fone'), kwargs.get('email'))
    def __str__(self):
        return f'{super().__str__()}, CNH: {self.cnh}'

joao = Vendedor(nome="João da Silva", 
            email="josilva@gmail.com", comissao=10) # 10% de comissão
print(joao)
maria = Motorista(cnh="123-4", 
            nome="Maria Oliveira", email="mari@gmail.com")
print(maria)