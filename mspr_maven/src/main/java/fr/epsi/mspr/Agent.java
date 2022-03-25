package fr.epsi.mspr;

import java.util.List;

public class Agent {
    public String username;
    public String lastName;
    public String firstName;
    public String occupation;
    public String password;
    public List<String> equipment;

    @Override
    public String toString() {
        return "Agent{" +
                "username='" + username + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", occupation='" + occupation + '\'' +
                ", password='" + password + '\'' +
                ", equipment=" + equipment +
                '}';
    }

    public Agent(String username, String lastName, String firstName, String occupation, String password, List<String> equipment){
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.occupation = occupation;
        this.password = password;
        this.equipment = equipment;
    }

}
