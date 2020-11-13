class Pessoa:
    def __init__(self, nome="", fone="", email=""):
        self.nome = nome
        self.telefone = fone; self.email = email
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
        super().__init__(kwargs.get('nome'), 
            kwargs.get('fone'), kwargs.get('email'))
        self.cnh = cnh            
    def __str__(self):
        return f'{super().__str__()}, CNH: {self.cnh}'

joao = Vendedor(nome="João da Silva", 
            email="josilva@gmail.com", comissao=10) # 10% de comissão
print(joao)
maria = Motorista(cnh="123-4", 
            nome="Maria Oliveira", email="mari@gmail.com")
print(maria)
'''
João da Silva, , josilva@gmail.com, comissão=10
Maria Oliveira, None, mari@gmail.com, CNH: 123-4 
'''