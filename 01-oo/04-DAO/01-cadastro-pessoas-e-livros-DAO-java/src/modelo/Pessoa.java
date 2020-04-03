package modelo;

import java.util.ArrayList;

public class Pessoa {
    
    // dados da pessoa
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    // livros que a pessoa possui
    ArrayList<Livro> livros = new ArrayList();

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String e) {endereco = e; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String t) {telefone = t; }
    // construtor com parâmetros
    public Pessoa(String n, String e, String t) {
        nome = n; endereco = e; telefone = t;}
    
    @Override
    public String toString() {
        // dados básicos
        String s = id + ") " + nome + ", mora em: " + endereco + ", (" + telefone + ")";
        s += ", possui livros: ";
        // percorrer os livros que a pessoa possui
        for (Livro livro: this.livros) {
            // adiciona o livro (o método toString de Livro é acionado)
            s += "\n "+ livro;
        }
        return s;
    }    
    // manipulação de livros da pessoa
    public ArrayList<Livro> getLivros(){ return livros; }
    public void registrarPosseLivro(Livro livro) { livros.add(livro); }
}