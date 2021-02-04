package modelo;

import util.MyDate;

public class Animal {

    public MyDate dtNasc;
    
    public void comer() {
        System.out.print("mastigando");
    }
    public Animal() {
        // animal nascido na data atual (construtor padrão)
        this.dtNasc = new MyDate();
        System.out.println("construindo animal na data atual");
    }
    public Animal(int dia, int mes, int ano) {
        // construindo animal com data de nascimento
        this.dtNasc = new MyDate(dia, mes, ano);
        System.out.println("construindo animal em data especificada");
    }
}