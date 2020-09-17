package exercicios;

public class FuncaoDescontoCompra {

	public static void main(String[] args) {
		
		int desconto = calcularDesconto(150, true); 
		System.out.printf("Se comprar %d e cadastrado=%b, desconto=%d por cento, e "
				+ "valor final é: %.2f", 150, true, desconto, 
				150.0 - (float) 150*desconto/100);
	}
	
	public static int calcularDesconto(int compra, boolean cadastrado) {
		
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
		
		// retorna o desconto devido
		return 100 - (int) valor * 100 / compra;
	}

}
