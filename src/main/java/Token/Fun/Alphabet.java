package Token.Fun;

import Token.Helper.AccessControl;
import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Alphabet extends ListenerAdapter {
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        Splitter splitter = new Splitter();
        AccessControl accessControl = new AccessControl();

        String msg = event.getMessage().getContentRaw();
        try {
            if (accessControl.AccessControl(event.getAuthor().getId()) || accessControl.AccessRoleControl(event.getMember().getRoles()) || accessControl.zukasGuildId.equalsIgnoreCase(event.getGuild().getId())) {
                if (msg.equalsIgnoreCase(Constants.BotPrefix + "iDumb")) {
                    event.getChannel().sendMessage("a").queue();
                    event.getChannel().sendMessage("b").queue();
                    event.getChannel().sendMessage("c").queue();
                    event.getChannel().sendMessage("d").queue();
                    event.getChannel().sendMessage("e").queue();
                    event.getChannel().sendMessage("f").queue();
                    event.getChannel().sendMessage("g").queue();
                    event.getChannel().sendMessage("h").queue();
                    event.getChannel().sendMessage("i").queue();
                    event.getChannel().sendMessage("j").queue();
                    event.getChannel().sendMessage("k").queue();
                    event.getChannel().sendMessage("l").queue();
                    event.getChannel().sendMessage("m").queue();
                    event.getChannel().sendMessage("n").queue();
                    event.getChannel().sendMessage("o").queue();
                    event.getChannel().sendMessage("p").queue();
                    event.getChannel().sendMessage("q").queue();
                    event.getChannel().sendMessage("r").queue();
                    event.getChannel().sendMessage("s").queue();
                    event.getChannel().sendMessage("t").queue();
                    event.getChannel().sendMessage("u").queue();
                    event.getChannel().sendMessage("v").queue();
                    event.getChannel().sendMessage("w").queue();
                    event.getChannel().sendMessage("x").queue();
                    event.getChannel().sendMessage("y").queue();
                    event.getChannel().sendMessage("z").queue();
                }
            }
        }catch (NullPointerException e){
            System.out.println("ProBot is shitting itself again");
        }
    }
}
// !1class