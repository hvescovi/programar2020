package exercicios;

import java.util.Random;

public class SorteioAutomatico {

	public static void main(String[] args) {
		
		// LÓGICA DE PROGRAMAÇÃO:
		// inicializa número de acertos igual a zero
		// percorrer os números de 1 a 100 (contador)
		  // sortear um número
		  // se o número sorteado for igual ao contador
		    // aumentar o número de acertos

		Random r  = new Random(); // gerador de números aleatórios
				
		// FOR
		int acertos = 0;
		int sorteado;
		for (int i = 1; i <= 100; i++) {
			sorteado = 	r.nextInt(99) + 1;
			if (sorteado == i) {
				acertos++;
			}
		}
		System.out.printf("\nAcertos (for): %d", acertos);
		
		// WHILE
		acertos = 0;
		int i = 1;
		while (i <= 100) {
			sorteado = 	r.nextInt(99) + 1;
			if (sorteado == i) {
				acertos++;
			}
			i++;
		}
		System.out.printf("\nAcertos (while): %d; i=%d", acertos, i);
		
		// DO WHILE
		acertos = 0;
		i = 1;
		do {
			sorteado = 	r.nextInt(99) + 1;
			if (sorteado == i) {
				acertos++;
			}
			i++;
		} while (i <= 100);
		System.out.printf("\nAcertos (do while): %d; i=%d", acertos, i);
	}
}