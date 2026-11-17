import java.util.Scanner;
public class Impressora{

     int tipo = 1;
     String modelo = "i9";
     String conexao = "USB";
     int parametro = 0;

    boolean conexaoAberta = false;
    
    private final Scanner sc = new Scanner(System.in);

    int lerInteiro(String mensagem){
      while (true) {
        System.out.println(mensagem);
        try{
            return Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException e){
            System.out.println("Digite apenas Numeros!");
        }
      }
     }
    public void ImpressoraOpcoes(Usuario user){
        if(!user.logado){
            System.out.println("");
            System.out.println("Erro!, o login n foi efutado.");
            System.out.println("");
            return ;
        }

        int opImpressora = 0;
        while(opImpressora != 12){
            System.out.println("========IMPRESSORA========");
            System.out.println("1-Configurar conexão");
            System.out.println("2-Abrir conexão");
            System.out.println("3-Fechar conexão");
            System.out.println("4-Imprimir texto");
            System.out.println("5-Imprimir QR Code");
            System.out.println("6-Imprimir código de barras");
            System.out.println("7-Imprimir XML SAT");
            System.out.println("8-Imprimir XML de cancelamento SAT");
            System.out.println("9-Abrir gaveta");
            System.out.println("10-Sinal sonoro");
            System.out.println("11-Extra (avançar papel / status)");
            System.out.println("12-Retornar ao menu");

            opImpressora = lerInteiro("Digite o numero correspondente: ");
            

            switch (opImpressora){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                System.out.println("Ainda nao implementado.");

                case 12:
                    System.out.println("");
                    System.out.println("Retornando a pagina inicial ...");
                    System.out.println("");
                    break;
                    default:
                        System.out.println("Numero Invalido");
                        break;
            }
        }
    }
    private boolean conexaoEstaAberta(){
        if (!conexaoAberta) {
            System.out.println("Conexão fechada. Abra a conexão antes.");
        }
        return conexaoAberta;
    }
}