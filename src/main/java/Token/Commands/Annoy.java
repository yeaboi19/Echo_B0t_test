package Token.Commands;

import Token.Helper.AccessControl;
import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Annoy extends ListenerAdapter {

    public boolean wbB(String AuthorId) {
        String idBot = "804600135039713360";
        boolean writtenByBot = false;
        if (idBot.equalsIgnoreCase(AuthorId)) {
            writtenByBot = true;
        }
        return writtenByBot;
    }

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        Splitter splitter = new Splitter();
        EmbedBuilder embedBuilder = new EmbedBuilder();
        AccessControl accessControl = new AccessControl();

        String msg = event.getMessage().getContentRaw();

        String index = splitter.Splitter(msg, 1);
        String other = splitter.Splitter(msg, 2);
        if (index.equalsIgnoreCase(Constants.BotPrefix + "ann")) {
            if (accessControl.AccessControl(event.getAuthor().getId())) {
                if (!wbB(event.getAuthor().getId()) && !event.getAuthor().isBot()) {
                    embedBuilder.setDescription("Not enough info to spam...\n" +
                            "Correct Syntax :\n" +
                            "!ann <number> <message>");
                    event.getChannel().sendMessage(embedBuilder.build()).queue();
                } else if (index.equalsIgnoreCase(Constants.BotPrefix + "ann")) {

                    String loop = splitter.Splitter(other, 1);
                    String messageSp = splitter.Splitter(other, 2);

                    int TEMP = Integer.parseInt(loop);
                    for (int i = 0; i < TEMP; i++) {

                        event.getChannel().sendMessage(messageSp).queue();

                    }
                }
            } else {
                event.getChannel().sendMessage("Can't execute command...\nplease contact softblue for more info...").queue();
            }
        }
    }
}