import java.util.Scanner;
public class Impressora{

    private int tipo = 1;
    private String modelo = "i9";
    private String conexao = "USB";
    private int parametro = 0;

    private boolean conexaoAberta = false;
    public void ImpressoraOpcoes(Usuario user){
        Scanner sc = new Scanner(System.in);
        int opcaoImpressora;
        if(user.logado==true){
            System.out.println("========IMPRESSORA========");
            System.out.println("1-");
            System.out.println("2-");
            System.out.println("3-");
            System.out.println("4-");
            System.out.println("5-");
            System.out.println("6-");
            System.out.println("7-");
            System.out.println("8-");
            System.out.println("9-");
            System.out.println("10-");
            System.out.println("11-");
            System.out.println("12-Extra");
            System.out.println("13-Retornar ao menu");
            System.out.print("Digite o numero correspondente: ");
            opcaoImpressora=sc.nextInt();

            switch (opcaoImpressora) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    System.out.println("");
                    System.out.println("Retornando a pagina inicial...");
                    System.out.println("");
                    break;
                default:
                    break;
            }
        }else{
            System.out.println("");
            System.out.println("Erro, login não efetuado.");
            System.out.println("");
        }
    }
}