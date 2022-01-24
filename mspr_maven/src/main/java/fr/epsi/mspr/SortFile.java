package fr.epsi.mspr;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortFile {
    public static void main(String... args) throws IOException {

        List<String> lines = loadLines("./src/main/resources/staff.txt");
        System.out.println(lines + "\n");
        Collections.sort(lines);
        PrintWriter staff = new PrintWriter("./src/main/resources/staff.txt");
        System.out.println(lines);
    }

    private static List<String> loadLines(String fileName) throws IOException {
        System.out.println("Reading file");
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<String> ret = new ArrayList<String>();
        String line;
        while ((line = br.readLine()) != null)
            ret.add(line);
        System.out.println("... Read file.");
        return ret;
    }
}
