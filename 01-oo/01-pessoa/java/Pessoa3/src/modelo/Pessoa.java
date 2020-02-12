package modelo;

public class Pessoa {

    public String nome;
    public String email;
    public String telefone;

    // construtor vazio
    public Pessoa(){};
    
    // construtor com parâmetros
    public Pessoa(String n, String e, String t) {
        nome = n;
        email = e;
        telefone = t;
    }
    
}
