package exercicios;

public class PiSimplificado {

	public static void main(String[] args) {
		
		// calcular série 4 - 4/3 + 4/5 - 4/7 + 4/9 - 4/11 +... variando termos
		
		int denominador = 3; // vai variar: 3, 5, 7, ...
		int sinal = -1; // vai variar: -1, 1, -1, 1, ...
		int termos = 10; // 3000 termos p/ 3.141; e 3.1415? 3.14159? 
		double soma = 4; // acumulador de cada somatório
		// percorrer o somatório na quantidade atual de termos
		for (int t = 2; t <= termos; t++) {
	        double termo = (4.0 * sinal) / denominador; // calcula o termo!
	        soma += termo; // acumula na série
	        sinal *= -1; // prepara o próximo termo: inverte o sinal...
	        denominador += 2; // ... e incrementa o denominador
		}
		System.out.printf("\nSérie com %d termos: %f", termos, soma);
	}
}