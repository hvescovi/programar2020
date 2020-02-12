package modelo;

public class Pessoa {

    private String nome;
    private String email;
    private String telefone;

    // construtor vazio
    public Pessoa(){};
    
    // construtor com parâmetros
    public Pessoa(String n, String e, String t) {
        setNome(n);
        setEmail(e);
        setTelefone(t);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.contains("@")) {
            this.email = "INVALIDO";
        } else {
            this.email = email;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
