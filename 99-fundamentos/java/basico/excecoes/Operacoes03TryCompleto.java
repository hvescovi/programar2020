package basico.excecoes;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Operacoes03TryCompleto {
    public static void main(String[] args) {
        System.out.println("Programa que divide números");
        System.out.print("Digite o numerador: ");
        Scanner sc = new Scanner(System.in);
        int d = -1; //inicializar variável para que exista fora do try
        try {
            int n = sc.nextInt();
            System.out.print("Digite o denominador: ");
            d = sc.nextInt();
            if (d == 0) {
                System.out.println("Erro: denominador igual a zero.");
            } else {
            	float resultado = (float) n / d;
            	System.out.format("%d dividido por %d é %.2f",n, d, resultado);
            }
        } catch (InputMismatchException im) {
            System.out.println("Foi informado um valor que não é um número!");
        }
    }
}