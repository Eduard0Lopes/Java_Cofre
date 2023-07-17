package Banco;

class Dolar extends Moeda {
    private double taxaCambio;

    public Dolar(double valor, String pais, double taxaCambio) {
        super(valor, pais);
        this.taxaCambio = taxaCambio;
    }

    @Override
    public double getValorEmReais() {
        return valor * taxaCambio;
    }
}