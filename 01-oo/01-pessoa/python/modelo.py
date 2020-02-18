class Pessoa:

    # construtor com parâmetros opcionais
    def __init__(self, nome="", email="", tel=""):
        self.nome = nome
        self.email = email
        self.telefone = tel

    # método que expressa o objeto em forma de string        
    def __str__(self):
        return "\n" + self.nome + ", email: " + \
        self.email + ", " + self.telefone

# o programa que sendo executado?
# se estiver sendo importado, não entra nesse if
if __name__ == "__main__":

    # criar objetos e informar alguns valores depois
    joao = Pessoa()    
    joao.nome = "João da Silva"
    joao.email = "josilva@gmail.com"
 
    # criar objeto já informando valores
    ma = Pessoa("Maria Oliveira", "mao@gmail.com", "9449-2332")
    
    # criar objeto e informar alguns valores
    ti = Pessoa("Tiago Nune", "tinu@gmail.com")

    # exibir os dados de teste
    print(joao, ma, ti)