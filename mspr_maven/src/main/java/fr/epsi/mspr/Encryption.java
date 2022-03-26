package fr.epsi.mspr;

import org.mindrot.jbcrypt.BCrypt;

public class Encryption {
    public static String hashString(String str){
        return BCrypt.hashpw(str, BCrypt.gensalt(12));
    }
}

