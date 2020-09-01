package exercicios;

import java.util.Scanner;

public class CalculosSalaRetangular {

	public static void main(String args[]) {
		
		double largura=0;
		double comprimento=0; 
		int op;
		
		do {
			// exibir menu do sistema
			System.out.println("\nCálculos sobre a sala retangular. Opções: ");
			System.out.println("1 - entrar com as dimensões da sala (metros)");
			System.out.println("2 - calcular e exibir o perímetro da sala");
			System.out.println("3 - calcular e exibir a área da sala");
			System.out.println("4 - calcular a quantidade de caixas de "
					+ "azulejos necessárias para cobrir a sala de azulejos "
					+ "(cada caixa cobre 2.5 metros quadrados");
			System.out.println("0 - sair do programa");
			System.out.print("Opção: ");
			
			// ler opção do usuário
			Scanner teclado = new Scanner(System.in);
			op = teclado.nextInt();
			
			switch (op) { // qual foi a opção escolhida?
				case 1: 
					// ler largura e comprimento
					System.out.println("Informe a largura da "
							+ "sala (em metros): ");
					largura = teclado.nextDouble();
					System.out.println("Informe o comprimento "
							+ "da sala (em metros): ");
					comprimento = teclado.nextDouble();
					break;
				case 2:
					// calcular o perímetro
					double per = largura * 2 + comprimento * 2; 
					System.out.printf("> Perímetro da sala: %.2f metros", per);
					break;
				case 3:
					double area = largura * comprimento; // calcular área
					System.out.printf("> Área da sala: %.2f metros", area);
					break;
				case 4:
					 // quantas caixa serão necessárias?
					double caixas = (largura * comprimento) / 2.5;
					int parteInteira = (int) caixas; // obter a parte inteira
					// se houve parte decimal na quantidade de caixas...
					if ((caixas - parteInteira) != 0) { 
						// aumentar a parte inteira, para não usar "parte" de
						// uma caixa; é melhor sobrar azulejo do que faltar
						parteInteira++; 
					}
					System.out.printf("> Caixas de azulejo necessárias: %d ", 
							parteInteira);
					break;
			}
		} while (op != 0); // enquanto a opção não for zero, continua
		System.out.println("\nPrograma encerrado.");
	}
	
}