package Logica;

import net.dv8tion.jda.core.entities.Guild;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Server {
    private String guildId;
    private Dictionary<String, Person> members = new Hashtable<String, Person>();

    public Server(String guildId){
        this.guildId = guildId;
    }

    public void addMember(Person person){
        members.put(person.getDiscordId(), person);
    }
    
    
    public String getGuildId(){
        return guildId;
    }
    public Dictionary<String, Person> getMembers(){
        return members;
    }
}
