package fr.epsi.mspr;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        HtmlGenerator htmlGenerator = new HtmlGenerator();
        HtpasswdGenerator htpasswdGenerator = new HtpasswdGenerator();
        htmlGenerator.generateLandingPage();
        htmlGenerator.generateAgentFiles();
        List<String> agentList = AgentList.getAgentList();
        Map<String, String> mymap = MapGenerator.userPwHashMap(agentList);
        htpasswdGenerator.generateHtpasswdFile();

        for(Map.Entry<String, String> entry: mymap.entrySet()){
            if(Objects.equals(entry.getKey(), "acortes")){
                System.out.println(Encryption.compareHashToCandidate("1Fche7EgsZ73v", entry.getValue()));
            }
        }

    }
}