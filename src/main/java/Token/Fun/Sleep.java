package Token.Fun;

import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Sleep extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String msg=event.getMessage().getContentRaw();
        Splitter splitter = new Splitter();
        if(splitter.Splitter(msg,1).equalsIgnoreCase(Constants.BotPrefix+"sleep")){
            String[] splited = splitter.Splitter(msg,2).split(" ");
            boolean is_tru1=true;
            boolean is_tru2=true;
            int add=0;
            int age=Integer.parseInt(splited[1]);
            if(age<=10){
                add=10;
            }else if(age>10 && age<=15){
                add=8;
            }else if(age>15 && age<=18){
                add=7;
            }else if(age>18){
                add=5;
            }else {
                event.getChannel().sendMessage("naxui age").queue();
                is_tru1=false;
            }
            if (Integer.parseInt(splited[0])>0){
                is_tru2=false;
                event.getChannel().sendMessage("naxui slep time").queue();
            }
            if(is_tru1 && is_tru2){
                int sleep=add+Integer.parseInt(splited[0])-12;
                if(sleep<0){
                    sleep+=12;
                }
                event.getChannel().sendMessage("you will slep "+sleep+"hr").queue();
            }
        }
    }
}
