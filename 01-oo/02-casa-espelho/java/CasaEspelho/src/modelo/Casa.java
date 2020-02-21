package modelo;

public class Casa {

    public int quartos;
    public String cor;
    public Espelho esp;

    @Override
    public String toString() {
        String s = "Casa de " + quartos + " quartos, " + cor;
        if (esp != null) {
            s += ", com espelho de " + esp.altura + " por " + esp.largura
                    + " (centímetros)";
        }
        return s;
    }
}