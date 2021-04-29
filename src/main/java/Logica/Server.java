package Logica;

import java.util.*;

public class Server {
    private String guildId;
    private Map<String, Person> members = new HashMap<String, Person>();

    public Server(String guildId){
        this.guildId = guildId;
    }

    public void addMember(Person person){
        members.put(person.getDiscordId(), person);
    }
    
    
    public String getGuildId(){
        return guildId;
    }
    public Map<String, Person> getMembers(){
        return members;
    }
}
