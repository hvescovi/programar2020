package exercicios;

import java.util.Scanner;

public class QuantidadeParesImpares {

	public static void main(String args[]) {
		
		int pares = 0; // contador de números pares
		int impares = 0; // contador de números ímpares
		int contador = 1; // contador de números solicitados
		Scanner teclado = new Scanner(System.in);
		System.out.println("Contador de pares e ímpares (10  números)");
		while (contador <= 10) { // serão solicitados 10 números
			System.out.print("Digite um número: ");
			int n = teclado.nextInt(); // ler um número do teclado
			if (n % 2 == 0)  { // o número é par?
				pares++; // incrementa contador de pares
			} else {
				impares ++; // incrementa contador de ímpares
			}
		    contador++; // atualizar o contador de números
		}
		System.out.println("Quantidades de números informados: ");
		System.out.printf("Pares: %d, ímpares: %d", pares, impares);
	}
}