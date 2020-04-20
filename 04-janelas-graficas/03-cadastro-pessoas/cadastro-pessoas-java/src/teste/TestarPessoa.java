package teste;

import modelo.Pessoa;

public class TestarPessoa {
    
    public static void main(String[] args) {
        // criar o objeto
        Pessoa p1 = new Pessoa();
        // informar valores
        p1.setNome("Joao da Silva");
        p1.setEmail("jsilva@gmail.com");
        p1.setTelefone("47 9 9922 4242");
        // criar outro objeto de forma mais direta
        Pessoa maria = new Pessoa("Maria Oliveira", 
                "moliva.com", "47 9 9090 1201");
        // exibir os dados das pessoas
        System.out.println(p1.getNome() + ", " + p1.getEmail()
                + ", " + p1.getTelefone());
        System.out.println(maria.getNome() + ", " + maria.getEmail()
                + ", " + maria.getTelefone());
    }
}