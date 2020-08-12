package basico;

class Pessoa {
    String nome;
    String dtnasc;
    String rg;
    public static void main(String args[]) {
        Pessoa p = new Pessoa();
        p.nome = "Maria Teresa da Silva";
        p.dtnasc = "28/10/1976";
        p.rg = "123456";
        System.out.println("Dados da pessoa: ");
        System.out.printf("%s, nascida em %s, RG: %s", 
          p.nome, p.dtnasc, p.rg);
    }
}