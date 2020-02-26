package teste;

import modelo.Animal;
import modelo.Gato;

public class TestarAnimais {

    public static void main(String[] args) {
        Animal a = new Animal();
        a.comer();
        Gato g = new Gato();
        g.comer();
    }    
}