package Token.Commands;

import Token.Helper.AccessControl;
import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class KillerQueen extends ListenerAdapter {
    Random rng = new Random();
    Splitter splitter = new Splitter();
    AccessControl ac = new AccessControl();
    int loop = 0;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        TextChannel channel = event.getTextChannel();
        String msg = event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg, 1);
        String other = splitter.Splitter(msg, 2);
        if (ac.AccessControl(event.getAuthor().getId())) {
            try {
                if (index.equalsIgnoreCase(Constants.BotPrefix + "kc")) {
                    loop = Integer.parseInt(other);

                    event.getChannel().sendMessage(clear(channel)).queue();

                }
            } catch (NumberFormatException e) {
                event.getChannel().sendMessage("the argument must be a number").queue();
            }
        }
    }

    public MessageEmbed clear(TextChannel channel) {
        EmbedBuilder eb = new EmbedBuilder();
        try {
            List<Message> messages = channel.getHistory().retrievePast(loop).complete();

            messages.removeIf(m -> false);
            channel.deleteMessages(messages).complete();

            eb.setTitle("Removing Messages");
            eb.setDescription("i have deleted " + loop + " messages");
            eb.setColor(new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255)));
            loop = 0;
            return eb.build();
        } catch (IllegalArgumentException e) {

        }
        eb.setTitle("Error");
        eb.setDescription("Err405:Must provide at least 2 or at most 100 messages to be deleted.");
        eb.setColor(new Color(255, 0, 0));
        return eb.build();
    }
}

//Sample Code : https://gist.github.com/RezzedUp/09c99f33e7a311f9d6682b38d6afd846