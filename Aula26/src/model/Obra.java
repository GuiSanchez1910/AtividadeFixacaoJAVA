package model;

public class Obra {
    
    public String titulo;
    private String artista;
    public int ano;
    private String tipo;
    private String localizacao;
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
    
    public Obra(int ano, String artista, String titulo, String tipo, String localizacao) {
        this.titulo = titulo;
        this.artista = artista;
        this.ano = ano;
        this.tipo = tipo;
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return titulo + ", " + artista + ", " + ano + ", " + tipo + ", " + localizacao;
    }

    public static Obra fromString(String linha) {

        String[] dadosObra = linha.split(", ");

        return new Obra(Integer.parseInt(dadosObra[0]), 
                        dadosObra[1], 
                        dadosObra[2], dadosObra[3], dadosObra[4]);

    }
}
