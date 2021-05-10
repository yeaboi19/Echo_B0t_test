package Token.Helper;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class See extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        Splitter splitter = new Splitter();

        String s_msg = splitter.Splitter(msg, 1);
        String other = splitter.Splitter(msg, 2);
        String author = event.getAuthor().getName();
        String server = event.getGuild().getName();
        String channel = event.getChannel().getName();

        if (!other.equalsIgnoreCase("")) {
            System.out.println(author + ": " + s_msg + ", " + other + " |" + server + " - " + channel + "|");
        } else {
            System.out.println(author + ": " + s_msg + " |" + server + " - " + channel + "|");
        }
    }
}

