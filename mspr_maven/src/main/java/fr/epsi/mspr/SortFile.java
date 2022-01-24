package fr.epsi.mspr;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortFile {
    public static void sortFile() throws IOException, IOException {

        List<String> lines = loadLines("./src/main/resources/staff.txt");
        System.out.println(lines + "\n");
        Collections.sort(lines);
        Path file = Paths.get("./src/main/resources/staff.txt");
        Files.write(file, lines, StandardCharsets.UTF_8);
    }

    private static List<String> loadLines(String fileName) throws IOException {
        System.out.println("Reading file");
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<String> lines = new ArrayList<String>();
        String line;
        while ((line = br.readLine()) != null)
            lines.add(line);
        System.out.println("... Read file.");
        return lines;
    }
}
