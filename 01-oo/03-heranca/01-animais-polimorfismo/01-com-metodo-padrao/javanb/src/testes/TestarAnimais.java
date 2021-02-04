package testes;

import modelo.Boi;
import modelo.Cavalo;

public class TestarAnimais {
    
    public static void main(String[] args) {
        // boi nascido na data atual
        Boi b = new Boi();
        // cavalo nascido em 26/02/2020
        Cavalo c = new Cavalo(21, 02, 2020);
        // exibição dos dados
        System.out.println("boi nascido em: " + b.dtNasc + ", "+ 
                "cavalo nascido em: "+ c.dtNasc);
        System.out.print("o boi vai comer: ");
        b.comer();
        System.out.print("\no cavalo vai comer: ");
        c.comer();      
        System.out.println("\nidade do boi: "+b.idadeEmMeses());
    }
}