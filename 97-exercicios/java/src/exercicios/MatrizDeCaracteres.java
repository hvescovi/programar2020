package exercicios;

public class MatrizDeCaracteres {

	public static void main(String args[]) {
		
		char[][] a = new char[5][4];
		
		// .**.
		// *..*
		// ****
		// *..*
		// *..*
		
		// definição manual da matriz
		a[0][0] = ' '; a[0][1] = '*'; a[0][2] = '*'; a[0][3] = ' ';
		a[1][0] = '*'; a[1][1] = ' '; a[1][2] = ' '; a[1][3] = '*';
		a[2][0] = '*'; a[2][1] = '*'; a[2][2] = '*'; a[2][3] = '*';
		a[3][0] = '*'; a[3][1] = ' '; a[3][2] = ' '; a[3][3] = '*';
		a[4][0] = '*'; a[4][1] = ' '; a[4][2] = ' '; a[4][3] = '*';
		
		System.out.println("Letra A: ");
		
		// exibindo a matriz
		for (int linha = 0; linha < 5; linha++) {
			for (int coluna = 0; coluna < 4; coluna++) {
				System.out.print(a[linha][coluna]);
			}
			System.out.print("\n"); // quebra a linha
		}
		
		// outra forma...
		
		// ***
		// *  *
		// ***
		// *  *
		// ****
		
		char[][] b = preencheLetras("*** ", "*  *", "*** ", "*  *", "****");
		System.out.println("Letra B: ");
		mostraLetras(b);
		
		trocaCaracter(b, '@');
		mostraLetras(b);
	}
	
	public static char[][] preencheLetras(String l1, String l2, String l3, String l4, String l5) {
		// cria a matriz de retorno
		char[][] m = new char[5][4];
		
		m[0][0] = l1.charAt(0); m[0][1] = l1.charAt(1); m[0][2] = l1.charAt(2); m[0][3] = l1.charAt(3);
		
		String[] linhas = {l2, l3, l4, l5};
		
		for (int linha = 1; linha < 5; linha++) {
			for (int coluna = 0; coluna < 4; coluna++) {
				m[linha][coluna] = linhas[linha-1].charAt(coluna);
			}
		}
		
		/*
		a[1][0] = '*'; a[1][1] = ' '; a[1][2] = ' '; a[1][3] = '*';
		a[2][0] = '*'; a[2][1] = '*'; a[2][2] = '*'; a[2][3] = '*';
		a[3][0] = '*'; a[3][1] = ' '; a[3][2] = ' '; a[3][3] = '*';
		a[4][0] = '*'; a[4][1] = ' '; a[4][2] = ' '; a[4][3] = '*';
		*/
		
		return m;
	}
	
	public static void mostraLetras(char[][] matriz) {
		// exibindo a matriz
		for (int linha = 0; linha < 5; linha++) {
			for (int coluna = 0; coluna < 4; coluna++) {
				System.out.print(matriz[linha][coluna]);
			}
			System.out.print("\n"); // quebra a linha
		}
	}
	
	public static void trocaCaracter(char[][] m, char novoCaracter) {
		
		for (int linha = 0; linha < 5; linha++) {
			for (int coluna = 0; coluna < 4; coluna++) {
				if (m[linha][coluna] != ' ') { // se não for espaço em branco...
				    m[linha][coluna] = novoCaracter; // novo caracter!
				}
			}			
		}
	}
	
}