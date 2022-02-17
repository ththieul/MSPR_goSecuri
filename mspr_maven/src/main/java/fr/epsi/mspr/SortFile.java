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

        List<String> lines = getSortedList();
        Path file = Paths.get("./staff.txt");
        Files.write(file, lines, StandardCharsets.UTF_8);
    }

    public static List<String> getSortedList() throws IOException {
        List<String> lines = loadLines("./staff.txt");
        Collections.sort(lines);
        return lines;
    }

    public static List<String> loadLines(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<String> lines = new ArrayList<String>();
        String line;
        while ((line = br.readLine()) != null)
            lines.add(line);
        return lines;
    }
}
