package Bot;

import Data.Data;
import Logica.CommandFactory;
import Logica.Person;
import Logica.Server;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

//TODO @ person who needs to receive points
//TODO check if the person who executes command is allowed to give points
//TODO Make command lose coupled (Easy to add a command)

public class Event extends ListenerAdapter {
    
    Dictionary<String, Server> servers =  new Hashtable<String, Server>();
    
    public Event() {
    }

    char prefix = '!';
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        
        String receivedMessageRaw = event.getMessage().getContentRaw();
        Member author = event.getMember();
        CommandFactory commandFactory = new CommandFactory();
        if(receivedMessageRaw.startsWith(""+prefix)){
            //int possitionPrefix = receivedMessageRaw.indexOf(prefix);
            String command = receivedMessageRaw.split(" ")[0];
            if(getNumberFrom(receivedMessageRaw) > 0){
                commandFactory.checkCommand(command.substring(1),author,getNumberFrom(receivedMessageRaw),getReceiver(event.getMessage(), event.getGuild().getId()), event.getChannel());
                        
            }else{
                commandFactory.checkCommand(command.substring(1),author,getReceiver(event.getMessage(), event.getGuild().getId()),event.getChannel());
            }
        }
    }

    public void onReady(ReadyEvent event) {
        //TODO Read all users and put them into a Dictionary with the discord ID as the dictionary id
    }

    private int getNumberFrom(String command){
        if(command.contains(" ")){
            String[] commandSplit = command.split(" ");
            for(int index = 0; index < commandSplit.length; index++){
                try{
                    int number = Integer.parseInt((commandSplit[index]));
                    return number;
                }catch (Exception e){}
            }
        }
        return -1;
    }
    
    private ArrayList<Person> getReceiver(Message message, String serverId){
        ArrayList<Person> returnReceivers = new ArrayList<Person>();
        if(message.getMentionedUsers().size() > 0){
            for (int i = 0; i < message.getMentionedUsers().size(); i++) {
                User user = message.getMentionedUsers().get(i);
                addServer(serverId);
                addPersonToServer(serverId,user);
                returnReceivers.add(servers.get(serverId).getMembers().get(user.getId()));
            }
        }
        return returnReceivers;
    }
    
    private void addServer(String serverId){
        try{
            servers.get(serverId).getGuildId();
        }catch(Exception e){
            servers.put(serverId,new Server(serverId));
        }
    }
    
    private void addPersonToServer(String serverId,User user){
        try{
            Person person = servers.get(serverId).getMembers().get(user.getId());
            person.GetPoints();

        }catch(Exception e){
            servers.get(serverId).addMember(new Person(user.getId(),serverId,user.getName()));
        }
        Data d = new Data();
        d.SaveDiscordServer(servers.get(serverId));
    }
}
