package Presentatie;

import javax.security.auth.login.LoginException;

import Controller.CommandConntroller;
import Controller.PointController;
import Controller.ServerController;
import Service.TokenReader;
import java.io.FileNotFoundException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;


public class Main {
    public static void main(String[] args) throws LoginException, FileNotFoundException {
        String token = TokenReader.getToken();
        JDABuilder builder = JDABuilder.create(token,GatewayIntent.GUILD_MEMBERS);
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.playing("with mommy"));
        builder.setToken(token)
                .addEventListeners(new ServerController())
                .addEventListeners(new PointController())
                .addEventListeners(new CommandConntroller())
                .build();
    }
}
