package controller;

import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class PointController extends ListenerAdapter {
    public PointController() {
    }

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        //Add  points
    }

    @Override
    public void onMessageReactionRemove(@NotNull MessageReactionRemoveEvent event) {
        //Remove points
    }
}
