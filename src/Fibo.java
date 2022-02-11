import java.util.Scanner;

public class Fibo implements Command{

    private static int fibonnaci(int nb){
        if (nb == 0){
            return 0;
        }
        if (nb == 1){
            return 1;
        }
        return fibonnaci(nb - 1) + fibonnaci(nb - 2);
    }

    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        while(!scanner.hasNextInt()){
            scanner = new Scanner(System.in);
        }
        System.out.println("Calcule de la suite de Fibonnaci, veuillez donner un nombre:");
        int nombre;
        nombre = scanner.nextInt();
        String consomme = scanner.nextLine();
        int resultatFibo = fibonnaci(nombre);
        System.out.println("Le resultat de la suite de Fibonnaci de " + nombre + " est: " + resultatFibo);
        return false;
    }

}
