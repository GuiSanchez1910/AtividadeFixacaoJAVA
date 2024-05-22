package model;

public abstract class Obra {
    
    public String titulo;
    private String artista;
    public int ano;
    private String tipo;
    private String localizacao;
    
    public String getTítulo() {
        return titulo;
    }
    public void setTítulo(String título) {
        this.titulo = título;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    
    public Obra(String título, String artista, int ano, String tipo, String localizacao) {
        this.titulo = título;
        this.artista = artista;
        this.ano = ano;
        this.tipo = tipo;
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\nArtista: " + artista + "\nAno: " + ano + "\nTipo: " + tipo + "\nLocalização: " + localizacao + "\n";
    }
}
