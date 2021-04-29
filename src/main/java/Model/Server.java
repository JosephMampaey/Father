package Model;

import java.util.*;

public class Server {
    private String guildId;
    private Map<String, Person> members = new HashMap<String, Person>();
    private Settings serverSetting;

    public Server(String guildId){
        this.guildId = guildId;
        this.serverSetting = new Settings();
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
