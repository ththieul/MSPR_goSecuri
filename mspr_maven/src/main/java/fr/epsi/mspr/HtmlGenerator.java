package fr.epsi.mspr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class HtmlGenerator {
    public Scanner fileIn; //input file connection
    public PrintWriter fileOut; //HTML file connection
    public String filenameIn; //original file's name
    public String filenameOut; //new HTML file's name
    public String agentFile;
    public int dotIndex; //position of . in filename
    public String line = null; // a line from the input file
    public List<String> agentList = null;

    public static void addPic(PrintWriter fileOut, String imgPath, String imgAlt){
        String str = String.format("<img src='%1$s' alt='%2$s'>", imgPath, imgAlt);
        fileOut.println(str);
    }

    public void generateLandingPage(){
        //	HTML stands for "Hyper Text Markup Language"
        // 	used for creating web pages


        // 1. check if file exists
        // 2. rename .txt as .html
        // 3. determine if file is empty
        // 4. read each line and insert necessary <tags>

        filenameIn = "staff.txt";


        // 2. check if file exists

        try {

            //3. rename .txt as .html
            fileIn = new Scanner(new FileReader("./mspr_maven/src/main/resources/"+filenameIn));
            dotIndex = filenameIn.lastIndexOf(".");
            filenameOut = filenameIn.substring(0,dotIndex) + ".html";
            fileOut = new PrintWriter(filenameOut);

            // 4. determine if file is empty

            try {
                line = fileIn.nextLine();
            }
            catch(NoSuchElementException e) {
                System.out.println("Error: "+e.getMessage());
            }
            if(line==null) {
                System.out.println("This file is empty :(");
            }
            else {
                // 5. read each line and insert necessary <tags>
                fileOut.println("<html>");
                fileOut.println("<head>");
                fileOut.println("</head>");
                fileOut.println("<body>");
                fileOut.println(line);

                while(fileIn.hasNextLine()) {

                    fileOut.println("<br>");
                    line = fileIn.nextLine();

                    fileOut.println(line);

                }
                fileOut.println("</body>");
                fileOut.println("</html>");

                System.out.println("HTML file is processed :)");
            }
            fileIn.close();
            fileOut.close();
        }

        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

    public void generateAgentFiles(){
        try {
            SortFile.sortFile();
            agentList = SortFile.getSortedList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String agent:agentList) {
            String currentFileString = "./mspr_maven/src/main/resources/agents_html_file/"+agent+".html";
            File htmlFile = new File(currentFileString);
            try {
                htmlFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(htmlFile);
        }
    }

}

