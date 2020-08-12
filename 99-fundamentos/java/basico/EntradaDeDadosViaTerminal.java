package basico;

import java.util.Scanner;

class EntradaDeDadosViaTerminal {

    public static void main(String args[]) {

        // criar um mecanismo de entrada de dados via teclado no terminal
        Scanner sc = new Scanner(System.in);
        // aguardar a digitação de um número
        System.out.println("Digite um número inteiro: ");
        int n = sc.nextInt();
        // exibir o dobro do número digitado
        System.out.printf("O dobro do número digitado é: %d \n", n*2);

        // obter um nome de rua
        System.out.println("Digite o nome da rua na qual você reside: ");
        String rua = sc.next();
        System.out.println("Você mora na rua " + rua);
    }
}