package dao.memoria;

import java.util.ArrayList;

import dao.DAOException;
import dao.PessoaDAOInterface;
import modelo.Pessoa;

public class PessoaDAO implements PessoaDAOInterface {
	private ArrayList<Pessoa> pessoas = new ArrayList();
	public ArrayList<Pessoa> retornarPessoas() {
		return pessoas;
	}
	public void incluirPessoa(Pessoa nova) throws DAOException {
		pessoas.add(nova);
	}
	public void removerPessoa(String nome) {
		int encontrado = -1; // variável para sinalizar sucesso da busca
		for (int i = 0; i < pessoas.size(); i++) { // percorrer a lista 
			if (pessoas.get(i).getNome().equals(nome)) { // achou?
				encontrado = i; // sinaliza a posição da pessoa encontrada
				break; // interrompe a busca
			}
		}
		if (encontrado > 0) { // se achou...
			pessoas.remove(encontrado);
		}
	}
	@Override
	public void reiniciarDados() {
		// n�o faz nada		
	}
}