package Bot;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

//TODO @ person who needs to receive points
//TODO check if the person who executes command is allowed to give points
//TODO Make command lose coupled (Easy to add a command)

public class Event extends ListenerAdapter {
    public Event() {
    }

    char prefix = '!';
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
      
        String receivedMessageRaw = event.getMessage().getContentRaw();
        Member author = event.getMember();

        if(receivedMessageRaw.contains(""+prefix) && allowedToGivePoints(author)){
            int possitionPrefix = receivedMessageRaw.indexOf(prefix);
            if(getNumberFromCommand(receivedMessageRaw) > 0){
                checkCommand(receivedMessageRaw.substring(possitionPrefix + 1), getNumberFromCommand(receivedMessageRaw));
            }else{
                checkCommand(receivedMessageRaw.substring(possitionPrefix + 1));
            }

        }
    }

    public void onReady(ReadyEvent event) {
        //TODO Read all users and put them into a Dictionary with the discord ID as the dictionary id
    }

    private boolean allowedToGivePoints(Member member){
        return  member.hasPermission(Permission.ADMINISTRATOR);
    }


    //TODO make this lose coupled
    private void checkCommand(String command){
        switch (command){
            case "AddGBP":
                break;
            case "RMGBP":
                break;
        }
    }

    //TODO make this lose coupled
    private void checkCommand(String command, int ammount){
        switch (command){
            case "AddGBP":
                break;
            case "RMGBP":
                break;
        }
    }

    //TODO commandHasNumber && getNumberFromCommand could be one function that returns a number or null depending if the command has a number or not
//    private boolean commandHasNumber(String command){
//        if(command.contains(" ")){
//            String[] commandSplit = command.split(" ");
//            for(int index = 0; index < commandSplit.length; index++){
//                try{
//                    Integer.parseInt((commandSplit[index]));
//                    return true;
//                }catch (Exception e){}
//            }
//        }
//        return false;
//    }

    private int getNumberFromCommand(String command){
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

}
