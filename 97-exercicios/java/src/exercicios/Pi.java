package exercicios;

public class Pi {

	public static void main(String[] args) {
		
		// calcular série 4 - 4/3 + 4/5 - 4/7 + 4/9 - 4/11 +... variando termos
		
		int denominador; // vai variar: 3, 5, 7, ...
		int sinal; // vai variar: -1, 1, -1, 1, ...
		int termos = 10; // 3000 termos p/ 3.141; e 3.1415? 3.14159? 
		double soma = 0; // acumulador de cada somatório
		double termo; // auxiliar para cálculo de cada termo
		for (int i = 2; i <= termos; i++) {
			soma = 4; // valor inicial de toda série de pi
			sinal = -1; // vai começar decrementando 4/3
			denominador = 3; // idem anterior :-)
			// percorrer o somatório na quantidade atual de termos
			for (int t = 2; t <= i; t++) {
		        termo = (4.0 * sinal) / denominador; // calcula o termo!
		        soma += termo; // acumula na série
		        sinal *= -1; // prepara o próximo termo: inverte o sinal...
		        denominador += 2; // ... e incrementa o denominador
			}
			System.out.printf("\nSérie com %d termos: %f", i, soma);
		}	
		System.out.printf("\nÚltima soma calculada: %f", soma);
	}
}