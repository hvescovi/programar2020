package basico;

class Pessoa_DadosCadastrais {

    public static void main(String args[]) {
        String nome = "Maria Teresa da Silva";
        String dtnasc = "28/10/1976";
        String rg = "123456";
        System.out.println("Dados da pessoa: ");
        System.out.printf("%s, nascida em %s, RG: %s", nome, dtnasc, rg);
    }
}