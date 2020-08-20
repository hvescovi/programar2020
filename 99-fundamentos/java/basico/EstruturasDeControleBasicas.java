package basico;

public class EstruturasDeControleBasicas {

	public static void main(String args[]) {
		
		// define um valor para a nota de um aluno
		double nota = 5;
		// verifica qual será a situação exibida
		if (nota >= 6) {
			System.out.println("Aprovado");
		} else {
			System.out.println("Reprovado");
		}
		
		// exibindo outra mensagem com base em condição de uma linha
		System.out.println(nota >= 6 ? "Parabéns": "Tente novamente");
		
		// dependendo do valor da nota, será exibida uma nota 
		if (nota >= 9) System.out.println("A");
		else if (nota >= 8) System.out.println("B");
		else if (nota >= 7) System.out.println("C");
		else if (nota >= 6) System.out.println("D");
		else System.out.println("E");
		
		// comando para exibir dez números
		System.out.println("1 2 3 4 5 6 7 8 9 10");
		
		// trecho de código para exibir novamente dez números
		int i = 1; // inicializa um contador com o valor 1
		while (i <= 10) { // deseja-se percorrer até o valor 10
			System.out.printf("%d ", i); // exibe o número
			i = i + 1; // incrementa o contador
		}
		
		// exibir os números, até 100, que são divisíveis por sete
		i = 1;
		System.out.print("\nNúmeros entre 1 e  100 divisíveis por 7: ");
		while (i <= 100) { // vamos até o 100!
			if (i % 7 == 0) { // o valor atual é divisível por sete?
				System.out.printf("%d ", i); // mostrar o número e um espaço
			}
			i++; // incrementa o contador de uma unidade
		}
		
		// operações & resultado após a execução
		i = 0;               // 0
		i += 4;            // 4
		i -= 1;             // 3
		i *= 6;            // 18 
		i /= 2;             // 9
		i %= 3;          // 0
		
		// operadores unários e suas ordens de uso
		System.out.println("\nOperadores unários");
		System.out.println(i++); // usa e depois incrementa; mostra: 0
		System.out.println(++i); // incrementa e depois usa; mostra: 2
		i = 10;
       System.out.println(--i); // mostra 9
       System.out.println(i--); // mostra 9
		
	   // tipos de dados primitivos
       boolean verdade = true; // 
       boolean maior = (5 > 7); // false
       char letra = 'A'; // '\u0000' até '\uFFFF'
       char ze = '\u005a'; // Z
       byte n = 100; // -128 a +127
       short ano = 2020; // -32768 a +32767
       int populacao = 300000; // -2.147.483.648 a 2.147.486.647
       long visualizacoes = 1234567890; // -9.233.372.036.854.775.808 a +isso-1
       float media = 9.9f; // -3.40292347E+38 a +isso
       double grande = 123456789.123456789; ; // -1.79769313486231570E+308 a +isso 
	}
}