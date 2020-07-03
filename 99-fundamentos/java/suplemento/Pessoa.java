package suplemento;

import javax.json.Json;
import javax.json.JsonObject;

public class Pessoa {

	private String nome;
	private String email;
	private String telefone;
	
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getTelefone() { return telefone; }
	public void setTelefone(String telefone) { this.telefone = telefone; }
	public Pessoa(String nome, String email, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	public String json() {
		JsonObject jo = Json.createObjectBuilder()
				.add("nome", getNome())
				.add("email", getEmail())
				.add("telefone", getTelefone())
				.build();
		return jo.toString();
	}	
}