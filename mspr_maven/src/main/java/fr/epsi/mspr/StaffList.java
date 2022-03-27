package fr.epsi.mspr;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StaffList {
    public static final String STAFF_FILENAME = "./staff.txt";

    private static List<String> loadLines() throws IOException {
       try (BufferedReader br = new BufferedReader(new FileReader(STAFF_FILENAME))) {
           List<String> lines = new ArrayList<String>();
           String line;
           while ((line = br.readLine()) != null)
               lines.add(line);
           return lines;
       }
    }

    public static List<String> getSortedAgentList() {
        List<String> lines = null;
        try {
            lines = loadLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert lines != null;
        Collections.sort(lines);
        return lines;
    }

    public static List<Agent> createAgentsInfosList() {
        List<Agent> agentsInfosList = new ArrayList<Agent>();
        List<String> agentList = getSortedAgentList();
        for (String agentUsername:agentList) {
               List<String> agentEquipementList = new ArrayList<String>();
            String lastName = null;
            String firstName = null;
            String occupation = null;
            String password = null;
            try (Scanner line = new Scanner(new FileReader(String.format("./%1$s.txt",agentUsername)))) {

                //String line;
                lastName = line.nextLine();
                firstName = line.nextLine();
                occupation = line.nextLine();
                password = line.nextLine();
                line.nextLine();

                while (line.hasNext()) {
                    agentEquipementList.add(line.nextLine());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            Agent newAgent = new Agent(agentUsername.toLowerCase(), lastName, firstName, occupation, password, agentEquipementList);
            agentsInfosList.add(newAgent);
        }
        return agentsInfosList;
    }
}
