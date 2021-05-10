package Token.Helper;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Console_input extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        Scanner input = new Scanner(System.in);
        Splitter splitter = new Splitter();
        AccessControl accessControl = new AccessControl();

        String msg = event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg, 1);
        String other = splitter.Splitter(msg, 2);
        try {
            if (accessControl.AccessControl(event.getAuthor().getId()) || accessControl.AccessRoleControl(event.getMember().getRoles()) || accessControl.zukasGuildId.equalsIgnoreCase(event.getGuild().getId())) {
                if (index.equalsIgnoreCase(Constants.BotPrefix + "emer") && other.equalsIgnoreCase(Constants.BotPrefix + "2005")) {
                    String IO = input.nextLine();
                    event.getChannel().sendMessage(IO).queue();
                } else if (index.equalsIgnoreCase(Constants.BotPrefix + "emer")) {
                    System.out.println("i need pass bruh\n!emer <pass>");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("ProBot is shitting itself again");
        }
    }
}
