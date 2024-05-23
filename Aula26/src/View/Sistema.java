package View;
import java.io.IOException;

import Controller.GerenciarObras;
import model.*;

public class Sistema {

    public static void executar() {

        int op;
        do {
            Sistema.exibirMenu();
            System.out.println("Selecione: ");
            op = Console.lerInt();
            verificarOpcao(op);
        } while (op != 0);

    }

    private static void exibirMenu() {
        System.out.println("\nGERENCIADOR DE OBRAS\n");
        System.out.println("1) Cadastrar obra");
        System.out.println("2) Buscar Obra");
        System.out.println("3) Excluir obra");
        System.out.println("4) Listar todas as obras");
        System.out.println("5) Atualizar dados da obra");
        System.out.println("0) Sair");
    }

    private static void verificarOpcao(int op) {

        switch (op) {
            case 1:
                cadastrar();
                break;

            case 2:
                buscar();
                break;
            
            case 3:
                excluir();
                break;
            
            case 4:
                listarTodas();;
                break;

            case 5:
                // atualizar();
                break;
            default:
                break;
        }
    }


    private static void cadastrar() {
        
        String titulo;
        String artista;
        int ano;
        String tipo;
        String localizacao;
        
        System.out.println("\nCadastrar obra\n");

        System.out.println("Titulo: ");
        titulo = Console.lerString();
        System.out.println("Artista: ");
        artista = Console.lerString();
        System.out.println("Ano: ");
        ano = Console.lerInt();
        System.out.println("Tipo: ");
        tipo = Console.lerString();
        System.out.println("Localizacao: ");
        localizacao = Console.lerString();

        Obra obra = new Obra(ano, artista, titulo, tipo, localizacao);

        try {
            GerenciarObras.cadastrarObra(obra);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void buscar () {

        String titulo;

        System.out.println("\nProcurar Obra\n");
        System.out.println("Digite o titulo");
        titulo = Console.lerString();

        try {
            Obra obra = GerenciarObras.buscarObra(titulo);
            System.out.println("Obra encontrada: " + obra);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }

    // private static void atualizar() {
    //     System.out.println("Digite o titulo da obra: ");
    //     String titulo = Console.lerString();

    //     GerenciarObras.atualizarObra(titulo);
    // }

    public static void excluir() {

        System.out.println("\nExcluir obra\n");

        System.out.println("Digite o titulo da obra que deseja excluir");
        String titulo = Console.lerString();

        try {
            GerenciarObras.excluirObra(titulo);
            System.out.println("\nObra excluída\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listarTodas() {
        System.out.println("\nObras cadastradas\n");

        try{
            for (Obra tempObra : GerenciarObras.listarTodasObras()) {
                System.out.println(tempObra);
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
