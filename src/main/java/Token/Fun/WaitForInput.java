package Token.Fun;

import Token.Helper.AccessControl;
import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class WaitForInput extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        Splitter splitter = new Splitter();
        AccessControl ac = new AccessControl();
        String msg = event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg, 1);
        String other = splitter.Splitter(msg, 2);
        if(index.equalsIgnoreCase(Constants.BotPrefix+"wpi")){
            if(ac.AccessControl(event.getAuthor().getId())){
                event.getChannel().sendMessage("type \"ass\"").queue();
            }
        }
    }
}
