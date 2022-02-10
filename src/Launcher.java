import java.util.Scanner;

public class Launcher{
    public static void main(String[] args){
        System.out.println("Bienvenue");
        while(true){
            Scanner sc = new Scanner(System.in);
            String texte = sc.nextLine();
            if (texte.contains("quit")){
               break;
            }
            else{
                System.out.println("Unknown command");
            }
        }
    }
}