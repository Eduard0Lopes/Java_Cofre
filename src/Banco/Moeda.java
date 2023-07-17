package Banco;

public abstract class Moeda {
    protected double valor; // Valor da moeda
    protected String pais; // País da moeda

    // Construtor da classe Moeda
    public Moeda(double valor, String pais) {
        this.valor = valor;
        this.pais = pais;
    }

    // Método abstrato para obter o valor em Reais da moeda
    public abstract double getValorEmReais();

    @Override
    public String toString() {
        return pais + ": " + valor;
    }
}
