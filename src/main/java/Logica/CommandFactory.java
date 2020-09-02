/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;


/**
 *
 * @author jefdr
 */
public class CommandFactory {
    public CommandFactory(){
        
    }
    
    public void checkCommand(String command,Member author, ArrayList<Person> receivers){
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
            case "clear":
                if(allowedToGivePoints(author)) {
                    for (int i = 0; i < receivers.size(); i++) {
                        receivers.get(i).setPoints(0);
                    }
                }
                break;
            default:
                break;
        }
    }
    
    public void checkCommand(String command,Member author, int ammount, ArrayList<Person> receivers){
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
                if(allowedToGivePoints(author)) {
                    for (int i = 0; i < receivers.size(); i++) {
                        receivers.get(i).setPoints(ammount);
                    }
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
