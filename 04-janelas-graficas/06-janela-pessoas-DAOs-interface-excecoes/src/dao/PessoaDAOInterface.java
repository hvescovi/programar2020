package dao;

import java.io.IOException;
import java.util.ArrayList;
import modelo.Pessoa;

public interface PessoaDAOInterface {
	public void incluirPessoa(Pessoa nova) throws IOException;
	public ArrayList<Pessoa> retornarPessoas();
	public void reiniciarDados();
	public void removerPessoa(String nome);
}