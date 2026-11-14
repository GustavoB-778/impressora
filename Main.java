import com.sun.jna.Library;
import com.sun.jna.Native;

import java.nio.file.Paths;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Usuario user = new Usuario();
        user.fazerLogin();
    }
}
class Usuario{
        String usuario;
        String senha;
        int login=2;
        public void fazerLogin(){
            try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Digite o usuário: ");
            usuario = sc.nextLine();
            System.out.print("Digite a senha: ");
            senha = sc.nextLine();
            if(!usuario.equals("NomeLegal") || !senha.equals("SenhaLegal")){
                for(login=2;login>0;login--){
                System.out.println("Erro, numero de tentativas restantes: "+login);
                System.out.print("Digite o usuário: ");
                usuario = sc.nextLine();
                System.out.print("Digite a senha: ");
                senha = sc.nextLine();
            }
            }else{
                System.out.print("Bem vindo de volta "+usuario+"!");
            }
        }catch(InputMismatchException e){
            for(login=2;login>0;login--){
                System.out.println("Erro, numero de tentativas restantes: "+login);
                Scanner sc = new Scanner(System.in);
                System.out.print("Digite o usuário: ");
                usuario = sc.nextLine();
                System.out.print("Digite a senha: ");
                senha = sc.nextLine();
            }
        }
        }
        
}

class Impressora{

}
