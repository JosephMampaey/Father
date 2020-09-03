/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
https://ci.dv8tion.net/job/JDA/javadoc/net/dv8tion/jda/api/EmbedBuilder.html
 */
package Presentatie;

import Logica.Person;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Dictionary;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Invite.Channel;
import net.dv8tion.jda.api.entities.MessageChannel;

/**
 *
 * @author Jef
 */
public class Presentation {
    public Presentation(){
        
    }
    
    public void presentationAddpoints(ArrayList<Person> users,String points,MessageChannel channel){
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(points + " point(s) given to");
        for (int i = 0; i < users.size(); i++) {
            eb.addField(users.get(i).getNickname(),"", true);
        }
        eb.setFooter("Who is a good boy/girl");
        eb.setColor(Color.green);
        channel.sendMessage(eb.build()).queue();
    }
    
    public void presentationRemovePoints(ArrayList<Person> users,String points,MessageChannel channel){
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(points + " point(s) removed from");
        for (int i = 0; i < users.size(); i++) {
            eb.addField(users.get(i).getNickname(),"", true);
        }
        eb.setFooter("Who is a bad boy/girl");
        eb.setColor(Color.red);
        channel.sendMessage(eb.build()).queue();
    }
    
    public void presentationClearPoints(ArrayList<Person> users,String points,MessageChannel channel){
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("point cleared from");
        for (int i = 0; i < users.size(); i++) {
            eb.addField(users.get(i).getNickname(),"", true);
        }
        eb.setFooter("Who is a sad boy/girl");
        eb.setColor(Color.gray);
        channel.sendMessage(eb.build()).queue();
    }
    
    public void presentationPoints(ArrayList<Person> users,MessageChannel channel){
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("point from");
        for (int i = 0; i < users.size(); i++) {
            eb.addField(users.get(i).getNickname(),""+users.get(i).GetPoints(), false);
        }
        eb.setFooter("hehehe");
        eb.setColor(Color.gray);
        channel.sendMessage(eb.build()).queue();
    }
    
    public void presentationSet(ArrayList<Person> users,String points,MessageChannel channel){
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("users set to "+points+" points");
        for (int i = 0; i < users.size(); i++) {
            eb.addField(users.get(i).getNickname(),"", true);
        }
        eb.setFooter("OwO");
        eb.setColor(Color.gray);
        channel.sendMessage(eb.build()).queue();
    }
    
    
}
