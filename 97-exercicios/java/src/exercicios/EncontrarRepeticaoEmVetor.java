package exercicios;

import java.util.Random;

public class EncontrarRepeticaoEmVetor {

	public static void main(String args[]) {
		
		Random r  = new Random(); // gerador de números aleatórios
		int numeros[] = new int[8]; // cria um vetor de 8 posições
		System.out.print("Vetor de 8 números entre 1 e 20: ");
		for (int i = 0; i < 8; i++) { // percorrer o vetor
			numeros[i] = r.nextInt(19) + 1; // armazenar o número entre 1 e 20
			System.out.printf("%d ", numeros[i]);
		}
		
		// verificar se houve repeticao
		boolean existeRepetido = false;
		for (int i = 1; i < 8; i++) { // percorre os números, a partir do segundo número
			// existe esse número no subvetor anterior ao número?
			if (existeNoVetor(numeros, numeros[i], i-1)) { 
				existeRepetido = true;
				break;
			}
		}
		
	    System.out.print("\nExistem números repetidos? ");
	    System.out.println(existeRepetido?"Sim":"Não");
		
	}
	public static boolean existeNoVetor(int[] vetor, int procurado, int limiteDeBusca) {
		// procura o númer até o limite informado
		for (int i = 0; i <= limiteDeBusca; i++) {
			if (vetor[i] == procurado) { // achou?
				return true;
			}
		}
		return false; // se não achou, retorna false
	}
}
