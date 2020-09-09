package basico;

public class Funcoes {

	public static void main(String[] args) {
		
		int n = 5; // desejo calcular fatorial de 5
		int ac = 1; // acumulador
		for (int i = n; i > 1; i--) {
			ac = ac * i;
		}
		System.out.printf("Fatorial de 5 é: %d", ac);
		
		n = 6; // agora, calcular o fatorial de 6
		ac = 1;
		for (int i = n; i > 1; i--) {
			ac = ac * i;
		}
		System.out.printf("\nFatorial de %d é: %d", n, ac);		
		
		// invocando a "função" para obter o fatorial de 7
		System.out.printf("\nFatorial de 7 é: %d", fat(7));
		
		/* Resultado da execução:
		Fatorial de 5 é: 120
		Fatorial de 6 é: 720
		Fatorial de 7 é: 5040
		*/
	}
	// função/método para calcular fatorial
	public static int fat(int n) {
		int ac = 1;
		for (int i = n; i > 1; i--) {
			ac = ac * i;
		}
		return ac;
	}
}