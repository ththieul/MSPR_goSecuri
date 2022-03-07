package fr.epsi.mspr;


import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class HtpasswdGenerator {
    public List<String> agentList = AgentList.getAgentList();
    public Map<String, String> userPasswd = MapGenerator.userPwHashMap(agentList);

    public void generateHtpasswdFile() {
        try(PrintWriter printWriter = new PrintWriter(".htpasswd")) {
            for (Map.Entry<String, String> entry : userPasswd.entrySet()) {
                printWriter.println(entry.getKey() + ":" + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
