package Token.Fun;

import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUserChoice extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        Random rng = new Random();
        Splitter splitter = new Splitter();
        String msg = event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg, 1);
        String other = splitter.Splitter(msg, 2);
        if (index.equalsIgnoreCase(Constants.BotPrefix + "randUsr")) {
            if (splitter.Splitter(other, 1).equalsIgnoreCase("all")) {
                List<Member> serverMemberList = event.getGuild().getMembers();
                ArrayList<String> userIdList = new ArrayList<>();
                for (int i = 0; i < serverMemberList.size(); i++) {
                    userIdList.add(serverMemberList.get(i).getId());
                }
                System.out.println(userIdList.size());
                String out = userIdList.get(rng.nextInt(userIdList.size()));
                out = "<@" + out + ">";
                event.getChannel().sendMessage(out).queue();
            } else if (splitter.Splitter(other, 1).equalsIgnoreCase("exc")) {
                boolean stop = false;
                while (!stop) {
                    String[] excList = splitter.Splitter(other, 2).split(" ");
                    List<Member> serverMemberList = event.getGuild().getMembers();
                    ArrayList<String> userIdList = new ArrayList<>();
                    for (int i = 0; i < serverMemberList.size(); i++) {
                        userIdList.add(serverMemberList.get(i).getId());
                    }
                    int randUser = rng.nextInt(userIdList.size());
                    boolean cool = false;
                    for (int i = 0; i < excList.length; i++) {
                        if (excList[i].equalsIgnoreCase(userIdList.get(randUser))) {
                            cool = false;
                        } else {
                            cool = true;
                        }
                    }
                    if (cool) {
                        String out = userIdList.get(randUser);
                        out = "<@" + out + ">";
                        event.getChannel().sendMessage(out).queue();
                        stop = true;
                        break;
                    }
                }
            } else {
                String[] userList = other.split(" ");
                String out = userList[rng.nextInt(userList.length)];
                out = "<@" + out + ">";
                event.getChannel().sendMessage(out).queue();
            }
        }
    }
}
