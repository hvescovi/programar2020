package basico;

public class EstruturasCondicionais {

	public static void main(String args[]) {
		
		int tri = 93;  // nível de triglicérides (hipotético)
		int col = 174;  // nível de colesterol (hipotético)
		if (tri <= 150) { // condição para o triglicérides
			System.out.println("Triglicérides normal");
		} else { 
			System.out.println("Triglicérides ALTO, insira canela na dieta");
		}
		if (col <= 190) {  // condição para o colesterol
			System.out.println("Colesterol normal");
		} else {
			System.out.println("Colesterol ALTO, consuma menos açúcar");
		}
		if (tri > 150 && col > 190) {  // condição dupla
			System.out.println("Comece a caminhar 30 minutos por dia!");
		}
		
		int refeicoes = 8; // quantas refeições o cliente já fez anteriormente?
		boolean acertouPeso = true; // o cliente acertou o peso?
		if (refeicoes >= 10 || acertouPeso) {
			System.out.println("Você ganhou o seu almoço!");
		} else {
			System.out.println("Você acumulou mais um almoço no seu cartão");
		}
		
		int modoPagamento = 1; // 0: dinheiro, 1: cheque, 2: débito, 3: crédito	
		switch (modoPagamento) {
		case 0: 
			System.out.println("Pagamento à vista em dinheiro");
			break;
		case 1: 
			System.out.println("Pagamento em cheque");
			break;
		case 2:
		    System.out.println("Pagamento no cartão de débito");
			break;
		case 3:
		    System.out.println("Pagamento no cartão de crédito");
			break;			
		default:
		    System.out.println("Não sei como você vai pagar :-/ ");
		}
	}	
}