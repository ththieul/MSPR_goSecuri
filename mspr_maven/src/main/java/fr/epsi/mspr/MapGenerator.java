package fr.epsi.mspr;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class MapGenerator {
    public static Map<String, String> equipementHashMap()
    {

        Map<String, String> equipementMap = new HashMap<String, String>();

        try ( BufferedReader br = new BufferedReader(new FileReader("../liste.txt"))){

            String line;

            while ((line = br.readLine()) != null) {


                String[] equipement = line.split("\t");

                String shortName = equipement[0].trim();
                String longName = equipement[1].trim();


                if (!Objects.equals(shortName, "") && !Objects.equals(longName, ""))
                    equipementMap.put(shortName, longName);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return equipementMap;
    }
    public static Map<String, String> userPwHashMap(List<String> agentList){
        Map<String, String> userPw = new HashMap<>();

        try {
            for (String agent:agentList) {
                String password = "";
                File currentAgentFile = new File(String.format("../%1$s.txt",agent));
                BufferedReader br = new BufferedReader(new FileReader(currentAgentFile));
                String line = null;
                int i = 0;
                while ((line = br.readLine()) != null) {
                    if (Objects.equals(i, 3)){
                        password = Encryption.hashString(line);
                    }
                    i++;
                    userPw.put(agent, password);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return userPw;
    }
}

