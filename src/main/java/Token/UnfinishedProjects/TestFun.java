package Token.UnfinishedProjects;

import Token.Commands.RoleStuff;
import Token.Helper.AccessControl;
import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.IPermissionHolder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestFun extends ListenerAdapter {
    Splitter splitter = new Splitter();
    AccessControl ac = new AccessControl();
    String roleId;
    private IPermissionHolder IPermissionHolder;

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        try {
            RoleStuff rs = new RoleStuff();
            String msg = event.getMessage().getContentRaw();
            String index = splitter.Splitter(msg, 1);
            String other = splitter.Splitter(msg, 2);
            if (event.getGuild().getRolesByName("Muted", true).size() == 0) {
                event.getGuild().createRole().setPermissions(Permission.UNKNOWN).setName("Muted").setColor(new Color(255, 255, 255)).queue();
            }


            if (ac.AccessControl(event.getAuthor().getId())) {
                if (index.equalsIgnoreCase(Constants.BotPrefix + "mute")) {
                    List<GuildChannel> channelList = event.getGuild().getChannels();
                    IPermissionHolder = event.getGuild().getRolesByName("Muted", false).get(0);
                    ArrayList<Permission> allowed = new ArrayList<>();
                    ArrayList<Permission> denied = new ArrayList<>();
                    allowed.add(Permission.MESSAGE_READ);
                    denied.add(Permission.MESSAGE_WRITE);
                    for (int i = 0; i < channelList.size(); i++) {
                        channelList.get(i).getManager().putPermissionOverride(IPermissionHolder, allowed, denied).queue();
                    }
                }
            }
        } catch (IllegalStateException e) {
            e.getMessage();
        }

    }

    @Override
    public void onRoleCreate(@NotNull RoleCreateEvent event) {
        roleId = event.getRole().getId();
    }

    public boolean roleExists(List<Role> roles, String roleId) {
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getId().equalsIgnoreCase(roleId)) {
                return true;
            }
        }
        return false;
    }
}

    /*FileIO fileIO = new FileIO();
    Splitter splitter = new Splitter();
    AccessControl ac = new AccessControl();
    Random rng = new Random();
    Boolean isActivated = false;
    Boolean finished = false;
    int loop = 0;
    int looped = 0;

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg, 1);
        String other = splitter.Splitter(msg, 2);
        if (ac.AccessControl(event.getAuthor().getId())) {
            try {
                if (index.equalsIgnoreCase(Constants.BotPrefix + "kc")) {
                    loop = Integer.parseInt(other) - 1;
                    if (loop > 0) {
                        event.getMessage().delete().queue();
                        isActivated = true;
                    } else {
                        event.getChannel().sendMessage("argument must be at least 1").queue();
                    }
                }
            } catch (NumberFormatException e) {
                event.getChannel().sendMessage("the argument must be a number").queue();
            }
        }
    }

    @Override
    public void onMessageDelete(@NotNull MessageDeleteEvent event) {
        if (loop == looped) {
            isActivated = false;
            looped = 0;
            finished = true;
        }
        if (isActivated) {
            event.getChannel().getHistory().retrievePast(loop)
                    .map(messages -> messages.get(0))
                    .queue(message -> {
                        message.delete().queue();
                    });
            looped++;
        }
        if (finished) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Removing Messages");
            loop++;
            eb.setDescription("i have deleted " + loop + " messages");
            loop = 0;
            finished = false;
            eb.setColor(new Color(rng.nextInt(255),rng.nextInt(255),rng.nextInt(255)));
            event.getChannel().sendMessage(eb.build()).queue();
        }
    }*/
/*Random rng = new Random();
            User user = event.getAuthor();
            int rand = rng.nextInt(100);
            int rand2= rng.nextInt(100);
            long time = System.currentTimeMillis();
            event.getChannel().sendMessage("High low time :DDD\nThe hint is "+rand).queue(n->{
                if(n.getAuthor()==user) {
                    if(System.currentTimeMillis()-time<=3000) {
                        if (userInput.equalsIgnoreCase("high")) {
                            if (rand > rand2) {
                                return "nice one, you win";
                            } else {
                                return "nah man, try another time";
                            }
                        } else if (userInput.equalsIgnoreCase("low")) {
                            if (rand < rand2) {
                                return "nice one, you win";
                            } else {
                                return "nah man, try another time";
                            }
                        } else if (userInput.equalsIgnoreCase("jackpot")) {
                            if (rand == rand2) {
                                return "nice one, you win";
                            } else {
                                return "nah man, try another time";
                            }
                        } else {
                            return "nah man, try another time";
                        }
                    }else{
                        n.getChannel().sendMessage("out of time").queue();
                    }
                }
            });
        }*/
//            event.getMessage().addReaction("\uD83C\uDDF8").queue();
//            event.getMessage().addReaction("\uD83C\uDDFA").queue();
//            event.getMessage().addReaction("\uD83C\uDDE8").queue();
//
//            event.getMessage().addReaction("\uD83D\uDE2B").queue();
//
//            event.getMessage().addReaction("\uD83C\uDDF2").queue();
//            event.getMessage().addReaction("\uD83C\uDDFE").queue();
//
//            event.getMessage().addReaction("\uD83D\uDE29").queue();
//
//            event.getMessage().addReaction("\uD83C\uDDE9").queue();
//            event.getMessage().addReaction("\uD83C\uDDEE").queue();
//            event.getMessage().addReaction("\uD83C\uDDF0").queue();
//
//            event.getMessage().addReaction("\uD83C\uDF46").queue();
//
//            event.getMessage().addReaction("\uD83D\uDCA6").queue();
/*
        MessageChannel channel = event.getChannel();
        long time = System.currentTimeMillis();
        channel.sendMessage("Ping").queue(response->{
            response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
        });
        event.getChannel().sendMessage("anal").queue();
       */
