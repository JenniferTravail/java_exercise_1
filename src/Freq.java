import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Freq implements Command{

    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scan) {
        while(!scan.hasNextLine()){
            scan = new Scanner(System.in);
        }
        String path = scan.nextLine();
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
            System.err.println("Unreadable file: "+ e);
        }
        return false;
    }

}