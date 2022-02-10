import java.util.Scanner;

public class Launcher{
    public static void main(String[] args){
        System.out.println("Bienvenue");
        Scanner sc = new Scanner(System.in);
        String texte = sc.nextLine();
        if (texte != "quit"){
            System.out.println("Unknown command");
        }
    }
}