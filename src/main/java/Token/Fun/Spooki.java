package Token.Fun;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Spooki extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String msg=event.getMessage().getContentRaw();
        if(msg.equals(Constants.BotPrefix+"spoki")){
//            event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/764770346800250913/809484301233553478/image0.png").queue();
        }
    }
}
