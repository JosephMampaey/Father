import javax.security.auth.login.LoginException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import Bot.Event;
import Data.TokenReader;
import java.io.FileNotFoundException;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;


public class Main {
    public static void main(String[] args) throws LoginException, FileNotFoundException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = TokenReader.getToken();
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB); //doens't work
        builder.setActivity(Activity.playing("with mommy"));
        builder.setToken(token).addEventListeners(new Event()).build();
    }
}
