package Token.Commands;

import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Echo extends ListenerAdapter {
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        Splitter splitter = new Splitter();

        String msg = event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg, 1);
        String other = splitter.Splitter(msg, 2);

        if (index.equalsIgnoreCase(Constants.BotPrefix)) {
            event.getChannel().sendMessage(other).queue();
        }

    }
}
