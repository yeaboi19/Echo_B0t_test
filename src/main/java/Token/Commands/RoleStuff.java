package Token.Commands;

import Token.Helper.AccessControl;
import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.HierarchyException;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;

public class RoleStuff extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        Splitter splitter = new Splitter();
        AccessControl ac = new AccessControl();
        String msgId = event.getMessage().getId();
        String authId = event.getAuthor().getId();
        String msg = event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg, 1);
        String other = splitter.Splitter(msg, 2);

        if (index.equalsIgnoreCase(Constants.BotPrefix + "RoleCreate")) {
            if (ac.AccessControl(authId)) {
                String name = splitter.Splitter(other, 1);
                String prem = splitter.Splitter(other, 2);
                try {
                    Permission permissions;
                    if (prem.equalsIgnoreCase("ADM") || prem.equalsIgnoreCase("ADMIN")) {
                        permissions = Permission.ADMINISTRATOR;
                    } else if (prem.equalsIgnoreCase("EMP") || prem.equalsIgnoreCase("EMPTY")) {
                        permissions = Permission.UNKNOWN;
                    } else {
                        permissions = Permission.UNKNOWN;
                    }
                    event.getGuild().createRole().setPermissions(permissions).setName(name).setColor(new Color(1, 1, 1, 1)).queue();
                    List<net.dv8tion.jda.api.entities.Role> roles = event.getGuild().getRolesByName(name, false);
                    event.getChannel().sendMessage("Done!").queue();
                    event.getChannel().deleteMessageById(msgId).queue();
                } catch (HierarchyException e) {
                    event.getChannel().sendMessage("Err1474:Can't modify a role with higher or equal highest role than myself!").queue();
                } catch (InsufficientPermissionException e) {
                    event.getChannel().sendMessage("Err1462:Cannot perform action due to a lack of Permission. Missing permission: MANAGE_ROLES").queue();
                } catch (NumberFormatException e) {
                    event.getChannel().sendMessage("Err1526:The specified ID is not a valid snowflake.").queue();
                }
            } else {
                event.getChannel().sendMessage("Err1355:Not enough Permissions!\nAsk softBlue#2732 for more info...").queue();
            }
        }

        if (index.equalsIgnoreCase(Constants.BotPrefix + "RoleGive")) {
            if (ac.AccessControl(authId)) {
                List<net.dv8tion.jda.api.entities.Role> roles = event.getGuild().getRolesByName(other, false);
                try {
                    if (roles.size() != 0) {
                        event.getGuild().addRoleToMember(authId, roles.get(0)).queue();
                        event.getChannel().sendMessage("I gave role named " + roles.get(0).getName() + " to user " + event.getAuthor().getAsTag()).queue();
                    } else {
                        Role role = event.getGuild().getRoleById(other);
                        assert role != null;
                        event.getGuild().addRoleToMember(authId, role).queue();
                        event.getChannel().sendMessage("I gave role named " + role.getName() + " to user " + event.getAuthor().getAsTag()).queue();
                    }
                } catch (HierarchyException e) {
                    event.getChannel().sendMessage("Err1474:Can't modify a role with higher or equal highest role than myself!").queue();
                } catch (InsufficientPermissionException e) {
                    event.getChannel().sendMessage("Err1462:Cannot perform action due to a lack of Permission. Missing permission: MANAGE_ROLES").queue();
                } catch (NumberFormatException e) {
                    event.getChannel().sendMessage("Err1526:The specified ID is not a valid snowflake.").queue();
                }
            } else {
                event.getChannel().sendMessage("Err1355:Not enough Permissions!\nAsk softBlue#2732 for more info...").queue();
            }
        }

        if (index.equalsIgnoreCase(Constants.BotPrefix + "RoleGiveTo")) {
            if (ac.AccessControl(authId)) {
                String roleNam = splitter.Splitter(other, 1);
                String userId = splitter.Splitter(other, 2);
                Member user = event.getGuild().retrieveMemberById(userId).complete();
                List<net.dv8tion.jda.api.entities.Role> roles = event.getGuild().getRolesByName(other, true);
                if (roles.size() != 0 && !other.contains(" ")) {
                    assert user != null;
                    event.getGuild().addRoleToMember(user, roles.get(0)).queue();
                    event.getChannel().sendMessage("I gave role named " + roles.get(0).getName() + " to user " + user.getEffectiveName()).queue();
                } else {
                    try {
                        Role role = event.getGuild().getRoleById(roleNam);
                        assert role != null;
                        event.getGuild().addRoleToMember(user, role).queue();
                        event.getChannel().sendMessage("I gave role named " + role.getName() + " to user " + user.getEffectiveName()).queue();
                    } catch (HierarchyException e) {
                        event.getChannel().sendMessage("Err1474:Can't modify a role with higher or equal highest role than myself!").queue();
                    } catch (InsufficientPermissionException e) {
                        event.getChannel().sendMessage("Err1462:Cannot perform action due to a lack of Permission. Missing permission: MANAGE_ROLES").queue();
                    } catch (NumberFormatException e) {
                        event.getChannel().sendMessage("Err1526:The specified ID is not a valid snowflake.").queue();
                    }
                }
            } else {
                event.getChannel().sendMessage("Err1355:Not enough Permissions!\nAsk softBlue#2732 for more info...").queue();
            }
        }

        if (index.equalsIgnoreCase(Constants.BotPrefix + "RoleRemoveFrom")) {
            if (ac.AccessControl(authId)) {
                String roleNam = splitter.Splitter(other, 1);
                String userId = splitter.Splitter(other, 2);
                Member user = event.getGuild().retrieveMemberById(userId).complete();
                List<net.dv8tion.jda.api.entities.Role> roles = event.getGuild().getRolesByName(other, true);
                if (roles.size() != 0 && !other.contains(" ")) {
                    assert user != null;
                    event.getGuild().removeRoleFromMember(user, roles.get(0)).queue();
                    event.getChannel().sendMessage("I removed role named " + roles.get(0).getName() + " from user " + user.getEffectiveName()).queue();
                } else {
                    try {
                        Role role = event.getGuild().getRoleById(roleNam);
                        assert role != null;
                        assert user != null;
                        event.getGuild().removeRoleFromMember(user, role).queue();
                        event.getChannel().sendMessage("I removed role named " + role.getName() + " from user " + user.getEffectiveName()).queue();
                    } catch (HierarchyException e) {
                        event.getChannel().sendMessage("Err1474:Can't modify a role with higher or equal highest role than myself!").queue();
                    } catch (InsufficientPermissionException e) {
                        event.getChannel().sendMessage("Err1462:Cannot perform action due to a lack of Permission. Missing permission: MANAGE_ROLES").queue();
                    } catch (NumberFormatException e) {
                        event.getChannel().sendMessage("Err1526:The specified ID is not a valid snowflake.").queue();
                    } catch (Exception e) {
                        event.getChannel().sendMessage(e.getMessage()).queue();
                    }
                }
            } else {
                event.getChannel().sendMessage("Err1355:Not enough Permissions!\nAsk softBlue#2732 for more info...").queue();
            }
        }
        if (index.equalsIgnoreCase(Constants.BotPrefix + "getRoleList")) {
            if (ac.AccessControl(authId)) {
                List<Role> roles = event.getGuild().getRoles();
                StringBuilder outputMessage = new StringBuilder();
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("Role List");
                for (int i = 0; i < roles.size(); i++) {
                    outputMessage.append("Name: ").append(roles.get(i).getName()).append(" Id: ").append(roles.get(i).getId()).append("\n");
                }
                eb.setDescription(outputMessage);
                event.getChannel().sendMessage(eb.build()).queue();


            }


        }
    }
}
