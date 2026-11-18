import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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
                    break;
                case 5:
                    imprimirQRCode();
                    break;
                case 6:
                    imprimirCodigosBarras();
                    break;
                case 7:
                    imprimirXMLSAT();
                    break;
                case 8:
                    imprimirXMLCancelamento();
                    break;
                case 9:
                    abrirGaveta();
                    break;
                case 10:
                    sinalSonoro();
                 
                    break;
                case 11:
                    extras();
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
            try{
                int resultado = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(tipo, modelo, conexao, parametro);

                if(resultado == 0){
                    conexaoAberta = true;
                    System.out.println("Conexao aberta com sucesso!");
                }
                else{
                    System.out.println("Erro ao abrir conexão. Codigo: "+resultado);
                }
            }
            catch(UnsatisfiedLinkError e){
                System.out.println("Erro ao carregar a DLL da impressora");
            }
    }
    public void fecharConexao(){
        if (!conexaoAberta) {
            System.out.println("A conexao ja esta fechada");
            return;
        }
        try {
            int resultado = ImpressoraDLL.INSTANCE.FechaConexaoImpressora();
    
            if (resultado == 0) {
                conexaoAberta = false;
                System.out.println("Conexao fechada com sucesso!");
            } else {
                System.out.println("Erro ao fechar conexao. Codigo: " + resultado);
            }
    
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Erro ao carregar a DLL da impressora.");
        }
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
        try {
            int resultado = ImpressoraDLL.INSTANCE.ImpressaoTexto(
                texto, 0, 0, 0
            );
    
            if (resultado == 0) {
                System.out.println("Erro ao imprimir texto. Codigo: " + resultado);
            } else {
                System.out.println("Texto enviado para a impressora com sucesso!");
            }
    
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Erro ao carregar a DLL da impressora.");
        }
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
        try {
            int resultado = ImpressoraDLL.INSTANCE.ImpressaoQRCode(
                dados, 3, 2
            );
    
            if (resultado == 0) {
                System.out.println("QR Code impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir QR Code. Codigo: " + resultado);
            }
    
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Erro ao carregar a DLL da impressora.");
        }
    }

    
    public void imprimirCodigosBarras() {
        if (!conexaoEstaAberta()) {
            return;
        }
    
        System.out.println("Digite os dados do codigo de barras:");
        String dados = sc.nextLine();
    
        if (dados.trim().isEmpty()) {
            System.out.println("Os dados não podem estar vazios");
            return;
        }
    
        try {
            int resultado = ImpressoraDLL.INSTANCE.ImpressaoCodigoBarras(
                8, dados, 100, 2, 2
            );
    
            if (resultado == 0) {
                System.out.println("Codigo de barras impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir codigo de barras. Codigo: " + resultado);
            }
    
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Erro ao carregar a DLL da impressora.");
        }
    }
    

    public void imprimirXMLSAT() {
        if (!conexaoEstaAberta()) {
            return;
        }
    
        System.out.println("Digite o caminho do arquivo XML SAT:");
        String caminho = sc.nextLine().trim();
    
        File arquivo = new File(caminho);
    
        if (!arquivo.exists() || !arquivo.isFile()) {
            System.out.println("Arquivo XML nao encontrado.");
            return;
        }
    
        try {
            int resultado = ImpressoraDLL.INSTANCE.ImprimeXMLSAT(
                "path=" + caminho, 0
            );
    
            if (resultado == 0) {
                System.out.println("XML SAT impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir XML SAT. Codigo: " + resultado);
            }
    
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Erro ao carregar a DLL da impressora.");
        }
    }

   public void imprimirXMLCancelamento() {
    if (!conexaoEstaAberta()) {
        return;
    }

    System.out.println("Digite o caminho do arquivo XML SAT de cancelamento:");
    String caminho = sc.nextLine().trim();

    File arquivo = new File(caminho);

    if (!arquivo.exists() || !arquivo.isFile()) {
        System.out.println("Arquivo XML nao encontrado.");
        return;
    }

    try {
        String xml = new String(
            Files.readAllBytes(arquivo.toPath()),
            StandardCharsets.UTF_8
        );

        String assQRCode =
            "Q5DLkpdRijIRGY6YSSNsTWK1TztHL1vD0V1Jc4spo/CEUqICEb9SFy82ym8EhBRZjbh3btsZhF+sjHqEMR159i4agru9x6KsepK/q0" +
            "E2e5xlU5cv3m1woYfgHyOkWDNcSdMsS6bBh2Bpq6s89yJ9Q6qh/J8YHi306ce9Tqb/drKvN2XdE5noRSS32TAWuaQEVd7u+TrvXlOQ" +
            "sE3fHR1D5f1saUwQLPSdIv01NF6Ny7jZwjCwv1uNDgGZONJdlTJ6p0ccqnZvuE70aHOI09elpjEO6Cd+orI7XHHrFCwhFhAcbalc+Z" +
            "fO5b/+vkyAHS6CYVFCDtYR9Hi5qgdk31v23w==";

        int resultado = ImpressoraDLL.INSTANCE.ImprimeXMLCancelamentoSAT(
            xml, assQRCode, 0
        );

        if (resultado == 0) {
            System.out.println("XML de cancelamento impresso com sucesso!");
        } else {
            System.out.println("Erro ao imprimir XML de cancelamento. Codigo: " + resultado);
        }

    } catch (IOException e) {
        System.out.println("Erro ao ler o arquivo XML.");
    } catch (UnsatisfiedLinkError e) {
        System.out.println("Erro ao carregar a DLL da impressora.");
    }
}

public void abrirGaveta() {
    if (!conexaoEstaAberta()) {
        return;
    }

    try {
        int resultado = ImpressoraDLL.INSTANCE.AbreGaveta(
            0, 1, 5
        );

        if (resultado == 0) {
            System.out.println("Gaveta aberta com sucesso!");
        } else {
            System.out.println("Erro ao abrir gaveta. Codigo: " + resultado);
        }

    } catch (UnsatisfiedLinkError e) {
        System.out.println("Erro ao carregar a DLL da impressora.");
    }
}

public void sinalSonoro() {
    if (!conexaoEstaAberta()) {
        return;
    }

    try {
        int resultado = ImpressoraDLL.INSTANCE.SinalSonoro(
            2, 50, 5
        );

        if (resultado == 0) {
            System.out.println("Sinal sonoro executado com sucesso!");
        } else {
            System.out.println("Erro ao executar sinal sonoro. Codigo: " + resultado);
        }

    } catch (UnsatisfiedLinkError e) {
        System.out.println("Erro ao carregar a DLL da impressora.");
    }
}
public void extras() {
    if (!conexaoEstaAberta()) {
        return;
    }

    System.out.println("---- EXTRAS ----");
    System.out.println("1 - Avancar papel");
    System.out.println("2 - Consultar papel");

    int op = lerInteiro("Escolha uma opcao");

    switch (op) {
        case 1:
            try {
                int resultado = ImpressoraDLL.INSTANCE.AvancaPapel(5);

                if (resultado == 0) {
                    System.out.println("Papel avancado com sucesso!");
                } else {
                    System.out.println("Erro ao avancar papel. Codigo: " + resultado);
                }

            } catch (UnsatisfiedLinkError e) {
                System.out.println("Erro ao carregar a DLL da impressora.");
            }
            break;

        case 2:
            try {
                int resultado = ImpressoraDLL.INSTANCE.StatusImpressora(3);

                if (resultado == 5) {
                    System.out.println("A impressora possui papel.");
                } else if (resultado == 6) {
                    System.out.println("O papel esta acabando.");
                } else if (resultado == 7) {
                    System.out.println("A impressora esta sem papel.");
                } else {
                    System.out.println("Status retornado: " + resultado);
                }

            } catch (UnsatisfiedLinkError e) {
                System.out.println("Erro ao carregar a DLL da impressora.");
            }
            break;

        default:
            System.out.println("Opcao invalida!");
            break;
    }
}
}