from config import *

class Pessoa(db.Model):
    # atributos da pessoa
    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(254))
    email = db.Column(db.String(254))
    telefone = db.Column(db.String(254))

    # método para expressar a pessoa em forma de texto
    def __str__(self):
        return self.nome + "[id="+str(self.id)+ "], " +\
            self.email + ", " + self.telefone
    # expressao da classe no formato json
    def json(self):
        return {
            "id": self.id,
            "nome": self.nome,
            "email": self.email,
            "telefone": self.telefone
        }

class ExameRealizado(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    data = db.Column(db.String(254)) # data do exame
    nome = db.Column(db.String(254)) # nome do exame: B12, D3, etc
    resultado = db.Column(db.String(254)) # valor com unidade
    
    # atributo de chave estrangeira
    pessoa_id = db.Column(db.Integer, db.ForeignKey(Pessoa.id), nullable=False)
    # atributo de relacionamento, para acesso aos dados via objeto
    pessoa = db.relationship("Pessoa")

    def __str__(self): # expressão da classe em forma de texto
        return self.data + ", " + self.nome + ", " + self.resultado + \
            ", " + str(self.pessoa) # o str aciona o __str__ da classe Pessoa

    def json(self):
        return {
            "id":self.id,
            "data":self.data,
            "nome":self.nome,
            "resultado":self.resultado,
            "pessoa_id":self.pessoa_id,
            "pessoa":self.pessoa.json() 
        }

class Respirador(db.Model):
    id = db.Column(db.Integer, primary_key=True) # id interno
    codigo = db.Column(db.String(254)) # código do equipamento
    data_aquisicao = db.Column(db.String(254))
    data_emprestimo = db.Column(db.String(254)) # emprestado? se sim, desde quando?

    # atributo de chave estrangeira
    pessoa_id = db.Column(db.Integer, db.ForeignKey(Pessoa.id))
    # atributo de relacionamento, para acesso aos dados via objeto
    pessoa = db.relationship("Pessoa")

    def __str__(self): # expressão da classe em forma de texto
        s = f"Respirador {self.codigo} adquirido em {self.data_aquisicao}"
        if self.pessoa != None:
            s += f", emprestado para {self.pessoa} desde {self.data_aquisicao}"
        return s

    def json(self):
        if self.pessoa is None: # o respirador está livre?
            pessoa_id = ""
            pessoa = ""
            data_emprestimo = ""
        else: # o respirador está emprestado!! :-)
            pessoa_id = self.pessoa_id
            pessoa = self.pessoa.json()
            data_emprestimo = self.data_emprestimo
            
        return {
            "id": self.id,
            "codigo": self.codigo,
            "data_aquisicao": self.data_aquisicao,
            "pessoa_id": pessoa_id,
            "pessoa": pessoa,
            "data_emprestimo": data_emprestimo
        } 

# teste    
if __name__ == "__main__":
    # apagar o arquivo, se houver
    if os.path.exists(arquivobd):
        os.remove(arquivobd)

    # criar tabelas
    db.create_all()

    # teste da classe Pessoa
    p1 = Pessoa(nome = "João da Silva", email = "josilva@gmail.com", 
        telefone = "47 99012 3232")
    p2 = Pessoa(nome = "Maria Oliveira", email = "molive@gmail.com", 
        telefone = "47 98822 2531")        
    # persistir
    db.session.add(p1)
    db.session.add(p2)
    db.session.commit()
    
    print(p2) # exibir a pessoa
    print(p2.json()) # exibir a pessoa no format json

    # novo resultado de exame
    e1 = ExameRealizado(data="02/02/2020", nome="Vitamina B12", 
        resultado="219,0 pg/mL", pessoa=p1)
    db.session.add(e1)
    db.session.commit()
    print(f"Exame realizado: {e1}")
    print(f"Exame realizado em json: {e1.json()}")
    # resultado:
    # Exame realizado: 02/02/2020, Vitamina B12, 219,0 pg/mL, João da Silva[id=1], josilva@gmail.com, 47 99012 3232
    # Exame realizado em json: {'id': 1, 'data': '02/02/2020', 'nome': 'Vitamina B12', 'resultado': '219,0 pg/mL', 'pessoa_id': 1, 'pessoa': {'id': 1, 'nome': 'João da Silva', 'email': 'josilva@gmail.com', 'telefone': '47 99012 3232'}}

    # vamos criar um respirador que está disponível
    r1 = Respirador(codigo="001A", data_aquisicao="24/03/2020")
    db.session.add(r1)
    db.session.commit()
    print(f"Respirador 1: {r1}")
    print(f"Respirador 1 (em json): {r1.json()}")
    # resultado:
    # Respirador 1: Respirador 001A adquirido em 24/03/2020
    # Respirador 1 (em json): {'id': 1, 'codigo': '001A', 'data_aquisicao': '24/03/2020', 'pessoa_id': '', 'pessoa': '', 'data_emprestimo': ''}

    # agora, um respirador emprestado para João
    r2 = Respirador(codigo="002B", data_aquisicao="01/02/2020", pessoa = p1, data_emprestimo="04/02/2020")
    db.session.add(r2)
    db.session.commit()
    print(f"Respirador 2: {r2}")
    print(f"Respirador 2 (em json): {r2.json()}")
    # resultado:
    # Respirador 2: Respirador 002B adquirido em 01/02/2020, emprestado para João da Silva[id=1], josilva@gmail.com, 47 99012 3232 desde 01/02/2020
    # Respirador 2 (em json): {'id': 2, 'codigo': '002B', 'data_aquisicao': '01/02/2020', 'pessoa_id': 1, 'pessoa': {'id': 1, 'nome': 'João da Silva', 'email': 'josilva@gmail.com', 'telefone': '47 99012 3232'}, 'data_emprestimo': '04/02/2020'}
    # CONTEUDO JSON formatado no site: https://jsonformatter.curiousconcept.com/#
    '''
    {
      "id":2,
      "codigo":"002B",
      "data_aquisicao":"01/02/2020",
      "pessoa_id":1,
      "pessoa":{
        "id":1,
        "nome":"João da Silva",
        "email":"josilva@gmail.com",
        "telefone":"47 99012 3232"
      },
      "data_emprestimo":"04/02/2020"
    }
    '''
