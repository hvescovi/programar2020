package exercicios;

public class RaizesEquacaoSegundoGrau {

	public static void main(String[] args) {
		
		// programa para calcular raizes de uma equacao de segundo grau
		int a = 1;
		int b = 2;
		int c = -1;
		System.out.printf("Termos: a=%d, b=%d, c=%d \n", a, b, c);
		int delta = b * b - 4 * a * c;
		if (delta < 0) {
		  System.out.println("Não tem raízes reais");
		} else if (delta == 0) {
		  System.out.print("Uma raiz real: ");
		  double raiz = (- b) / 2.0 * a;
		  System.out.println(raiz);
		} else {
		  System.out.print("Duas raízes reais: ");
		  double r1 = - b + Math.sqrt(delta) / 2 * a;
		  double r2 = - b - Math.sqrt(delta) / 2 * a;
		  System.out.printf("%f e %f \n", r1, r2);
		}
		
		// usando a função
		System.out.println("Termos: a=1, b=2, c=-1");
		System.out.println(raizes(1, 2, -1));
		
		System.out.println("Termos: a=1, b=3, c=4");
		String s = raizes(1, 3, 4);
		System.out.println(s);

		System.out.println("Termos: a=1, b=2, c=1");
		System.out.println(raizes(1, 2, 1));
	}

	public static String raizes(int a, int b, int c) {
	  int delta = b * b - 4 * a * c;
	  String s;
	  if (delta < 0) {
	    return "Não tem raízes reais";
	  } else if (delta == 0) {
	    s = "Uma raiz real: ";
	    double raiz = (- b) / 2.0 * a;
	    s = s + String.valueOf(raiz);
	    return s;
	  } else {
	    s = "Duas raízes reais: ";
	    double r1 = - b + Math.sqrt(delta) / 2 * a;
	    double r2 = - b - Math.sqrt(delta) / 2 * a;
	    s = s + String.valueOf(r1) + " e " + String.valueOf(r2);
	    return s;
	  }
	}
}