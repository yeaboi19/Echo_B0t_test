package Token.Commands;

import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class PrivateMessages extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        Splitter splitter = new Splitter();
        String msg = event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg,1);
        String other = splitter.Splitter(msg,2);
        if(index.equalsIgnoreCase(Constants.BotPrefix+"pm")){

        }
    }
}
