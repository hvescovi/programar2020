package modelo;

public class Pessoa {

    public String nome;
    public String email;
    public String telefone;

    // construtor vazio
    public Pessoa(){};
    
    // construtor com parâmetros
    public Pessoa(String n, String e, String telefone) {
        nome = n;
        email = e;
        this.telefone = telefone;
    }    
}