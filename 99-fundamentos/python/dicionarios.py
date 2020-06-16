# https://www.w3schools.com/python/python_dictionaries.asp

# guardando dados de uma pessoa
nome = "Joao da Silva",
email = "josilva@gmail.com"
telefone = "47 9 9233 1234"

# guardar dados em um dicionário; a atribuição lembra formato json
pessoa = {
    "nome" : "Joao da Silva",
    "email" : "josilva@gmail.com",
    "telefone" : "47 9 9233 1234"
}

print('* mostrar a pessoa em forma de dicionário')
print(pessoa) # note as aspas simples 

print('* percorrer e exibir dados do dicionário')
for info in pessoa:
    print(info)

print('* mostrando só o email e o telefone da pessoa (aspas duplas ou simples)')
print(pessoa["email"],pessoa['telefone'])

print('* adequando o dicionário para que seu conteúdo fique 100% json')
import json
print(json.dumps(pessoa)) # conteúdo 100% json com aspas duplas!

# passando um dicionário como parâmetro pra uma função
# dois asteriscos permitem passar quaisquer número de parâmetros
def mostra_tudo(**parametros): # CASO 1
    print("mostrando tudo...")
    # percorrer a lista de parametros no formato chave=valor
    for p in parametros:
        # mostra o nome do parâmetro e o valor
        print(p, "é igual a", parametros[p])

print('* usando a função que mostra tudo: mostrando nomes e valores')
mostra_tudo(nome = "Paulo Tarso", cor_da_escova_de_dentes = "azul")

print('* passando dic pra mostra_tudo, desempacotar dic com dois asteriscos')
mostra_tudo(**pessoa) # CASO 2

class Pessoa:
    def __init__(self, nome, email, telefone):
        self.nome = nome
        self.email = email
        self.telefone = telefone
    def __str__(self):
        return self.nome+", "+self.email+", "+self.telefone        

p1 = Pessoa("Tiago", "tibah@gmail.com", "92231-1232")
print(p1)
p2 = Pessoa(**pessoa) # criando objeto com dados do dicionário
print(p2)