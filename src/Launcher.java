import java.nio.file.Path;
import java.io.File;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Launcher{
    private static int fibonnaci(int nb){
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
        Scanner sc;
        while(true){
            sc = new Scanner(System.in);
            String texte = sc.nextLine();
            if (texte.contains("quit")){
               break;
            }
            else if (texte.contains("fibo")){
                System.out.println("Calcule de la suite de Fibonnaci, veuillez donner un nombre:");
                int nombre;
                while(!sc.hasNextInt()){
                    sc = new Scanner(System.in);
                }
                nombre = sc.nextInt();
                String consomme = sc.nextLine();
                int resultatFibo = fibonnaci(nombre);
                System.out.println("Le resultat de la suite de Fibonnaci de " + nombre + " est: " + resultatFibo);
            }
            else if (texte.contains("freq")){

                String path;
                System.out.println("Veuillez donnez le PATH du fichier complète du fichier");
                while(!sc.hasNextLine()){
                    sc = new Scanner(System.in);
                }
                path = sc.nextLine();
                Path pathFichier = Paths.get(path);

                try
                {
                    String content = Files.readString(pathFichier);

                    content = content.replaceAll("[?,.;/:!]", "");

                    String[] splitText = content.toLowerCase().split(" ");
                    // Create a stream so I can do some grouping counting
                    Stream <String> streamText = Arrays.stream(splitText);

                    Map<String, Long> result = streamText.collect(
                        Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
                    /**
                     * entrySet -> To enter in a Map
                     * map -> To have the value of the key
                     */

                    List<String> streamMap =
                        result.
                        entrySet().
                        stream().
                        sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                        limit(3).
                        map(Map.Entry::getKey).
                        collect(Collectors.toList());

                    streamMap.forEach((String word) ->{
                        System.out.print(word + " ");
                    });
                    System.out.print("\n");
                }
                catch (IOException e)
                {
                  e.printStackTrace();
                }
            }
            else{
                System.out.println("Unknown command");
            }
        }
        sc.close();
    }
}