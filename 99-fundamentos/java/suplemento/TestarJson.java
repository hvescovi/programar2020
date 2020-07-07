package suplemento;

public class TestarJson {

	public static void main(String args[]) {
		// cria uma pessoa
		Pessoa p = new Pessoa("João da Silva", "josilva@gmail.com", "99232-1212");
		// obtém a versão json da pessoa e exibe essas informações
		System.out.println(p.json());
	}
}
