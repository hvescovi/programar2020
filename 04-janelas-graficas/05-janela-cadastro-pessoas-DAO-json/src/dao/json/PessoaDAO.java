package dao.json;

import modelo.Pessoa;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class PessoaDAO {
	String caminho = "C:/temp/";
	String nomeArquivo = "pessoas.json";
	public void incluirPessoa(Pessoa nova) {
		// modelar a pessoa em json
		JsonObject novo = Json.createObjectBuilder().add(
				"nome", nova.getNome()).add("email", nova.getEmail())
				.add("telefone", nova.getTelefone()).build();
		// conteudo final que será escrito no arquivo,
		// ao final do processamento
		String gravar = "";
		// o arquivo json já existe?
		File f = new File(caminho + nomeArquivo);
		if (f.exists() && !f.isDirectory()) {
			try {
				// carregar o arquivo
				String conteudo = new String(
						Files.readAllBytes(Paths.get(caminho + nomeArquivo)));
				// converter a string para json (parsing)
				JsonReader reader = Json.createReader(new StringReader(conteudo));
				// carregar os dados no vetor
				JsonArray ja = reader.readArray();
				// fechar o leitor, o trabalho foi feito :-)
				reader.close();
				// criar array que pode ser modificado
				JsonArrayBuilder jab = Json.createArrayBuilder();
				// percorre os dados lidos
				for (int i = 0; i < ja.size(); i++) {
					// converte em objeto json
					JsonObject tmp = (JsonObject) ja.get(i);
					// adiciona no novo vetor
					jab.add(tmp);
				}
				// adicionar o novo elemento no novo vetor
				jab.add(novo);
				// preparar conteúdo a ser gravado
				gravar = jab.build().toString();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// construir vetor com apenas 1 elemento
			JsonArray jab = Json.createArrayBuilder().add(novo).build();
			// preparar conteúdo a ser gravado
			gravar = jab.toString();
		}
		// gravar o novo conteúdo no arquivo
		try {
			Files.write(Paths.get(caminho + nomeArquivo), gravar.getBytes("utf-8"), StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Pessoa> retornarPessoas() {
		// prepara a lista de retorno
		ArrayList<Pessoa> pessoas = new ArrayList();
		// o arquivo json já existe?
		File f = new File(caminho + nomeArquivo);
		if (f.exists() && !f.isDirectory()) {
			try {
				// carregar o arquivo
				String conteudo = new String(
						Files.readAllBytes(Paths.get(caminho + nomeArquivo)));
				// converter a string para json (parsing)
				JsonReader reader = Json.createReader(new StringReader(conteudo));
				// carregar os dados no vetor
				JsonArray ja = reader.readArray();
				// percorre os dados lidos
				for (int i = 0; i < ja.size(); i++) {
					// obtém o objeto json
					JsonObject tmp = (JsonObject) ja.get(i);
					// cria o objeto Pessoa
					Pessoa alguem = new Pessoa(tmp.getString("nome"), tmp.getString("email"),
							tmp.getString("telefone"));
					// adiciona a pessoa no array
					pessoas.add(alguem);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pessoas;
	}

	public void removerPessoa(String nome) {
		// exercicio para você fazer :-)
	}

	public void reiniciarDados() {
		// o arquivo json já existe?
		Path p = Paths.get(caminho + nomeArquivo);
		if (Files.exists(p)) {
			// apaga o arquivo
			try {
				Files.delete(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}