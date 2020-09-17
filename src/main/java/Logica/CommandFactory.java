/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Presentatie.Presentation;
import java.util.ArrayList;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;


/**
 *
 * @author jefdr
 */
public class CommandFactory {
    public CommandFactory(){
        
    }
    //if the command does not have a number
    public void checkCommand(String command,Member author, ArrayList<Person> receivers, MessageChannel messageChannel){
        Presentation p = new Presentation();
         switch (command.toLowerCase()){
            case "addpoints":
                if(allowedToGivePoints(author)) {
                    for (int i = 0; i < receivers.size(); i++) {
                        if(!author.getId().equals(receivers.get(i).getDiscordId())){
                            receivers.get(i).AddPoint(1);
                        }else{
                            receivers.remove(i);
                        }
                    }
                    p.presentationAddpoints(receivers, "1", messageChannel);
                }
                break;
            case "rmpoints":
                if(allowedToGivePoints(author)) {
                    for (int i = 0; i < receivers.size(); i++) {
                        if(!author.getId().equals(receivers.get(i).getDiscordId())){
                            receivers.get(i).RemovePoint(1);
                        }else{
                            receivers.remove(i);
                        }
                    }
                    p.presentationRemovePoints(receivers, "1", messageChannel);
                }
                break;
            case "points":
                if(allowedToGivePoints(author)) {
                    for (int i = 0; i < receivers.size(); i++) {
                        receivers.get(i).GetPoints();
                    }
                    p.presentationPoints(receivers, messageChannel);
                }
                break;
            case "settings":
                if(allowedToGivePoints(author)) {}
                break;
            case "clear":
                if(allowedToGivePoints(author)) {
                    for (int i = 0; i < receivers.size(); i++) {
                        receivers.get(i).setPoints(0);
                    }
                    p.presentationClearPoints(receivers, "1", messageChannel);
                }
                break;
            default:
                break;
        }
    }
    //if the command has a number
    public void checkCommand(String command,Member author, int ammount, ArrayList<Person> receivers, MessageChannel messageChannel){
        Presentation p = new Presentation();
       switch (command.toLowerCase()){
            case "addpoints":
                if(allowedToGivePoints(author)) {
                    for (int i = 0; i < receivers.size(); i++) {
                        if(!author.getId().equals(receivers.get(i).getDiscordId())){
                            receivers.get(i).AddPoint(ammount);
                        }else{
                            receivers.remove(i);
                        }
                    }
                    p.presentationAddpoints(receivers, ""+ammount, messageChannel);
                }
                break;
            case "rmpoints":
                if(allowedToGivePoints(author)) {
                    for (int i = 0; i < receivers.size(); i++) {
                        if(!author.getId().equals(receivers.get(i).getDiscordId())){
                            receivers.get(i).RemovePoint(ammount);
                        }else{
                            receivers.remove(i);
                        }  
                    }
                    p.presentationRemovePoints(receivers, ""+ammount, messageChannel);
                }
                break;
            case "set":
                if(allowedToGivePoints(author)) {
                    for (int i = 0; i < receivers.size(); i++) {
                        if(!author.getId().equals(receivers.get(i).getDiscordId())){
                            receivers.get(i).setPoints(ammount);
                        }else{
                            receivers.remove(i);
                        }
                    }
                    p.presentationSet(receivers, ""+ammount, messageChannel);
                }
                break;
            default:
                break;
        }
    }
    
    private boolean allowedToGivePoints(Member member){
        return  member.hasPermission(Permission.ADMINISTRATOR);
    }
    
    private void addPointsPresentation(){
        
    }
    
}
