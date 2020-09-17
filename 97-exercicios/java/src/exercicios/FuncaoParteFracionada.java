package exercicios;

public class FuncaoParteFracionada {

	public static void main(String[] args) {
		System.out.printf("A parte fracionada de 10.2 é: %d", 
				retornarParteFracionada(10.273f));

		System.out.printf("\nA parte fracionada de 129.1928 é: %d", 
				retornarParteFracionada(129.1928f));
	}
	
	public static int retornarParteFracionada(float n) {
		// função construída via manipulação de strings, 
		// pois 10.0 - 10.2 = 1.99999981 devido a questões de precisão
		
		String s = String.valueOf(n);
		if (!s.contains(".")) {
			return 0;
		} else {
			// em qual posição se encontra o ponto?
			int pos = s.indexOf(".");
			// obter os números depois do ponto
			String depois = s.substring(pos+1);
			return Integer.valueOf(depois);
		}		
	}
}
