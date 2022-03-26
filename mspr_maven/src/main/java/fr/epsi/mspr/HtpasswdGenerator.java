package fr.epsi.mspr;


import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class HtpasswdGenerator {
    public List<String> agentList = StaffList.getSortedAgentList();
    public Map<String, String> userPasswd = MapGenerator.userPwMap(agentList);

    public void generateHtpasswdFile() {
        try(PrintWriter printWriter = new PrintWriter(".htpasswd")) {
            userPasswd.forEach((key, value) -> printWriter.println(key + ":" + value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
