package fr.epsi.mspr;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        HtmlGenerator htmlGenerator = new HtmlGenerator();
        HtpasswdGenerator htpasswdGenerator = new HtpasswdGenerator();
        htmlGenerator.generateLandingPage();
        htmlGenerator.generateAgentFiles();
        List<String> agentList = StaffList.getSortedAgentList();
        MapGenerator.userPwHashMap(agentList);
        htpasswdGenerator.generateHtpasswdFile();
        StaffList.createAgentsInfosList();
    }
}