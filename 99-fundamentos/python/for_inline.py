print('\n * exibir números de 1 a 10')
for n in range(1,11):
    print(n, end='')

print('\n * versão inline')
[ print(n, end='') for n in range(1,11)]

print('\n * percorrer lista de pessoas e mostrá-las')
pessoas = ["Joao", "Maria", "Suzana", "Telmo", "Martha", "Rick"]
for p in pessoas:
    print(p, end='')

print('\n * versão inline')
[ print(p, end='') for p in pessoas]
print('\n * com índices e bonito')
[ print(str(i)+")",pessoas[i]+", ", end='') for i in range(0,len(pessoas))]

print('\n * mostrar somente as pessoas que estão em posições pares da lista')
for i in range(0,len(pessoas)):
    if i % 2 == 0 and i > 0:
        print(pessoas[i]) # Suzana e Martha estão em posição par

print(' * versão inline')
[ print(pessoas[i]) for i in range(0,len(pessoas)) if i % 2 == 0 and i > 0]