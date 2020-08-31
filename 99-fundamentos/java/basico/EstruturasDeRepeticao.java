package basico;

import java.util.Random;

public class EstruturasDeRepeticao {

	public static void main(String args[]) {
		
		System.out.print("Repetição por contador (while): ");
		int contador = 1;
		while (contador <= 10) { // variação de 1 a 10
			System.out.printf("%d ", contador);
			contador++;
		}
		
		System.out.print("\nRepetição controlada por sentinela: ");
		int sentinela = 0; // controlador da repetição
		contador = 1;
		while (sentinela == 0) {
			if (contador % 4 == 0 && contador % 3 == 0 && contador > 20) {
				sentinela = 1; //sinalizar encerramento de repetição
				System.out.printf("Valor que atende a condição: %d", contador);
			} else {
				contador++;
			}
		}
		
		System.out.print("\nRepetição com for: ");
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%d ", i);
		}
		System.out.print("\nRepetição com for (passo negativo): ");
		for (int i = 10; i > 0; i-=2) {
			System.out.printf("%d ", i);
		}
		
		System.out.print("\nRepetição do while");
		int n; // variável que vai receber números aleatórios sorteados
		Random r  = new Random(); // gerador de números aleatórios
		do {
			n = r.nextInt(5); // sorteia um número inteiro entre 0 e 5
			System.out.printf("\nNúmero escolhido: %d", n);
		} while (n != 1); // enquanto n não for igual a 1, repete
		
		System.out.println("Desenho de um triângulo com for");
		for (int i = 1; i <= 10; i++) { // desenhar um triângulo
			System.out.println(("*").repeat(i));
		}
		/*		o resultado do for acima é o desenho deste triângulo (linhas 51 a 60)
		
		*
		**
		***
		****
		*****
		******
		*******
		********
		*********
		**********

		 */
	}	
}