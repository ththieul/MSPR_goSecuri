package fr.epsi.mspr;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        throw new FileNotFoundException();
        HtmlGenerator htmlGenerator = new HtmlGenerator();
        HtpasswdGenerator htpasswdGenerator = new HtpasswdGenerator();
        htmlGenerator.generateAgentHTMLFiles();
        htmlGenerator.generateHTMLPages();
        htpasswdGenerator.generateHtpasswdFile();
    }
}