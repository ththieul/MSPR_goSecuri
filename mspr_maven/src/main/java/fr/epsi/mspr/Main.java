package fr.epsi.mspr;

import java.io.*;
import java.util.*;

public class Main {

    public static void addPic(PrintWriter fileOut, String imgPath, String imgAlt){
        String str = String.format("<img src='%1$s' alt='%2$s'>", imgPath, imgAlt);
        fileOut.println(str);
    }

    public static void main(String[] args) throws IOException {
        HtmlGenerator htmlGenerator = new HtmlGenerator();
        htmlGenerator.generateLandingPage();
    }
}