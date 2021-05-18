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
import java.util.concurrent.TimeUnit;

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
                    if (loop > 0) {
                        System.out.println(loop);
                        event.getChannel().sendMessage(clear(channel)).queue(e -> {
                            e.delete().queueAfter(2600, TimeUnit.MILLISECONDS);
                        });
                    } else {
                        event.getChannel().sendMessage("argument must be at least 1").queue();
                    }
                }
            } catch (NumberFormatException e) {
                event.getChannel().sendMessage("the argument must be a number").queue();
            }
        }
    }

    public MessageEmbed clear(TextChannel channel) {
        try {
            List<Message> messages = channel.getHistory().retrievePast(loop).complete();
            messages.removeIf(m -> false);
            channel.deleteMessages(messages).complete();

            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Removing Messages");
            eb.setDescription("i have deleted " + loop + " messages");
            eb.setColor(new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255)));
            loop = 0;
            return eb.build();
        } catch (IllegalArgumentException e) {
            channel.sendMessage("Err184:Message retrieval limit is between 1 and 100 messages. No more, no less.").queue();
        }
        return null;
    }
}


//Sample Code : https://gist.github.com/RezzedUp/09c99f33e7a311f9d6682b38d6afd846