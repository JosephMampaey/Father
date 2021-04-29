import controller.CommandConntroller;
import controller.PointController;
import controller.ServerController;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import service.TokenReader;

import javax.security.auth.login.LoginException;
import java.io.FileNotFoundException;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {
        "model",
        "service"
})

@EnableJpaRepositories
@EntityScan(basePackages = "model")
public class Application extends SpringBootServletInitializer{
    public static void main(String[] args) throws LoginException, FileNotFoundException {
        SpringApplication.run(Application.class, args);

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
