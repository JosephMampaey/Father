package controller;

import model.Person;
import model.Server;

import java.util.*;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

//TODO @ person who needs to receive points
//TODO check if the person who executes command is allowed to give points
//TODO Make command lose coupled (Easy to add a command)

public class ServerController extends ListenerAdapter {
    
    Map<String, Server> servers =  new HashMap<>();

    public ServerController() {
    }



    public void onReady(ReadyEvent event){
        servers = getGuilds(event);

        System.out.println("==============================================");
        System.out.println("Bot operational");
        System.out.println("==============================================");
    }

    public void onGuildJoin(GuildJoinEvent event){
        Guild guild = event.getGuild();
        servers.put(guild.getId(), convertServer(guild));
    }

    private Map<String, Server> getGuilds(ReadyEvent event) {
        Map<String, Server> servers =  new HashMap<>();
        for (Guild guild : event.getJDA().getGuilds())
            servers.put(guild.getId(), convertServer(guild));
        return servers;
    }

    private Server convertServer(Guild guild){
        Server server = new Server(guild.getId());

        for(Member member : guild.getMembers()){
            server.addMember(new Person( member.getId(), guild.getId(), member.getEffectiveName()));
        }

        return server;
    }
}
