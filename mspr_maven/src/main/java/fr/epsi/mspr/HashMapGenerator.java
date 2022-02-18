package fr.epsi.mspr;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

class HashMapGenerator {
    final static String filePath = "../liste.txt";
    public void showDic(Map<String, String> map)
    {
        map = HashMapFromTextFile();

        // iterate over HashMap entries
        for (Map.Entry<String, String> entry :
                map.entrySet()) {
            System.out.println(entry.getKey() + " : "
                    + entry.getValue());
        }
    }

    public static Map<String, String> HashMapFromTextFile()
    {

        Map<String, String> map = new HashMap<String, String>();
        BufferedReader br = null;

        try {

            // create file object
            File file = new File(filePath);

            // create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));

            String line = null;

            // read file line by line
            while ((line = br.readLine()) != null) {

                // split the line by :
                String[] equipement = line.split("\t");

                // first part is name, second is number
                String shortName = equipement[0].trim();
                String longName = equipement[1].trim();

                // put name, number in HashMap if they are
                // not empty
                if (!shortName.equals("") && !longName.equals(""))
                    map.put(shortName, longName);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            // Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }

        return map;
    }
}

