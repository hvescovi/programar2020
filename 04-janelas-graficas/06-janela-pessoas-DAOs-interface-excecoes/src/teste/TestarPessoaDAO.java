package teste;

import java.io.IOException;

//import dao.memoria.PessoaDAO;
import dao.json.PessoaDAO;
import modelo.Pessoa;

public class TestarPessoaDAO {

	public static void main(String args[]) {
		// instanciar o DAO
		PessoaDAO pdao = new PessoaDAO();
		// reiniciar o arquivo
		pdao.reiniciarDados();
		// incluir pessoas
		try {		
			pdao.incluirPessoa(new Pessoa("Tiago Tomé", "tito@gmail.com", "47 9 9231 1234"));
			pdao.incluirPessoa(new Pessoa("Suzana Vieira", "suvi@gmail.com", "47 9 9312 5324"));
			pdao.incluirPessoa(new Pessoa("Paulo Horn", "pahorn@gmail.com", "47 9 8853 5342"));
		} catch (IOException ex) {
			System.out.println("(ERRO) Não foi possível acessar: "+ex.getMessage());
			System.exit(0);
		}
		System.out.println("3 pessoas criadas");
		// listar pessoas
		for (Pessoa p : pdao.retornarPessoas()) {
			System.out.println(p);
		}
		// remover pessoa
		pdao.removerPessoa("Paulo Horn");
		System.out.println("Pessoas após remoção: ");
		for (Pessoa p : pdao.retornarPessoas()) {
			System.out.println(p);
		}
		// limpando o teste
		pdao.reiniciarDados();
		System.out.println("Testes concluídos");
	}
}
