package Token.Fun;

import Token.Helper.AccessControl;
import Token.Helper.FileIO;
import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Words extends ListenerAdapter {
    FileIO fileIO = new FileIO();
    Splitter splitter = new Splitter();
    AccessControl ac = new AccessControl();
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String msg=event.getMessage().getContentRaw();
        String index=splitter.Splitter(msg,1);
        String other=splitter.Splitter(msg,2);

        if(fileIO.isInList(msg)){
            fileIO.addWords(msg);
        }
        if (msg.equalsIgnoreCase(Constants.BotPrefix + "getWordList")) {
            EmbedBuilder eb = new EmbedBuilder();
            HashMap<String, Integer> wordList = fileIO.getWordList();
            String wordStringList = "";
            for (String key : wordList.keySet()) {
                wordStringList += key + " - " + wordList.get(key) + "\n";
            }
            eb.setTitle("WordList");
            eb.setDescription(wordStringList);
            event.getChannel().sendMessage(eb.build()).queue();
        }
        if(ac.AccessControl(event.getAuthor().getId())) {
             if (index.equalsIgnoreCase(Constants.BotPrefix + "setNewWord")) {
                int errCode = -1;
                if (!other.contains(" ")) {
                    errCode = fileIO.setWords(other);
                }
                if (errCode == -1) {
                    event.getChannel().sendMessage("the word must not contain spaces").queue();
                } else if (errCode == 0) {
                    event.getChannel().sendMessage("the word is already in the list").queue();
                } else {
                    event.getChannel().sendMessage("successfully added the word").queue();
                }
            } else if (index.equalsIgnoreCase(Constants.BotPrefix + "removeWord")) {
                int errCode = -1;
                if (!other.contains(" ")) {
                    errCode = fileIO.removeFullWord(other);

                }
                if (errCode == -1) {
                    event.getChannel().sendMessage("the word must not contain spaces").queue();
                }else if(errCode==0){
                    event.getChannel().sendMessage("the word is not in the list").queue();
                }else{
                    event.getChannel().sendMessage("successfully removed the word").queue();
                }
            }
        }
    }
}
