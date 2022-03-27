package fr.epsi.mspr;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        HtmlGenerator htmlGenerator = new HtmlGenerator();
        HtpasswdGenerator htpasswdGenerator = new HtpasswdGenerator();
        htmlGenerator.generateHTMLPages();
        htmlGenerator.generateAgentHTMLFiles();
        List<String> agentList = StaffList.getSortedAgentList();
        MapGenerator.userPwMap(agentList);
        htpasswdGenerator.generateHtpasswdFile();
    }
}