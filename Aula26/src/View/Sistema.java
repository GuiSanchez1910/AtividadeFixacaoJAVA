package View;
import Controller.GerenciarObras;
import model.*;

public class Sistema {

    public static void executar() {

        int op;
        do {
            Sistema.exibirMenu();
            op = Console.lerInt();
            verificarOpcao(op);
        } while (op != 0);

    }

    private static void exibirMenu() {
        System.out.println("1) Cadastrar obra");
        System.out.println("2) Buscar Obra");
        System.out.println("3) Excluir obra");
        System.out.println("4) Listar todas as obras");
        System.out.println("5) Atualizar dados da obra");
        System.out.print("Selecione: ");
    }

    private static void verificarOpcao(int op) {

        switch (op) {
            case 1:
                cadastrarObra();
                break;

            case 2:
                buscar();
                break;
            
            case 3:
                excluir();
                break;
            
            case 4:
                GerenciarObras.listarTodasObras();
                break;

            case 5:
                atualizar();
                break;
            default:
                break;
        }
    }


    private static void cadastrarObra() {
        
        String titulo;
        String artista;
        int ano;
        String tipo;
        String localizacao;
        
        System.out.print("Titulo: ");
        titulo = Console.lerString();
        System.out.print("Artista: ");
        artista = Console.lerString();
        System.out.print("Ano: ");
        ano = Console.lerInt();
        System.out.print("Tipo: ");
        tipo = Console.lerString();
        System.out.print("Localizacao: ");
        localizacao = Console.lerString();

        Obra obra = new Obra(titulo, artista, ano, tipo, localizacao);

        GerenciarObras.cadastrarObra(obra);
    }

    public static void buscar () {

        System.out.print("Digite o titulo da obra: ");
        String titulo = Console.lerString();

        GerenciarObras.buscarObra(titulo);
       
    }

    private static void atualizar() {
        System.out.println("Digite o titulo da obra: ");
        String titulo = Console.lerString();

        GerenciarObras.atualizarObra(titulo);
    }

    public static void excluir() {

        System.out.print("Digite o titulo da obra que deseja excluir: ");
        String titulo = Console.lerString();

        GerenciarObras.excluir(titulo);
    }

}
