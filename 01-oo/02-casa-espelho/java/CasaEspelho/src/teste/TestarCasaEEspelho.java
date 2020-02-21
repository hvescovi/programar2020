package teste;

import modelo.Casa;
import modelo.Espelho;

public class TestarCasaEEspelho {

    public static void main(String[] args) {
        Espelho e = new Espelho();
        e.altura = 20;
        e.largura = 30;
        Casa c = new Casa();
        c.quartos = 3;
        c.cor = "azul";
        c.esp = e;
        System.out.println(c);
    }
}