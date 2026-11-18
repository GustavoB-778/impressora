import java.util.Scanner;
import java.io.File;
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
                    configurarConexao();
                    break;
                case 2:
                    abrirConexao();
                    break;
                case 3:
                    fecharConexao();
                    break;
                case 4:
                    imprimirTexto();
                    System.out.println("Imprimir Texto");
                    break;
                case 5:
                    imprimirQRCode();
                    System.out.println("Imprimir o QR Code");
                    break;
                case 6:
                    imprimirCodigosBarras();
                    System.out.println("Imprimir o codigo de barra");
                    break;
                case 7:
                    imprimirXMLSAT();
                    System.out.println("Imprimir o XML SAT");
                    break;
                case 8:
                    imprimirXMLCancelamento();
                    System.out.println("Imprimir o XML de cancelamento SAT");
                    break;
                case 9:
                    abrirGaveta();
                    System.out.println("Abrir a Gaveta");
                    break;
                case 10:
                    sinalSonoro();
                    System.out.println("Sinal sonoro");
                    break;
                case 11:
                    extras();
                System.out.println("Ainda nao implementado.");
                break;

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
    boolean conexaoEstaAberta(){
        if (!conexaoAberta) {
            System.out.println("Conexão fechada. Abra a conexão antes.");
        }
        return conexaoAberta;
    }

    public void configurarConexao(){
        if (conexaoAberta) {
            System.out.println("Feche a conexão antes de reconfigurar");
            return;
        }

        System.out.println("---- Configurar conexao ----");
        System.out.println("Tipo: 1=USB, 2=Serial (RS232), 3=Rede (TCP/IP), 4=Bluetooth");

        int novoTipo;

        do{
            novoTipo = lerInteiro("Tipo(1 a 4):");
            if(novoTipo < 1 || novoTipo > 4){
                System.out.println("Tipo invalido, Escolha o Numero de 1 a 4");
            }
        }
        while(novoTipo < 1 || novoTipo > 4);
        tipo = novoTipo;

        System.out.println("Modelo (ex.: i8 ou i9);");
        modelo = sc.nextLine().trim();

        System.out.println("Conexao (USB, COM2 ou IP):");
        conexao = sc.nextLine().trim();

        System.out.println("Conexao configurada: tipo="+tipo+",modelo ="+modelo+",conexao="+conexao+",parametro="+parametro);
    }

    public void abrirConexao(){
        if (conexaoAberta) {
            System.out.println("A conexao ja esta aberta");
            return;
        }

        System.out.println("Conexao preparada para abertura");
        conexaoAberta = true;
    }
    public void fecharConexao(){
        if (!conexaoAberta) {
            System.out.println("A conexao ja esta fechada");
            return;
        }
        conexaoAberta = false;
        System.out.println("A conexao fechada com sucesso");
    }

    public void imprimirTexto(){
        if (!conexaoEstaAberta()) {
            return;
        }
        System.out.println("Digite o texto que deseja imprimir");
        String texto = sc.nextLine();

        if (texto.trim().isEmpty()) {
            System.out.println("O texto não pode estar vazio");
            return;
        }

        System.out.println("Texto preparado para impressão");
        System.out.println(texto);
    }

    public void imprimirQRCode(){
        if (!conexaoEstaAberta()) {
            return;
        }
        System.out.println("Digite o conteudo do QR Code:");
        String dados = sc.nextLine();

        if(dados.trim().isEmpty()){
            System.out.println("O conteudo não pode estar vazio");
            return;
        }

        System.out.println("QR Code preparado para impressão!");
        System.out.println("Conteudo "+dados);
    }

    public void imprimirCodigosBarras(){
        if (!conexaoEstaAberta()) {
            return;
        }
        System.out.println("Os dados do codigo de barras");
        String dados = sc.nextLine();

        if(dados.trim().isEmpty()){
            System.out.println("Os dados não pode estar vazio");
            return;
        }
        System.out.println("O Codigo de Barras está preparado para impressão!");
        System.out.println("Dados "+dados);
    }

    public void imprimirXMLSAT(){
        if (!conexaoEstaAberta()) {
            return;
        }

        System.out.println("Digite o caminho do arquivo XML SAT:");
        String caminho = sc.nextLine().trim();

        File arquivo = new File(caminho);

        if(!arquivo.exists() || !arquivo.isFile()){
            System.out.println("Arquivo XML não encontrado");
            return;
        }

        System.out.println("Arquivo XML encontado!:");
        System.out.println("Preparado para a impressão:"+ caminho);
    }

    public void imprimirXMLCancelamento(){
        if(!conexaoEstaAberta()){
            return;
        }
        System.out.println("Digite o caminho do arquivo XML SAT de cancelamento:");
        String caminho = sc.nextLine().trim();

        File arquivo = new File(caminho);

        if(!arquivo.exists() || !arquivo.isFile()){
            System.out.println("Arquivo XML não encontrado");
            return;
        }

        System.out.println("XML de cancelamento encontrado!");
        System.out.println("Preparado para impressão: " +caminho);
    }

    public void abrirGaveta(){
        if(!conexaoEstaAberta()){
            return;
        }

        System.out.println("Preparando o caminho da gaveta ...");

        System.out.println("Comando de abertura da gaveta preparando!");
    }

    public void sinalSonoro(){
        if(!conexaoEstaAberta()){
            return;
        }

        System.out.println("Preparando o sinal sonoro ...");

        System.out.println("Comando do sinal sonoro esta preparado!");
    }

    public void extras(){
        if(!conexaoEstaAberta()){
            return;
        }

        System.out.println("---- EXTRAS ----");
        System.out.println("1- Avançar Papel");
        System.out.println("2- Consultar Papel");

        int op = lerInteiro("Escolha uma opção");

        switch(op){
            case 1:
                System.out.println("Comando para avançar papel");
                break;

            case 2:
              System.out.println("Comando para consultar status");
              break;
            
              default:
                System.out.println("Opção invalida!");
                break;
        }
    }
}