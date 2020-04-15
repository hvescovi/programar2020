# https://www.geeksforgeeks.org/python-map-function/

def dobrar(n):
    return n*2

numeros = [1, 2, 3]
# aplica a função dobrar à cada elemento da estrutura numeros
resultado = map(dobrar, numeros)
# o map não é exibível
print(resultado)
# transforma em lista para exibir
print(list(resultado))

'''
resultado da execução:
<map object at 0x7ff0ca2d6a90>
[2, 4, 6]

'''