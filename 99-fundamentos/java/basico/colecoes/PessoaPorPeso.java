package basico.colecoes;

import java.util.ArrayList;
import java.util.Collections;

public class PessoaPorPeso implements Comparable {
	String nome;
	float peso;
	float altura;
	
	public PessoaPorPeso(String n, float p, float a) {
		nome = n;
		peso = p;
		altura = a;
	}
	@Override
	public int compareTo(Object arg0) {
		PessoaPorPeso p = (PessoaPorPeso) arg0;
		return (int) (this.peso - p.peso) * 100;
		//return (int) (p.peso - this.peso) * 100; // ordem decrescente
	}
	public static void main(String[] args) {
		// criar e popular a lista
		ArrayList<PessoaPorPeso> pessoas = new ArrayList<PessoaPorPeso>();
		PessoaPorPeso joao = new PessoaPorPeso("Joao", 67f, 1.72f);
		PessoaPorPeso maria = new PessoaPorPeso("Maria", 60f, 1.7f);
		PessoaPorPeso tiago = new PessoaPorPeso("Tiago", 80f, 1.8f);
		pessoas.add(joao); pessoas.add(maria); pessoas.add(tiago);
		
		// ordenar a lista de pessoas, por peso
		Collections.sort(pessoas); 
		
		for (PessoaPorPeso p : pessoas) { // exibir a lista
			System.out.printf("\n %s, peso: %.2f", p.nome, p.peso);
		}
		/* resultado da execução:
		Maria, peso: 60.00
 		Joao, peso: 67.00
 		Tiago, peso: 80.00
		 */
	}
}
