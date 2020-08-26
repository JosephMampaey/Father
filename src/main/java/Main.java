import javax.security.auth.login.LoginException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import Bot.Event;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Main {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "NzQ3OTA0NzkzOTIxNDU0MTUx.X0Vqng.9F__Www1Psg_HjsweSQVzo2Bnrw";
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setGame(Game.playing("with mommy"));
        builder.setToken(token).addEventListener(new Event()).buildAsync();
        //builder.addEventListener(new Main());
    }
}
