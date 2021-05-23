package Token.Fun;

import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.concurrent.TimeUnit;

public class Delay extends ListenerAdapter {

    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        Splitter splitter = new Splitter();
        String msg = event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg, 1);
        String other = splitter.Splitter(msg, 2);
        if (index.equalsIgnoreCase(Constants.BotPrefix + "delay")) {
            String time = splitter.Splitter(other, 1);
            String message = splitter.Splitter(other, 2);
            try {
                event.getChannel().sendMessage("sending message "+message+" in "+time+" seconds...").queue(e->{
                    e.delete().queueAfter(2,TimeUnit.SECONDS);
                    event.getMessage().delete().queueAfter(2,TimeUnit.SECONDS);
                });
                event.getChannel().sendMessage(message).queueAfter(Integer.parseInt(time), TimeUnit.SECONDS);
            } catch (IllegalArgumentException e) {
                event.getChannel().sendMessage("Err770: incorrect syntax || " + Constants.BotPrefix + "delay [seconds] [message]").queue();
            }
        }
    }

}
