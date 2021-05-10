package Token.UnfinishedProjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class TestCmm extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        /*String msg = event.getMessage().getContentRaw();
        if(msg.equalsIgnoreCase(Constants.BotPrefix+"test")){
            event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/795409781589671966/834105027827990548/coverdab.png").queue();
        }*/
    }
}