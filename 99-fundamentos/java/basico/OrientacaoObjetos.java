package basico;

public class OrientacaoObjetos {

    public static void main(String args[]) {
    	// testes em PHP: http://phptester.net/
    	
    	// raiz quadrada: usa o método estático sqrt da classe Math
    	System.out.print("Raiz de 9: ");
    	System.out.println(Math.sqrt(9)); // em PHP: echo sqrt(9);

    	// exibindo parte de uma string
    	String mensagem = "Alô mundo";
    	// substring(posição inicial, posição final [exclusiva: não inclui])
    	System.out.println(mensagem.substring(4, 7)); // resultado: mun 
    	// em PHP: echo substring("Alô mundo", 4, 3);
    	// outra possibilidade..
    	System.out.println("Tudo vira objeto".substring(5, 9)); //res: vira
    	// em PHP: echo substr("Tudo vira objeto", 5, 4);
    	
    	// calculando o perímetro de um círculo de forma estruturada
    	int x = 5;
    	int y = 3;
    	int raio = 2;
    	System.out.printf("O círculo em %d,%d tem perímetro %.2f", 
    			x, y, calcularPerimetro(raio));
    	// saída: O círculo em 5,3 tem perímetro 12.56
    	
    	// círculo orientado a objeto :-)
    	Circulo c = new Circulo();
    	c.x = 5;
    	c.y = 3;
    	c.raio = 2;
    	System.out.printf("\nCírculo (objeto) em %d,%d tem perímetro %.2f", 
    			c.x, c.y, c.perimetro());
    	// saída: Círculo (objeto) em 5,3 tem perímetro 12.56
    }
    
    public static float calcularPerimetro(int raio) {
    	return  2f * 3.14f * raio;
    }
}

class Circulo { // classe interna (não é pública!)
	int x;
	int y;
	int raio;
	public float perimetro() {
		return  2f * 3.14f * raio;
	}
}
