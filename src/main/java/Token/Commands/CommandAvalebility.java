package Token.Commands;

import Token.Helper.Splitter;
import Token.MainThings.CommandAvalebilityMain;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class CommandAvalebility extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        Splitter splitter = new Splitter();
        CommandAvalebilityMain comAval = new CommandAvalebilityMain();

        String msg = event.getMessage().getContentRaw();
        if (msg.equals(Constants.BotPrefix + "comaval")) {

            embedBuilder.setDescription(comAval.toString());
            event.getChannel().sendMessage(embedBuilder.build()).queue();

        }
    }
}
