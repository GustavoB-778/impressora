import java.util.Scanner;
import java.util.InputMismatchException;
public class Cadastro{
    public void fazerCadastro(Usuario user){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Crie o usuário: ");
            user.usuarioCadastrado = sc.nextLine();
            System.out.print("Crie a senha: ");
            user.senhaCadastrada = sc.nextLine();
            System.out.println("");
            System.out.println("Cadastro realizado.");
            System.out.println("");
            user.cadastrado = true;
        }catch(InputMismatchException e){
            System.out.println("");
            System.out.println("Erro ao cadastrar.");
            System.out.println("");
        }
    }
}