package Bot;

import Logica.Person;
import Logica.Server;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

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

        if(receivedMessageRaw.contains(""+prefix)){
            //int possitionPrefix = receivedMessageRaw.indexOf(prefix);
            String command = receivedMessageRaw.split(" ")[0];
            if(getNumberFrom(receivedMessageRaw) > 0){
                checkCommand(
                        command.substring(1), 
                        author, 
                        getNumberFrom(receivedMessageRaw),
                        getReceiver(event.getMessage(), event.getGuild().getId()));
            }else{
                checkCommand(
                        command.substring(1), 
                        author, 
                        getReceiver(event.getMessage(), event.getGuild().getId()));
            }
        }
    }

    public void onReady(ReadyEvent event) {
        //TODO Read all users and put them into a Dictionary with the discord ID as the dictionary id
    }

    //TODO change the where you check if the person is allowed to give points
    private boolean allowedToGivePoints(Member member){
        return  member.hasPermission(Permission.ADMINISTRATOR);
    }


    private void checkCommand(String command,Member author, ArrayList<Person> receivers){
        switch (command.toLowerCase()){
            case "addpoints":
                if(allowedToGivePoints(author)) {
                    for (int i = 0; i < receivers.size(); i++) {
                        receivers.get(i).AddPoint(1);
                    }
                }
                break;
            case "rmpoints":
                if(allowedToGivePoints(author)) {
                    for (int i = 0; i < receivers.size(); i++) {
                        receivers.get(i).RemovePoint(1);
                    }
                }
                break;
            case "points":
                if(allowedToGivePoints(author)) {
                    for (int i = 0; i < receivers.size(); i++) {
                        receivers.get(i).GetPoints();
                    }
                }
                break;
            case "settings":
                if(allowedToGivePoints(author)) {}
                break;
            case "set":
                if(allowedToGivePoints(author)) {}
                break;
            case "clear":
                if(allowedToGivePoints(author)) {}
                break;
            default:
                break;
        }
    }


    private void checkCommand(String command,Member author, int ammount, ArrayList<Person> receivers){
       switch (command.toLowerCase()){
            case "addpoints":
                if(allowedToGivePoints(author)) {
                    for (int i = 0; i < receivers.size(); i++) {
                        receivers.get(i).AddPoint(ammount);
                    }
                }
                break;
            case "rmpoints":
                if(allowedToGivePoints(author)) {
                    for (int i = 0; i < receivers.size(); i++) {
                        receivers.get(i).RemovePoint(ammount);
                    }
                }
                break;
            case "set":
                if(allowedToGivePoints(author)) {}
                break;
            default:
                break;
        }
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
    }
}
