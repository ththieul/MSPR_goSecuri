package fr.epsi.mspr;

import java.io.*;
import java.util.*;


public class HtmlGenerator {
    Map<String,String> equipementMap = MapGenerator.equipementHashMap();
    public Scanner fileIn;
    public List<String> agentList = AgentList.getAgentList();

    public static void addPic(PrintWriter fileOut, String imgPath, String imgAlt){
        String str = String.format("<img src='%1$s' alt='%2$s'>", imgPath, imgAlt);
        fileOut.println(str);
    }

    public void generateAgentPage(String currentAgentFilePath, String currentAgentName, String currentAgenttxtFilePath){
        List<String> currentAgentEquipementList = getAgentEquipement(currentAgenttxtFilePath);
        try (PrintWriter agentPersonalFile = new PrintWriter(currentAgentFilePath)) {
            agentPersonalFile.println("<html>");
            agentPersonalFile.println("<head>");
            agentPersonalFile.println("</head>");
            agentPersonalFile.println("<body>");

            agentPersonalFile.println(String.format("<p>%1$s</p>",currentAgentName));
            addPic(agentPersonalFile,String.format("../../../../../ID/%1$s.png",currentAgentName),String.format("Image of %1$s",currentAgentName));

            agentPersonalFile.println("<ul>");

            for (String equipement:currentAgentEquipementList) {
                agentPersonalFile.println("<input type=\"checkbox\" checked>");
                agentPersonalFile.println(String.format("<label>%1$s</label><br>",equipementMap.get(equipement)));
            }

            agentPersonalFile.println("</ul>");
            agentPersonalFile.println("</body>");
            agentPersonalFile.println("</html>");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAgentEquipement(String agentTxtFilePath) {
        List<String> agentEquipementList = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(agentTxtFilePath))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null){
                if(i > 4){
                    agentEquipementList.add(line);
                }
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return agentEquipementList;
    }

    public void generateLandingPage(){
        String line = null;
        // 2. check if file exists

        try {

            //3. rename .txt as .html
            fileIn = new Scanner(new FileReader("../staff.txt"));
            PrintWriter fileOut = new PrintWriter("index.html");

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
                fileOut.println("<ul>");

                for (String agent:agentList) {
                    fileOut.println(String.format("<li><a href=\"./src/main/resources/agents_html_file/%1$s.html\">%1$s</a></li>",agent));
                    fileOut.println("<br>");
                    generateAgentPage(String.format("./src/main/resources/agents_html_file/%1$s.html",agent),agent,String.format("../%1$s.txt",agent));
                }

                fileOut.println("</ul>");
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
        for (String agent:agentList) {
            String currentFileString = "./src/main/resources/agents_html_file/"+agent+".html";
            File htmlFile = new File(currentFileString);
            try {
                htmlFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

