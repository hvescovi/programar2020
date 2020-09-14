package basico.colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Pessoa {
	String nome;
	float peso;
	float altura;
	
	public Pessoa(String n, float p, float a) {
		nome = n;
		peso = p;
		altura = a;
	}
	public static Comparator<Pessoa> PesoComparator = new Comparator<Pessoa>(){
		public int compare(Pessoa p1, Pessoa p2) {
			//return (int) (p2.peso*100 - p1.peso*100); // decrescente
			return (int) (p1.peso*100 - p2.peso*100);
		}
	};
	public static Comparator<Pessoa> AlturaComparator = 
			new Comparator<Pessoa>() {
		public int compare(Pessoa p1, Pessoa p2) {
			//return (int) (p1.altura*100 - p2.altura*100);
			return (int) (p2.altura*100 - p1.altura*100); // decrescente
		}
	};
	public static Comparator<Pessoa> NomeComparator = 
			new Comparator<Pessoa>() {
		public int compare(Pessoa p1, Pessoa p2) {
			return p1.nome.compareTo(p2.nome); // crescente
		}
	};
	public static void main(String[] args) {
		// criar e popular a lista
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		Pessoa joao = new Pessoa("Joao", 67f, 1.72f);
		Pessoa maria = new Pessoa("Maria", 60f, 1.7f);
		Pessoa tiago = new Pessoa("Tiago", 80f, 1.8f);
		pessoas.add(joao); 
		pessoas.add(maria); 
		pessoas.add(tiago);
		
		// ordernar a lista de pessoas, por peso
		Collections.sort(pessoas, Pessoa.PesoComparator);
		System.out.print("Listagem de pessoas por ordem de peso:");
		for (Pessoa p : pessoas) { // exibir a lista
			System.out.printf("\n %s, peso: %.2f", p.nome, p.peso);
		}
		/* resultado da execução: 
		Listagem de pessoas por ordem de peso:
		 Maria, peso: 60.00
		 Joao, peso: 67.00
		 Tiago, peso: 80.00 
		 */
		
		// ordernar a lista de pessoas, por altura
		Collections.sort(pessoas, Pessoa.AlturaComparator);
		System.out.print("\nListagem de pessoas por ordem de altura (dec):");
		for (Pessoa p : pessoas) { // exibir a lista
			System.out.printf("\n %s, altura: %.2f", p.nome, p.altura);
		}
		/* resultado da execução:
		Listagem de pessoas por ordem de altura (dec):
		 Tiago, altura: 1.80
		 Joao, altura: 1.72
		 Maria, altura: 1.70
		*/
		
		// ordernar a lista de pessoas, por nome
		Collections.sort(pessoas, Pessoa.NomeComparator);
		System.out.print("\nListagem de pessoas por nome:");
		for (Pessoa p : pessoas) { // exibir a lista
			System.out.printf("\n %s", p.nome);
		}
		/* resultado da execução:
		Listagem de pessoas por nome:
		 Joao
		 Maria
		 Tiago
		*/
	}
}