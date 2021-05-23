package Token.Commands;

import Token.Helper.AccessControl;
import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Mute extends ListenerAdapter {
    Splitter splitter = new Splitter();
    AccessControl ac = new AccessControl();
    RoleStuff rs = new RoleStuff();
    String msg;
    String index;
    String other;
    MessageChannel channel;
    private net.dv8tion.jda.api.entities.IPermissionHolder IPermissionHolder;
    boolean isRoleBeingCreated=false;

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        msg = event.getMessage().getContentRaw();
        index = splitter.Splitter(msg, 1);
        other = splitter.Splitter(msg, 2);
        channel = event.getChannel();

        if (index.equalsIgnoreCase(Constants.BotPrefix + "mute")) {
            if (ac.AccessControl(event.getAuthor().getId())) {
                if (event.getGuild().getRolesByName("Muted", true).size() == 0) {
                    isRoleBeingCreated=true;
                    event.getGuild().createRole().setPermissions(Permission.UNKNOWN).setName("Muted").setColor(new Color(255, 255, 255)).queue();
                } else {
                    try {
                        java.util.List<GuildChannel> channelList = event.getGuild().getChannels();
                        IPermissionHolder = event.getGuild().getRolesByName("Muted", false).get(0);
                        Role role = (Role) IPermissionHolder;
                        ArrayList<Permission> allowed = new ArrayList<>();
                        ArrayList<Permission> denied = new ArrayList<>();
                        allowed.add(Permission.MESSAGE_READ);
                        denied.add(Permission.MESSAGE_WRITE);
                        for (int i = 0; i < channelList.size(); i++) {
                            channelList.get(i).getManager().putPermissionOverride(IPermissionHolder, allowed, denied).queue();
                        }
                        event.getGuild().addRoleToMember(other, role).queue();
                        channel.sendMessage("Muted " + event.getGuild().getMemberById(other).getUser().getAsTag()).queue();
                    } catch (NullPointerException | NumberFormatException e) {
                        event.getChannel().sendMessage("Err1526:The specified ID is not a valid snowflake.").queue();
                    }
                }
            } else {
                event.getChannel().sendMessage("This command is in testing phase \nplease contact softblue for more info...").queue();
            }
        } else if (index.equalsIgnoreCase(Constants.BotPrefix + "unmute")) {
            if (ac.AccessControl(event.getAuthor().getId())) {
                try {
                    java.util.List<Role> userRole = event.getGuild().getMemberById(other).getRoles();
                    for (int i = 0; i < userRole.size(); i++) {
                        if (userRole.get(i).getName().equals("Muted")) {
                            event.getGuild().removeRoleFromMember(other, userRole.get(i)).queue();
                            event.getChannel().sendMessage("Successfully Unmuted " + event.getGuild().getMemberById(other).getUser().getAsTag()).queue();
                            return;
                        }
                    }
                    event.getChannel().sendMessage("Err435:User Does not have \"Muted\" role!").queue();
                } catch (NullPointerException | NumberFormatException e) {
                    event.getChannel().sendMessage("Err1526:The specified ID is not a valid snowflake.").queue();
                }
            } else {
                event.getChannel().sendMessage("This command is in testing phase \nplease contact softblue for more info...").queue();
            }
        }
    }

    @Override
    public void onRoleCreate(@NotNull RoleCreateEvent event) {
        if(isRoleBeingCreated) {
            List<GuildChannel> channelList = event.getGuild().getChannels();
            IPermissionHolder = event.getGuild().getRolesByName("Muted", false).get(0);
            Role role = (Role) IPermissionHolder;
            ArrayList<Permission> allowed = new ArrayList<>();
            ArrayList<Permission> denied = new ArrayList<>();
            allowed.add(Permission.MESSAGE_READ);
            denied.add(Permission.MESSAGE_WRITE);
            for (int i = 0; i < channelList.size(); i++) {
                channelList.get(i).getManager().putPermissionOverride(IPermissionHolder, allowed, denied).queue();
            }
            event.getGuild().addRoleToMember(other, role).queue();
            channel.sendMessage("Created Role Muted and ").queue();
            channel.sendMessage("Muted " + event.getGuild().getMemberById(other).getUser().getAsTag()).queue();
        }
    }
}
//351814