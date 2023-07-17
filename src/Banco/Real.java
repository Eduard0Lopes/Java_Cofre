package Banco;

public class Real extends Moeda {
    public Real(double valor, String pais) {
        super(valor, pais);
    }

    @Override
    public double getValorEmReais() {
        return valor;
    }
}
