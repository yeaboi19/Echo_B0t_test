package Token.Fun;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class RandomCmd extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        Random rng = new Random();
        String msg = event.getMessage().getContentRaw();
        if(msg.equalsIgnoreCase(Constants.BotPrefix+"rng")){
            event.getChannel().sendMessage(Integer.toString(rng.nextInt())).queue();
        }
    }
}
