package basico;

class TiposDeDados {

    public static void main(String args[]) {

        // armazenar uma informação em uma variável do tipo texto
        String nome = "João Paulo da Silva";
        // exibir a informação
        System.out.println("O nome é: " + nome);

        // calcular a soma de três números
        int a = 5;
        int b = 6;
        int c = 11;
        int total = a + b + c;
        // exibir a soma
        System.out.printf("Prezado %s, a soma de %d, %d e %d é: %d\n",
            nome, a, b, c, total);

        // calcular uma nota média
        double av1 = 7.5;
        double av2 = 8; // poderia ser 8.0
        double media = (av1 + av2) / 2; // média aritmética
        System.out.printf("Média entre %.2f e %.2f é %.2f\n", av1, av2, media);
    }
}

// ADICIONAR ENUM livro Estruturas de Dados e Algoritmos  GoodRich, pg 14
// trazer final da seção de estrututas de controle básicas para cá (tem tipos de dados lá)