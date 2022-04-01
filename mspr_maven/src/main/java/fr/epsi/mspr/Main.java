package fr.epsi.mspr;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        HtmlGenerator htmlGenerator = new HtmlGenerator();
        HtpasswdGenerator htpasswdGenerator = new HtpasswdGenerator();
        htmlGenerator.generateAgentHTMLFiles();
        htmlGenerator.generateHTMLPages();
        htpasswdGenerator.generateHtpasswdFile();
    }
}