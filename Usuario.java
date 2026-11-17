import java.util.Scanner;
import java.util.InputMismatchException;
public class Usuario{
        String usuarioCadastrado = ""; 
        String senhaCadastrada = "";
        int login = 2;
        boolean logado = false;
        boolean cadastrado = false;

        public void fazerLogin(){
            if(cadastrado == true){ 
            try{
                String usuario1;
                String senha1;
                Scanner sc = new Scanner(System.in);
                System.out.print("Digite o usuário: ");
                usuario1 = sc.nextLine();
                System.out.print("Digite a senha: ");
                senha1 = sc.nextLine();

                if(!usuario1.equals(usuarioCadastrado) || !senha1.equals(senhaCadastrada)){
                    for (login = 2; login > 0; login--){
                        System.out.println("Erro, numero de tentativas restantes: " + login);
                        System.out.print("Digite o usuário: ");
                        usuario1 = sc.nextLine();
                        System.out.print("Digite a senha: ");
                        senha1 = sc.nextLine();

                        if(usuario1.equals(usuarioCadastrado) && senha1.equals(senhaCadastrada)){
                            System.out.println("");
                            System.out.println("Bem vindo de volta "+usuarioCadastrado+"!");
                            System.out.println("");
                            logado = true;
                            break;
                        }
                    }
                }else{
                    System.out.println("");
                    System.out.println("Bem vindo de volta "+usuarioCadastrado+"!");
                    System.out.println("");
                    logado = true;
                }
            }catch(InputMismatchException e) {
                System.out.println("");
                System.out.println("Erro de digitação.");
                System.out.println("");
            }
        }else{
            System.out.println("");
            System.out.println("Erro, sem cadastro");
            System.out.println("");
        }
    }
}