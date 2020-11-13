# importações
from flask import Flask
from flask_sqlalchemy import SQLAlchemy
import os

# configurações
app = Flask(__name__)
path = os.path.dirname(os.path.abspath(__file__)) # sugestao do Kaue
arquivobd = os.path.join(path, 'profissoes.db')
app.config['SQLALCHEMY_DATABASE_URI'] = "sqlite:///"+arquivobd
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False # remover warnings
db = SQLAlchemy(app)

# definições das classes
class Pessoa(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(254))
    telefone = db.Column(db.String(254))
    email = db.Column(db.String(254))

    # atributo necessário para armazenar tipo de classe especializada (discriminador)
    type = db.Column(db.String(50))
    
    # definições de mapeamento da classe mãe
    __mapper_args__ = {
        'polymorphic_identity':'pessoa', 
        'polymorphic_on':type # nome do campo que vincula os filhos
    }
    def __str__(self):
        return f'{self.nome}, {self.telefone}, {self.email}'

class Vendedor(Pessoa):
    # estabelecer vínculo com a tabela-pai. Este campo define
    # a criação da tabela vendedor
    id = db.Column(db.Integer, db.ForeignKey('pessoa.id'), primary_key=True)

    # a identidade polimórfica da classe será armazenada 
    # no campo type da classe pai
    __mapper_args__ = { 
        'polymorphic_identity':'vendedor',
    }
    comissao = db.Column(db.Float) # atributo do vendedor
    def __str__(self):
        return super().__str__() + f", comissão={self.comissao}"

class Motorista(Pessoa):
    id = db.Column(db.Integer, db.ForeignKey('pessoa.id'), primary_key=True)
    __mapper_args__ = { 
        'polymorphic_identity':'motorista',
    }
    cnh = db.Column(db.String(254)) # atributo do motorista
    def __str__(self):
        return f'{super().__str__()}, CNH: {self.cnh}'

# início do programa de testes
if os.path.exists(arquivobd): # se o arquivo já existe...
    os.remove(arquivobd) # ... o arquivo é removido

db.create_all() # criar as tabelas no banco

joao = Vendedor(nome="João da Silva", # omitindo o telefone
            email="josilva@gmail.com", comissao=10) # 10% de comissão            
print(f'Vendedor: {joao}')
# Vendedor: João da Silva, None, josilva@gmail.com, comissão=10

db.session.add(joao) # adicionando joao no BD
db.session.commit() # efetivando a persistência

maria = Motorista(nome="Maria Oliveira", email="mari@gmail.com", 
            telefone="98813-1415", cnh="123-4")
print(f'Motorista: {maria}')
# Motorista: Maria Oliveira, 98813-1415, mari@gmail.com, CNH: 123-4
db.session.add(maria)
db.session.commit()

# listando as pessoas :-)
print("Listando pessoas:")
for p in db.session.query(Pessoa).all():
    print(p)
'''
Listando pessoas:
João da Silva, None, josilva@gmail.com
Maria Oliveira, 98813-1415, mari@gmail.com
'''