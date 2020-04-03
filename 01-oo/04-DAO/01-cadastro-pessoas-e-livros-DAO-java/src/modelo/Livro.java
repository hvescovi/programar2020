package modelo;

public class Livro {
    
    private int id;
    private String titulo;
    private String autores;
    private String ano;
    private String editora;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String t) { titulo = t; }
    public String getAutores() { return autores; }
    public void setAutores(String a) { autores = a; }
    public String getAno() { return ano; }
    public void setAno(String a) { ano = a; }
    public String getEditora() { return editora; }
    public void setEditora(String e) {editora = e; }
    // construtor com parâmetros
    public Livro(String tit, String aut, String an, String ed){
        titulo = tit; autores = aut; ano = an; editora = ed;
    }
    // expressão do livro em string
    @Override
    public String toString() {
        return id + ")" + titulo + ", " + autores + ", " + ano + ", " + editora;
    }
}