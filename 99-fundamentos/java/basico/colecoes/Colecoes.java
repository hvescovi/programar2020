package basico.colecoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import suplemento.Pessoa;

public class Colecoes {

	public static void main(String[] args) {
		
		// criar as pessoas
        Pessoa joao = new Pessoa("Joao", "Rua 9", "3232-1415");
        Pessoa maria = new Pessoa("Maria", "Beco das Flores", "3321-7658");
        Pessoa teresa = new Pessoa("Teresa", "Avenida Primavera", "99422-4212");
        
        // criar a lista de pessoas e populá-la
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(joao);
        pessoas.add(maria);
        pessoas.add(teresa);
        
        // remover a segunda pessoa (posições das pessoas: 0, 1 e 2)
        System.out.print("Segunda pessoa: ");
        System.out.println(pessoas.get(1).getNome());
        pessoas.remove(1);
        System.out.print("Segunda pessoa (após exclusão): ");
        // a segunda pessoa agora é Teresa
        System.out.println(pessoas.get(1).getNome());
        
        /* Resultado da execução do programa:         
         Segunda pessoa: Maria
         Segunda pessoa (após exclusão): Teresa         
        */
        
        // programadores e suas habilidades
        // quem sabe Java?
        HashSet<Pessoa> sabemJava = new HashSet<Pessoa>();
        sabemJava.add(joao);
        sabemJava.add(teresa);
        
        // quem sabe PHP?
        HashSet<Pessoa> sabemPhp = new HashSet<Pessoa>();
        sabemPhp.add(maria);
        sabemPhp.add(teresa);
        
        // consulta 1: quem sabe Java e PHP? (interseção)
        // primeiro: copia primeiro quem sabe Java
        HashSet<Pessoa> sabemJavaEPhp = new HashSet<Pessoa>(sabemJava);
        // agora, mantém apenas quem sabe PHP
        sabemJavaEPhp.retainAll(sabemPhp);
        System.out.print("Sabem Java e PHP: ");
        for (Pessoa p: sabemJavaEPhp){ // percorrer o conjunto
            System.out.println(p.getNome());
        }
 
        // consulta 2: quem sabe Java mas não sabe Php?
        // primeiro, copia quem sabe Java
        HashSet<Pessoa> sabemJavaMasNaoPhp = new HashSet<Pessoa>(sabemJava);
        // agora, remove os que sabem PHP
        sabemJavaMasNaoPhp.removeAll(sabemPhp);
        System.out.print("Sabem Java mas não sabem PHP: ");
        for (Pessoa p: sabemJavaMasNaoPhp){
            System.out.println(p.getNome());
        }
        
        /* Resultado da execução:
        Sabem Java e PHP: Teresa
        Sabem Java mas não sabem PHP: Joa
        */
        
        // mapeamento de pessoas por meio de CPF
        HashMap<String, Pessoa> mapa = new HashMap<String, Pessoa>();
        mapa.put("12345678910", joao);
        mapa.put("09876543211", maria);
        mapa.put("13243546578", teresa);
        
        // localizar uma pessoa pelo CPF
        Pessoa alguem = mapa.get("13243546578");
        System.out.println("Nome: "+alguem.getNome());
        
        /* Resultado da execução:
        Nome: Teresa
        */
        
        // recurso especial de lista: ordenação
        
        // cria um vetor de nomes de cores
        String[] nomesCores = {"Azul", "Amarelo", "Verde", 
        		"Cinza", "Preto", "Branco", "Laranja", "Roxo"};
        // cria uma lista baseada no vetor
        ArrayList<String> cores = new 
        		ArrayList<String>(Arrays.asList(nomesCores));
        // ordena crescente
        Collections.sort(cores);
        System.out.print("Cores em ordem crescente: ");
        for (String cor : cores) {
        	System.out.printf("%s ", cor);
        }
        
        /* resultado da execução:
        Cores em ordem crescente: Amarelo Azul Branco Cinza Laranja 
          Preto Roxo Verde 
        */
        
        // embararalha a ordem
        Collections.shuffle(cores);
        System.out.print("\nCores em ordem embaralhada: ");
        for (String cor : cores) {
        	System.out.printf("%s ", cor);
        }
        
        /* resultado da execução:
        Cores em ordem embaralhada: Amarelo Roxo Cinza Preto Branco 
          Verde Azul Laranja 
        */
	}
}