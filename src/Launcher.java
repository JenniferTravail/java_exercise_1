import java.util.Scanner;

public class Launcher{
    public static int fibonnaci(int nb){
        if (nb == 0){
            return 0;
        }
        if (nb == 1){
            return 1;
        }
        return fibonnaci(nb - 1) + fibonnaci(nb - 2);
    }
    public static void main(String[] args){
        System.out.println("Bienvenue");
        while(true){
            Scanner sc = new Scanner(System.in);
            String texte = sc.nextLine();
            if (texte.contains("quit")){
               break;
            }
            else if (texte.contains("fibo")){
                System.out.println("Calcule de la suite de Fibonnaci, veuillez donner un nombre:");
                int nombre;
                Scanner nb = new Scanner(System.in);
                while(nb.hasNextInt()){
                    nombre = nb.nextInt();
                    String consomme = nb.nextLine();
                    int resultatFibo = fibonnaci(nombre);
                    System.out.println("Le resultat de la suite de Fibonnaci de " + nombre + " est: " + resultatFibo)
                }
            }
            else{
                System.out.println("Unknown command");
            }
        }
    }
}