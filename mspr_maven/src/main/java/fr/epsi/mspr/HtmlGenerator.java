package fr.epsi.mspr;

import java.io.*;
import java.util.*;


public class HtmlGenerator {
    private final Map<String, String> equipmentMap = MapGenerator.equipementHashMap();
    private final List<Agent> agentsInfosList = StaffList.createAgentsInfosList();

    private static void addPic(PrintWriter fileOut, String imgPath, String imgAlt){
        String str = String.format("<img src='%1$s' alt='%2$s'>", imgPath, imgAlt);
        fileOut.println(str);
    }

    public void generateAgentPage(String currentAgentFilePath, Agent agent){
        try (PrintWriter agentPersonalFile = new PrintWriter(currentAgentFilePath)) {
            agentPersonalFile.println("<html>");
            agentPersonalFile.println("<head>");
            agentPersonalFile.println("</head>");
            agentPersonalFile.println("<body>");

            agentPersonalFile.println(String.format("<p>%1$s</p>",agent.firstName + " " + agent.lastName));
            addPic(agentPersonalFile,String.format("../../../../../ID/%1$s.png",agent.username),String.format("Image of %1$s",agent.username));

            agentPersonalFile.println("<ul>");

                for(String equipement: agent.equipment) {
                    agentPersonalFile.println("<input type=\"checkbox\" checked>");
                    agentPersonalFile.println(String.format("<label>%1$s</label><br>", equipmentMap.get(equipement)));
                }

            agentPersonalFile.println("</ul>");
            agentPersonalFile.println("</body>");
            agentPersonalFile.println("</html>");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void generatePages(){
        try (PrintWriter fileOut = new PrintWriter("index.html")){
                fileOut.println("<html>");
                fileOut.println("<head>");
                fileOut.println("</head>");
                fileOut.println("<body>");
                fileOut.println("<ul>");

                for (Agent agent:agentsInfosList) {
                    fileOut.println(String.format("<li><a href=\"./src/main/resources/agents_html_file/%1$s.html\">%1$s</a></li>",agent.username));
                    fileOut.println("<br>");
                    generateAgentPage(String.format("./src/main/resources/agents_html_file/%1$s.html",agent.username),agent);
                }

                fileOut.println("</ul>");
                fileOut.println("</body>");
                fileOut.println("</html>");

                System.out.println("HTML file is processed :)");
            } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

    }

    public void generateAgentFiles(){
        for (Agent agent:agentsInfosList) {
            String currentFileString = "./src/main/resources/agents_html_file/"+agent.username+".html";
            File htmlFile = new File(currentFileString);
            try {
                htmlFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

