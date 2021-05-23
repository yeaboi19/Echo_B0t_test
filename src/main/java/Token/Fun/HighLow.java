package Token.Fun;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Random;

public class HighLow extends ListenerAdapter {
    EmbedBuilder eb = new EmbedBuilder();
    Random rng = new Random();
    Message messageMain;
    Color colorRandom = new Color(rng.nextInt(255),rng.nextInt(255),rng.nextInt(255));
    long messageId;
    String UserId;
    int hint=0;

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        hint = rng.nextInt(100);
        if (msg.equalsIgnoreCase(Constants.BotPrefix+"HL") || msg.equalsIgnoreCase("HighLow")) {
            eb.setTitle("Welcome to highLow...");
            eb.setDescription("the hint is " + hint);
            
            eb.setColor(colorRandom);
            event.getChannel().sendMessage(eb.build()).queue((message) -> {
                messageMain = message;
                messageId = message.getIdLong();
                UserId = message.getAuthor().getId();
                message.addReaction("\uD83D\uDC46").queue(); //point up
                message.addReaction("\uD83D\uDC47").queue(); //point down
                message.addReaction("\uD83E\uDD18").queue(); //metal
            });
        }
    }

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        int answer;

        if (event.getMessageId().equalsIgnoreCase(String.valueOf(messageId)) && !event.getMember().getId().equalsIgnoreCase("804600135039713360")) {
            String reactCode = event.getReaction().getReactionEmote().getAsReactionCode();

            answer=rng.nextInt(100);
            if (reactCode.equalsIgnoreCase("\uD83D\uDC46")) {
                reactCode = "high";
                if (hint < answer) {
                    eb.setTitle("nice one, you win");
                } else {
                    eb.setTitle("nah man, try another time");
                }
                
                eb.setDescription("the \"number\" was "+answer);
                eb.setColor(colorRandom);
                event.getChannel().sendMessage(eb.build()).queue();
            } else if (reactCode.equalsIgnoreCase("\uD83D\uDC47")) {
                reactCode = "low";
                if (hint > answer) {
                    eb.setTitle("nice one, you win");
                } else {
                    eb.setTitle("nah man, try another time");
                }
                
                eb.setDescription("the \"number\" was "+answer);
                eb.setColor(colorRandom);
                event.getChannel().sendMessage(eb.build()).queue();
            } else if (reactCode.equalsIgnoreCase("\uD83E\uDD18")) {
                reactCode = "jackpot";
                if (hint == answer) {
                    eb.setTitle("nice one, you win");
                } else {
                    eb.setTitle("nah man, try another time");
                }
                
                eb.setDescription("the \"number\" was "+answer);
                eb.setColor(colorRandom);
                event.getChannel().sendMessage(eb.build()).queue();
            }
            messageMain.removeReaction("\uD83D\uDC46").queue();
            messageMain.removeReaction("\uD83D\uDC47").queue();
            messageMain.removeReaction("\uD83E\uDD18").queue();
            messageId=0;
            UserId="";
            hint=0;
        }
    }
}
