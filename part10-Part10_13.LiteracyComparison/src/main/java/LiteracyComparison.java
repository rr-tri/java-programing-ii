
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LiteracyComparison {

    public static void main(String[] args) {
        List<Literacy> data = readFile("literacy.csv");
        Collections.sort(data);
       
        for (Literacy literacy : data) {
            System.out.println(literacy);
        }
    }

    public static List<Literacy> readFile(String file) {
        List<Literacy> lines = new ArrayList<>();
        try {
            Files.lines(Paths.get(file))
                    .map(l -> l.split(","))
                    .map(parts -> new Literacy(parts[3].trim(),parts[2].split(" ")[1],Integer.valueOf(parts[4]),Double.valueOf(parts[5])))
                    .forEach(line -> lines.add(line));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lines;
    }
}
