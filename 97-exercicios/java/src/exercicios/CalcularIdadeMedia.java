package exercicios;

import java.util.Scanner;

public class CalcularIdadeMedia {

	public static void main(String args[]) {
		
		Scanner teclado = new Scanner(System.in);
		boolean continuar = true; // variável "sentinela": controla a repetição
		int idade; // variável para armazenar a idade digitada pelo usuário 
		float media = -1; // variável para armazenar a média
		System.out.println("Cálculo de média das idades (0 = terminar)");
		while (continuar) {
			System.out.print("Digite uma idade (em anos): ");
			idade = teclado.nextInt(); // ler um número do teclado
			if (idade > 0) { // é uma idade válida?
				if (media == -1) { // é a primeira idade informada?
					media = idade; // a primeira idade é a média :-)
				} else {
				    media = (media + idade) / 2; // atualiza a média
				}
			} else { // foi digitada uma idade igual a zero ou negativa? 
				continuar = false; // finalizar a execução
			}
		}
		System.out.printf("Média das idades fornecidas: %.1f ano(s)", media);
	}
}
