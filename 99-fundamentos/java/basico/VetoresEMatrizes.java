package basico;

import java.util.Scanner;

public class VetoresEMatrizes {

	public static void main(String[] args) {
		
		// somando cinco números
		int a = 1;
		int b = 2;
		int c = 10;
		int d = 14;
		int e = 21;
		int soma = a + b + c + d + e;
		System.out.printf("=> Soma de %d, %d, %d, %d e %d: %d \n", 
				a, b, c, e, d, soma);
		
		/* resultado da execução:
		=> Soma de 1, 2, 10, 21 e 14: 48  
		*/
		
		// soma de cinco números, usando em um vetor
		soma = 0;
		int[] n = {4, 5, 8, 9, 3}; // vetor de números inteiros
	    System.out.print("=> Soma de: ");
		for (int i = 0; i < 5; i++) { // 5 repetições
			System.out.printf("%d ", n[i]); // mostra o "i"-ésimo número
			soma += n[i]; // soma o número no acumulador
		}
		System.out.printf("é igual a: %d \n", soma);
		
		/* resultado da execução:
		=> Soma de: 4 5 8 9 3 é igual a: 29
		*/ 
		
		// uma String é "quase" um vetor de caracteres!
		String frase = "A vida é bela, mas é preciso saber viver";
		int as = 0; // contador de letras "A"
		for (int i = 0; i < frase.length(); i++) { // percorrer a string
			char car = frase.charAt(i); // obtém o caracter de posição "i"
			if (car == 'a' || car == 'A') {
				as++;
			}
		}
		System.out.printf("=> '%s' possui %d letras 'a' \n", frase, as);
		
		/* resultado da execução:
		=> 'A vida é bela, mas é preciso saber viver' possui 5 letras 'a'   
		 */
		
		// criar um vetor para até 7 números (posições de 0 a 6)
		int[] numeros = new int[7]; // criando um vetor de tamanho fixo!
		int q = 0; // quantidade de números digitados
		Scanner sc = new Scanner(System.in);
		System.out.print("=> Digite números inteiros.");
		System.out.println(" Informe até 7 números, ou 0 para fim.");
		while (q <= 6) { // enquanto houve posições no vetor...
			System.out.print("Número inteiro: ");
			numeros[q] = sc.nextInt(); // ler o número na posição atual
			if (numeros[q] == 0) { // se for digitado zero, encerra
				break;
			}
			q++; // incrementa o contador de números lidos
		}
		if (q == 0) {
			System.out.println("Não foi digitado nenhum número!");
		} else {
			System.out.printf("* Foram digitados %d números: ", q); 
			for (int i = 0; i < q; i++) { // exibir os números digitados
				System.out.printf("%d ", numeros[i]);
			}
		}
		
		/* resultado de uma possível execução:
		=> Digite números inteiros. Informe até 7 números, ou 0 para fim.
        Número inteiro: 1
        Número inteiro: 3
        Número inteiro: 12
        Número inteiro: 0
        * Foram digitados 3 números: 1 3 12 
		*/
		
		// declarar uma matriz de números 3 x 3
		int[][] m = new int[3][3];
		// declarar um valor inicial
		int valor = 1;
		// percorrer até 3 linhas na matriz
		for (int linha = 0; linha < 3; linha++) {
			// percorrer até 3 colunas na matriz
			for (int coluna = 0; coluna < 3; coluna++) {
				// armazenar valores dobrados
				m[linha][coluna] = valor++*2;
			}
		}
		// exibir a matriz
		System.out.println("\n=> Matriz de números dobrados 3x3:");
		for (int y = 0; y < 3; y++) { // percorrer as linhas
			for (int x = 0; x < 3; x++) { // percorrer colunas
				System.out.printf("%d ", m[y][x]);
			}
			System.out.println(" "); // nova linha
		}
		/* resultado da execução: 
		=> Matriz de números dobrados 3x3:
        2 4 6  
        8 10 12  
        14 16 18 
		*/
	}
}