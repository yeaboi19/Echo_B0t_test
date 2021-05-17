package Token.UnfinishedProjects;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class TestCmm extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().equalsIgnoreCase("waifu mome")){
            for(int i=0;i<8;i++){
                event.getChannel().sendMessage("$waifu").queue();
            }
        }
    }
}