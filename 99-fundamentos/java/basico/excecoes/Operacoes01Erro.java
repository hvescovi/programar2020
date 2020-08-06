package basico.excecoes;
import java.util.Scanner;

public class Operacoes01Erro {
    public static void main(String[] args) {
        System.out.print("Divisão de números. Digite o numerador: ");
        Scanner sc = new Scanner(System.in); // cria leitor do teclado
        int n = sc.nextInt(); // aguarda digitação de número
        System.out.print("Digite o denominador: ");
        int d = sc.nextInt(); // aguarda digitação de número
        float resultado = ((float) n)/d; // calcula a divisão
        System.out.format("%d dividido por %d é %.2f",n,d,resultado);
    }    
}