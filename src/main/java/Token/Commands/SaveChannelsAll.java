package Token.Commands;

import Token.Helper.AccessControl;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SaveChannelsAll extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        if (msg.equalsIgnoreCase(Constants.BotPrefix + "saveChannels") && new AccessControl().AccessControl(event.getAuthor().getId())) {
            List<GuildChannel> channelList = event.getGuild().getChannels();

        }
    }
}
