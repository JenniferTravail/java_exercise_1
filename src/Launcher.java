import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Launcher{
    public static void main(String[] args){
        System.out.println("Bienvenue");

        List<Command> listOfCommands = new ArrayList<Command>();
        listOfCommands.add(new Fibo());
        listOfCommands.add(new Freq());
        listOfCommands.add(new Quit());
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        String commande;

        while(running){
            commande = sc.nextLine();
            for (Command nameOfCommands : listOfCommands) {
                if (commande.contains(nameOfCommands.name())){
                    Scanner commandScanner = new Scanner(System.in);
                    if (false != nameOfCommands.run(commandScanner)){
                        running = false;
                    }
                }
            }
        }
        sc.close();
    }
}