package fr.epsi.mspr;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        HtmlGenerator htmlGenerator = new HtmlGenerator();
        //htmlGenerator.generateLandingPage();
        htmlGenerator.generateAgentFiles();
    }
}