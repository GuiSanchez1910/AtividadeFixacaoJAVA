package Controller;
import java.util.ArrayList;
import View.*;
import model.*;

public class GerenciarObras {
    
    private static ArrayList<Obra> listaObras = new ArrayList<>();

    public static void cadastrarObra(Obra o) { 
            listaObras.add(o);
    }

    public static void buscarObra(String titulo) {

        for (Obra temp : listaObras) {

            if(temp.titulo.equals(titulo)) {
                System.out.println(temp);
            }
            
        }
    }

    public static void excluir(String titulo) {

        for (Obra temp : listaObras) {
            if(temp.getTítulo().equals(titulo))
                listaObras.remove(temp);
            }
        }

    public static ArrayList<Obra> getObras(){
        return listaObras;
    }

    public static void atualizarObra(String titulo) {

        for (Obra temp : GerenciarObras.getObras()) {
            
            if(temp.titulo.equals(titulo)) {
                System.out.println("ATUALIZAR DADOS");
                System.out.print("Titulo: ");
                temp.setTítulo(Console.lerString());
                System.out.print("Artista: ");
                temp.setArtista(Console.lerString());
                System.out.print("Ano: ");
                temp.setAno(Console.lerInt());
                System.out.print("Tipo: ");
                temp.setTipo(Console.lerString());
                System.out.print("Localizacao: ");
                temp.setLocalizacao(Console.lerString());
            }
        }
    }

    public static void listarTodasObras() {

        for (Obra temp : GerenciarObras.getObras()) {

            System.out.println(temp);
        }
    }
}
