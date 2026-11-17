import com.sun.jna.Library;
import com.sun.jna.Native;

import java.nio.file.Paths;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Menu menuPrincipal = new Menu();
        menuPrincipal.inicio();
    }
}
