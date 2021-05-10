package Token.Fun;

import Token.Helper.AccessControl;
import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Rename extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        Splitter splitter = new Splitter();
        AccessControl accessControl = new AccessControl();
        String msg=event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg,1);
        String other = splitter.Splitter(msg,2);

        if(index.equalsIgnoreCase(Constants.BotPrefix+"renameAll")&& accessControl.AccessControl(event.getAuthor().getId())){
            System.out.println("RENAME");
            Guild guild = event.getGuild();
            Member self = guild.getSelfMember();
            if(other.equalsIgnoreCase("clear")){
                for (Member member : guild.getMembers()) {
                    String name = member.getEffectiveName(); // username or nickname
                    if (!name.startsWith("[NNN]") && self.canInteract(member)) {
                        member.modifyNickname(null).queue();
                    }
                }
            }else{
                for (Member member : guild.getMembers()) {
                    String name = member.getEffectiveName(); // username or nickname
                    if (!name.startsWith("[NNN]") && self.canInteract(member)) {
                        member.modifyNickname(other).queue();
                    }
                }
            }
        }else if(index.equalsIgnoreCase(Constants.BotPrefix+"rename")&& accessControl.AccessControl(event.getAuthor().getId())){
            if(other.equalsIgnoreCase("")){
                event.getChannel().sendMessage("e!rename <userId/UserTag> <new nick>").queue();
            }else{
                String user=splitter.Splitter(msg,1);
                String nick=splitter.Splitter(msg,2);

                Guild guild = event.getGuild();
                Member self = guild.getSelfMember();
                for (Member member : guild.getMembers()) {
                    if (self.canInteract(member)) {
                        System.out.println(member.getId().equalsIgnoreCase(user));
                        System.out.println(member.getAsMention().equalsIgnoreCase(user));
                        if(member.getAsMention().equalsIgnoreCase(user) || member.getId().equalsIgnoreCase(user))
                            member.modifyNickname(other).queue();
                        break;
                    }
                }
            }
        }



//        if(msg.equalsIgnoreCase(Constants.BotPrefix+"rename")){
//            Guild guild = event.getGuild();
//            Member self = guild.getSelfMember();
//            for (Member member : guild.getMembers()) {
//                String name = member.getEffectiveName(); // username or nickname
//                if (!name.startsWith("[NNN]") && self.canInteract(member)) {
//                    member.modifyNickname("tina").queue();
//                }
//            }
//        }
    }
}
