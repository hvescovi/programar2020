package teste;

import modelo.Pessoa;

public class TestarPessoa {
    
    public static void main(String[] args) {
        // criar o objeto
        Pessoa p1 = new Pessoa();
        // informar valores
        p1.nome = "Joao da Silva";
        p1.email = "jsilva@gmail.com";
        p1.telefone = "47 9 9922 4242";
        // criar outro objeto de forma mais compacta
        Pessoa maria = new Pessoa("Maria Oliveira", 
                "moliva@gmail.com", "47 9 9090 1201");
        // exibir os dados das pessoas
        System.out.println(p1.nome + ", " + p1.email
                + ", " + p1.telefone);
        System.out.println(maria.nome + ", " + maria.email
                + ", " + maria.telefone);
    }
}
