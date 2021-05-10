package Token.Fun;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class RussianRoulette extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        Random rng = new Random();
        String msg = event.getMessage().getContentRaw();
        if(msg.equalsIgnoreCase(Constants.BotPrefix+"rusRoul")){
            if(rng.nextInt(60)/10== rng.nextInt(6)){
                event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/764770346800250913/837221092526653460/koki.mp4").queue();
            }else{
                event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/795409781589671966/835056512250150962/koki.mp4").queue();
            }
        }
    }
}
