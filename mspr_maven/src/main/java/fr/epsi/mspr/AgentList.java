package fr.epsi.mspr;

import java.io.IOException;
import java.util.List;

public class AgentList {
    private static List<String> agentList;
    public static List<String> getAgentList(){
        try {
            SortFile.sortFile();
            agentList = SortFile.getSortedList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return agentList;
    }
}
