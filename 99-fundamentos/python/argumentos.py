# posso informar nenhum ou vários parâmetros
def parametros_variaveis(*arg):
    print("A função que recebe *arg foi chamada com ", len(arg), " argumentos: ", arg)
    for v in arg:
        print("->", v)

# informar nenhum ou vários parâmetros, no formato nome=valor
def nomes_de_parametros(**kwarg): # kw = keywork
    print("A função que recebe **kwarg foi chamada com ", len(kwarg), " argumentos: ", kwarg)
    for k in kwarg:
        print("=>", k, "=", kwarg[k])    

if __name__ == "__main__":
    
    # uso de função com *args
    parametros_variaveis()
    parametros_variaveis("Joao") # somente nome
    parametros_variaveis("Casa 9") # somente endereço
    parametros_variaveis("Joao", "Casa 9") # nome e endereço
    # um parâmetro aleatório: a função aceita tudo
    parametros_variaveis("Caneta azul")

    # uso de função com **kwargs
    nomes_de_parametros()
    nomes_de_parametros(nome = "Joao")
    nomes_de_parametros(endereco = "Casa 9")
    nomes_de_parametros(endereco = "Casa 9", nome = "Joao")
    nomes_de_parametros(nome = "Joao", endereco = "Casa 9")
    nomes_de_parametros(caneta = "Azul") # aleatório

    # uso de um asterisco para desempacotar elementos iteráveis
    
    # uso de dois asteriscos para desempacotar dicionários
    # criar dicionário
    pars = {"nome": "Joao de Oliveira", "whatsapp": "47 99210 2020"}
    # aplicar à função que recebe parâmetros variáveis no formato nome=valor
    nomes_de_parametros(**pars)
