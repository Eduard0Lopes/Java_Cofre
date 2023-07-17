package Banco;

class Euro extends Moeda {
    private double taxaCambio;

    public Euro(double valor, String pais, double taxaCambio) {
        super(valor, pais);
        this.taxaCambio = taxaCambio;
    }

    @Override
    public double getValorEmReais() {
        return valor * taxaCambio;
    }
}