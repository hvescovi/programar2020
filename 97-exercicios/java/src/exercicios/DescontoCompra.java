package exercicios;

public class DescontoCompra {

	public static void main(String args[]) {
		
		int compra = 150; // compra de R$ 150,00 reais
		boolean cadastrado = true; // cliente cadastrado
		
		int desconto;
		if (compra < 100) {
			desconto = 5;
		} else if (compra <=500) {
			desconto = 8;
		} else { 
			desconto = 10;
		}
		
		// aplica o desconto escolhido em função do valor da compra
		// a divisão não pode ser 100, precisa ser por 100.0
		double valor = compra - compra * (desconto/100.0); 
		if (cadastrado) { // é cliente cadastrado?
			valor = valor * 0.95; // aplica desconto adicional
		}
		
		System.out.printf("Valor inicial da compra: %d", compra);
		System.out.printf("\nDesconto conforme valor da compra: %d%%", desconto);
		System.out.printf("\nCliente cadastrado? %s",  cadastrado ? "Sim" : "Não");
		System.out.printf("\nValor final da compra: %.2f",  valor);
	}
}
