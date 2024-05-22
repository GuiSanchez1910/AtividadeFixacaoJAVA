package model;

public class Pintura extends Obra{

    private String tipoPintura;

    public String getTipoPintura() {
        return tipoPintura;
    }

    public void setTipoPintura(String tipoPintura) {
        this.tipoPintura = tipoPintura;
    }

    public Pintura(String título, String artista, int ano, String tipo, String localizacao, String tipoPintura) {
        super(título, artista, ano, tipo, localizacao);
        this.tipoPintura = tipoPintura;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo de pintura: ";
    }
}
