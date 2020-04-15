from config import *
from modelo import Pessoa

@app.route("/")
def inicio():
    return 'Sistema de cadastro de pessoas: front-end. '+\
        '<a href="/listar_pessoas">Operação listar</a>'

@app.route("/listar_pessoas")
def listar_pessoas():
    # obter as pessoas do back-end
    resultado_requisicao = requests.get('http://localhost:5000/listar_pessoas')
    # carregar os dados json para uma estrutura do python
    json_pessoas = resultado_requisicao.json() #pessoas.json()
    # inicializar uma lista do python
    pessoas_em_python = []
    # percorrer as pessoas em json
    for p in json_pessoas:
        # converter o texto json para uma estrutura do python (dicionário)
        dic_p = json.loads(p)
        # criar uma pessoa passando as informações do dicionário
        p = Pessoa(**dic_p)
        # adicionar a pessoa convertida na lista de pessoas
        pessoas_em_python.append(p)
    
    # fornecer a lista de pessoas para a página exibir as pessoas
    return render_template("listar_pessoas.html", listagem = pessoas_em_python)

app.run(debug=True, port=4999)