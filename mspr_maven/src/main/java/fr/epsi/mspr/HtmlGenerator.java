package fr.epsi.mspr;

import java.io.*;
import java.util.*;


public class HtmlGenerator {
    private final Map<String, String> equipmentMap = MapGenerator.equipementMap();
    private final List<Agent> agentsInfosList = StaffList.createAgentsInfosList();


    public void generateAgentPage(String currentAgentFilePath, Agent agent){
        try (PrintWriter agentPersonalFile = new PrintWriter(currentAgentFilePath)) {
            agentPersonalFile.println("<html>");
            agentPersonalFile.println("<head>");
            agentPersonalFile.println("<meta charset='utf-8'>");
            agentPersonalFile.println("<title>Go Securi</title>");
            agentPersonalFile.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
            agentPersonalFile.println("<link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap\" rel=\"stylesheet\">");
            agentPersonalFile.println("<link rel='stylesheet' type='text/css' media='screen' href='../assets/css/style.css'>");
            agentPersonalFile.println("</head>");
            agentPersonalFile.println("<body>");
            agentPersonalFile.println("<article class=\"leaderboard\">");
            //-------------HEADER-----------------------------------------------------------------------------
            agentPersonalFile.println("<header>");
            agentPersonalFile.println("<img src='../assets/img/GoSecuri_logo.png' alt=\"Go Securi Logo\">");
            agentPersonalFile.println("<h1 class=\"leaderboard__title\"><span class=\"leaderboard__title--top\">Fiche Agent</span></h1>");
            agentPersonalFile.println("</header>");
            //-------------/HEADER-----------------------------------------------------------------------------

            agentPersonalFile.println(String.format("<p class=\"leaderboard__title\">%1$s</p>",agent.firstName + " " + agent.lastName));
            agentPersonalFile.println(String.format("<img id=\"identite\" src='../assets/img/img_agents/%1$s.jpg' alt='Image of %1$s'>", agent.username));

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

    public void generateHTMLPages(){
        try (PrintWriter landingPage = new PrintWriter("index.html")){
            landingPage.println("<html>");
            landingPage.println("<head>");
            landingPage.println("<meta charset='utf-8'>");
            landingPage.println("<title>Go Securi</title>");
            landingPage.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
            landingPage.println("<link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap\" rel=\"stylesheet\">");
            landingPage.println("<link rel='stylesheet' type='text/css' media='screen' href=\"./assets/css/style.css\">");
            landingPage.println("</head>");
            landingPage.println("<body>");
            landingPage.println("<article class=\"leaderboard\">");
            //-------------HEADER-----------------------------------------------------------------------------
            landingPage.println("<header>");
            landingPage.println("<img src=\"./assets/img/GoSecuri_logo.png\" alt=\"Go Securi Logo\">");
            landingPage.println("<a href=\"./assets/android_apk/app-release.apk\">Télécharger GoSecuri pour Android</a>");
            landingPage.println("<h1 class=\"leaderboard__title\"><span class=\"leaderboard__title--top\">Liste d'agents</span></h1>");
            landingPage.println("</header>");
            //-------------/HEADER-----------------------------------------------------------------------------
            landingPage.println("<main class=\"leaderboard__profiles\">");

                for (Agent agent:agentsInfosList) {
                    landingPage.println("<article class=\"leaderboard__profile\">");
                    landingPage.println(String.format("<img src=\"./assets/img/photo-avatar-profil.png\" alt=\"%1$s\" class=\"leaderboard__picture\">", agent.username));
                    landingPage.println(String.format("<a class=\"leaderboard__name\" href=\"./users/%1$s.html\">%2$s</a>", agent.username, agent.firstName + " " + agent.lastName));
                    landingPage.println("</article>");
                    generateAgentPage(String.format("./mspr_maven/src/main/resources/agents_html_file/%1$s.html",agent.username),agent);
                }

                landingPage.println("</main>");
                landingPage.println("</article>");
                landingPage.println("</body>");
                landingPage.println("</html>");

                System.out.println("HTML file is processed :)");
            } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

    }

    public void generateAgentHTMLFiles(){
        for (Agent agent:agentsInfosList) {
            String currentFileString = "./mspr_maven/src/main/resources/agents_html_file/"+agent.username+".html";
            File htmlFile = new File(currentFileString);
            try {
                htmlFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

