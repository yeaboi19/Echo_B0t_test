package Token.Commands;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Invite extends ListenerAdapter {
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        if (msg.equalsIgnoreCase(Constants.BotPrefix + "inv")) {
//            event.getChannel().sendMessage("https://discord.gg/8kMC5jUXej").queue();
            event.getChannel().sendMessage("https://discord.com/api/oauth2/authorize?client_id=804600135039713360&permissions=8&scope=bot").queue();
        }
    }
}
