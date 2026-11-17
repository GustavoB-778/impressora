import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void inicio(){
        int opcao=0;
        Scanner sc = new Scanner(System.in);
        Usuario user = new Usuario();
        Cadastro cad = new Cadastro();
        Impressora imp = new Impressora();

        while(opcao!=4){
            System.out.println("========MENU========");
            System.out.println("1-Cadastro");
            System.out.println("2-Login");
            System.out.println("3-Impressora");
            System.out.println("4-Sair");

            try{
                System.out.print("Digite o numero correspondente: ");
                opcao=sc.nextInt();
                sc.nextLine();
            }catch(InputMismatchException e){
                System.out.println("Número invalido.");
                sc.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    cad.fazerCadastro(user);
                    break;
                case 2:
                    user.fazerLogin();
                    break;
                case 3:
                    imp.ImpressoraOpcoes(user);
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Saindo do programa...");
                    System.out.println("");
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("");
                    System.out.println("Número invalido.");
                    System.out.println("");
                    break;
            }
        }
    }
}