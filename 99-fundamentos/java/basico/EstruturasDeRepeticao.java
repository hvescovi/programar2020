package basico;

public class EstruturasDeRepeticao {

	public static void main(String args[]) {
		
		System.out.print("Repetição por contador (while): ");
		int contador = 1;
		while (contador <= 10) { // variação de 1 a 10
			System.out.printf("%d ", contador);
			contador++;
		}
		
		System.out.print("\nRepetição controlada por sentinela: ");
		int sentinela = 0; // controlador da repetição
		contador = 1;
		while (sentinela == 0) {
			System.out.printf("%d ", contador);
			contador++;
			if (contador == 11) { // condição de fim da repetição
				sentinela = 1; //sinalizar encerramento de repetição
			}
		}
		
		
	}	
}