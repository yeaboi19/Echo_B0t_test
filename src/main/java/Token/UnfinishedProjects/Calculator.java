package Token.UnfinishedProjects;

import Token.Helper.AccessControl;
import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Calculator extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        AccessControl accessControl = new AccessControl();
        Splitter splitter = new Splitter();
        String msg = event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg,1);
        String other = splitter.Splitter(msg,2);
        boolean cont = accessControl.AccessControl(event.getAuthor().getId());
        if(cont){
            if(index.equalsIgnoreCase(Constants.BotPrefix+"calc")){
                int num1=Integer.parseInt(splitter.Splitter(other,1));
                int num2=Integer.parseInt(splitter.Splitter(other,3));
                String expr=splitter.Splitter(other,2);
                if(expr.equalsIgnoreCase("*")){
                    event.getChannel().sendMessage(Integer.toString(num1*num2)).queue();
                }else if(expr.equalsIgnoreCase("-")){
                    event.getChannel().sendMessage(Integer.toString(num1-num2)).queue();
                }else if(expr.equalsIgnoreCase("/")){
                    event.getChannel().sendMessage(Integer.toString(num1/num2)).queue();
                }else if(expr.equalsIgnoreCase("+")){
                    event.getChannel().sendMessage(Integer.toString(num1+num2)).queue();
                }
            }
        }
    }
}
