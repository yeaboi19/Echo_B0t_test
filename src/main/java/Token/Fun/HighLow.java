package Token.Fun;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class HighLow extends ListenerAdapter {
    Random rng = new Random();
    long messageId;
    String UserId;
    int hint;

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {

        String msg = event.getMessage().getContentRaw();
        if (msg.equalsIgnoreCase("HL")) {
            event.getChannel().sendMessage("Welcome to highlow...\nthe hint is " + rng.nextInt(100)).queue((message) -> {
                messageId = message.getIdLong();
                UserId = message.getAuthor().getId();
                message.addReaction("\uD83D\uDC46").queue();
                message.addReaction("\uD83D\uDC47").queue();
                message.addReaction("\uD83E\uDD18").queue();
            });
        }
    }

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {

        if (event.getMessageId().equalsIgnoreCase(String.valueOf(messageId)) && !event.getMember().getId().equalsIgnoreCase("804600135039713360")) {
            String reactCode = event.getReaction().getReactionEmote().getAsReactionCode();

            event.getChannel().retrieveMessageById(messageId).queue(message -> {
                String[] temp = message.getContentRaw().split(" ");
                hint = Integer.parseInt(temp[temp.length - 1]);
            });


            if (reactCode.equalsIgnoreCase("\uD83D\uDC46")) {
                reactCode = "high";
                if (hint > rng.nextInt(100)) {
                    event.getChannel().sendMessage("nice one, you win").queue();
                } else {
                    event.getChannel().sendMessage("nah man, try another time").queue();
                }
            } else if (reactCode.equalsIgnoreCase("\uD83D\uDC47")) {
                reactCode = "low";
                if (hint < rng.nextInt(100)) {
                    event.getChannel().sendMessage("nice one, you win").queue();
                } else {
                    event.getChannel().sendMessage("nah man, try another time").queue();
                }
            } else if (reactCode.equalsIgnoreCase("\uD83E\uDD18")) {
                reactCode = "jackpot";
                if (hint == rng.nextInt(100)) {
                    event.getChannel().sendMessage("nice one, you win").queue();
                } else {
                    event.getChannel().sendMessage("nah man, try another time").queue();
                }
            }
            event.getChannel().removeReactionById(messageId,"\uD83D\uDC46").queue();
            event.getChannel().removeReactionById(messageId,"\uD83D\uDC47").queue();
            event.getChannel().removeReactionById(messageId,"\uD83E\uDD18").queue();
            messageId=0;
            UserId="";
            hint=0;
        }
    }
}
