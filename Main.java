import com.sun.jna.Library;
import com.sun.jna.Native;

import java.lang.classfile.instruction.SwitchCase;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
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
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("Número invalido.");
                    break;
            }
        }
    }
}
class Usuario{
        String usuarioCadastrado = ""; 
        String senhaCadastrada = "";
        int login = 2;
        boolean logado = false;
        boolean cadastrado = false;

        public void fazerLogin(){
    if(cadastrado == true){

        Scanner sc = new Scanner(System.in);

        for(int login = 3; login > 0; login--){

            System.out.print("Digite o usuário: ");
            String usuario1 = sc.nextLine();

            System.out.print("Digite a senha: ");
            String senha1 = sc.nextLine();

            if(usuario1.equals(usuarioCadastrado) &&
               senha1.equals(senhaCadastrada)){

                System.out.println("Bem vindo de volta " + usuarioCadastrado + "!");
                logado = true;
                return;

            }else{
                System.out.println("Dados incorretos.");
                System.out.println("Tentativas restantes: " + (login - 1));
            }
        }

        System.out.println("Número máximo de tentativas atingido.");
        System.exit(0);

    }else{
        System.out.println("Erro, sem cadastro");
    }
}
}
class Cadastro{
    public void fazerCadastro(Usuario user){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Crie o usuário: ");
            user.usuarioCadastrado = sc.nextLine();
            System.out.print("Crie a senha: ");
            user.senhaCadastrada = sc.nextLine();
            System.out.println("Cadastro realizado.");
            user.cadastrado = true;
        }catch(InputMismatchException e){
            System.out.println("Erro ao cadastrar.");
        }
    }
}

class Impressora{
    int tipo = 1;
    String modelo = "i9";
    String conexao = "USB";
    int parametro = 0;

    boolean conexaoAberta = false;

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
                    AbrirConexao();
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
                    System.out.println("Retornando a pagina inicial...");
                    break;
                default:
                    break;
            }
        }else{
            System.out.println("Erro, login não efetuado.");
        }
    }

    public void AbrirConexao(){
        try{
            int retorno = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(
                tipo,modelo,conexao,parametro
            );
            if(retorno == 0){
                conexaoAberta = true;
                System.out.println("Conexao Aberta com Sucesso!");
            }
            else{
                conexaoAberta = false;
                System.out.println("Perda na Conexao:"+retorno);
            }
        }
         catch(UnsatisfiedLinkError e){
                System.out.println("Erro a carregar o DLL"+ e.getMessage());
            }
    }
}