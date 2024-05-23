package Controller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.*;

public abstract class GerenciarObras {

    private static final String ARQUIVO = "obras.txt";

    private static ArrayList<Obra> listaObra = new ArrayList<>();

    public static void cadastrarObra(Obra obra) throws IOException{
        try (FileWriter fw = new FileWriter(ARQUIVO, true); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(obra + "\n");
            listaObra.add(obra);
        }
    }

    public static ArrayList<Obra> listarTodasObras() throws IOException, Exception {

        ArrayList<Obra> listaObras = new ArrayList<>();

            for (Obra tempObra : listaObra) {
                System.out.println(tempObra);
                
            }

        if(listaObra.isEmpty()){
            System.out.println("Não há obras cadastradas");
            
        }
    
        try (FileReader fr = new FileReader(ARQUIVO);
             BufferedReader br = new BufferedReader(fr)) {

                String linha;
                while ((linha = br.readLine()) != null) {
                    
                    Obra obra = Obra.fromString(linha);
                    listaObras.add(obra);
                }
        } 

        if (listaObras.isEmpty()) {
            throw new Exception("\nNão há obras cadastradas");
        }

        return listaObras;
    }

    public static Obra buscarObra(String titulo) throws Exception{

        for (Obra tempObra : listaObra) {
            if(tempObra.getTitulo() == titulo) {
                System.out.println(tempObra);
            }
        }

        ArrayList<Obra> listaObras = listarTodasObras();

        for (Obra temp : listaObras) {

            if(temp.getTitulo().equals(titulo)) {
                return temp;
            }
        }
        throw new Exception("Obra não encontrada");
    }

    public static void excluirObra(String titulo) throws Exception{

        for (Obra obra : listaObra) {
            if(obra.getTitulo() == titulo) {
                listaObra.remove(obra);
            }
            
        }

        ArrayList<Obra> listaObras = listarTodasObras();

        boolean encontrou = false;
        for (Obra temp : listaObras) {

            if(temp.getTitulo() == titulo) {
                listaObras.remove(temp);
                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            throw new Exception("\nObra não localizada");
        }

        try (FileWriter fw = new FileWriter(ARQUIVO);
        BufferedWriter bw = new BufferedWriter(fw)) {

            for (Obra o : listaObras) {

                bw.write(o + "\n");
            }
        }
    }
}
