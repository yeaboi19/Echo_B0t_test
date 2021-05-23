package Token.Commands;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.Random;

public class Help extends ListenerAdapter {
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        if(msg.equalsIgnoreCase(Constants.BotPrefix+"help")){
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Commands...");
            eb.setDescription("""
                    < > - important; [ ] - optional
                    eb!help - sends this embed
                    eb! <message> - repeats the message
                    eb!ann <number> <message> - repeats the message "number" of times
                    eb!delay <number> <message> - sends "message" in "number" of seconds
                    eb!invite - sends an invite
                    eb!joke - sends handwritten joke
                    eb!kc <number> - deletes latest "number" messages
                    eb!listAll - sends all of public info about all of the guilds users
                    eb!mute <id> - mutes the user
                    eb!ping - ping
                    eb!pm <message> - sends a message in pm
                    eb!pmTo <id> message - sends a message to user
                    eb!iDumb - sends alphabet
                    eb!HL/eb!HighLow - the game
                    eb!pp - measures your pp ( ͡° ͜ʖ ͡°)
                    eb!randusr [all] - pings random user from guild
                    eb!rename <id> <nickname> - renames user
                    eb!renameAll <nickname> - renames all of guilds users
                    eb!rusRoul - try it
                    eb!getWordList - gets word list
                    eb!setNewWord <word> - sets new "word"
                    eb!removeWord <word> - removes "word"
                    """);
            eb.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
            event.getChannel().sendMessage(eb.build()).queue();
        }
    }
}