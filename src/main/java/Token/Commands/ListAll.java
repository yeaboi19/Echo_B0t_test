package Token.Commands;

import Token.Helper.AccessControl;
import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ListAll extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        Splitter splitter = new Splitter();
        String msg = event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg, 1);
        String other = splitter.Splitter(msg, 2);
        List<Member> memberList = event.getGuild().getMembers();
        AccessControl accessControl = new AccessControl();
        try {
            if (accessControl.AccessControl(event.getAuthor().getId()) || accessControl.AccessRoleControl(event.getMember().getRoles()) || accessControl.zukasGuildId.equalsIgnoreCase(event.getGuild().getId())) {

                if (msg.equalsIgnoreCase(Constants.BotPrefix + "listAll")) {
                    String mainMessage = "";
                    for (int i = 0; i < memberList.size(); i++) {
                        mainMessage += "----------------------------------\n" +
                                "ID -" + memberList.get(i).getId() + "\n" +
                                "Nickname -" + memberList.get(i).getEffectiveName() + "\n" +
                                "Name -" + memberList.get(i).getUser().getName() + "\n" +
                                "Is Bot -" + memberList.get(i).getUser().isBot() + "\n" +
                                "User Tag -" + memberList.get(i).getUser().getAsTag() + "\n" +
                                "Time Joined -" + memberList.get(i).getTimeJoined().toString() + "\n----------------------------------";
                        if (i % 5 == 0 && i != 0) {
                            event.getChannel().sendMessage(mainMessage).queue();
                            mainMessage = "";
                        }
                    }
                    if (!mainMessage.isEmpty()) {
                        event.getChannel().sendMessage(mainMessage).queue();
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("ProBot is shitting itself again");
        }
        if (index.equalsIgnoreCase(Constants.BotPrefix + "ListUsr")) {
            System.out.println("listUser Start!");
            String userId = "";
            if (other.indexOf('<') != -1) {
                for (int i = 3; i < other.length() - 2; i++) {
                    userId += other.charAt(i);
                }
            }
            System.out.println(userId);
            for (int i = 0; i < memberList.size(); i++) {
                if (memberList.get(i).getId().equalsIgnoreCase(userId)) {
                    event.getChannel().sendMessage("----------------------------------\n" +
                            "ID -" + memberList.get(i).getId() + "\n" +
                            "Nickname -" + memberList.get(i).getEffectiveName() + "\n" +
                            "Name -" + memberList.get(i).getUser().getName() + "\n" +
                            "Is Bot -" + memberList.get(i).getUser().isBot() + "\n" +
                            "User Tag -" + memberList.get(i).getUser().getAsTag() + "\n" +
                            "Time Joined -" + memberList.get(i).getTimeJoined() + "\n----------------------------------").queue();
                }
            }
        }
    }
}