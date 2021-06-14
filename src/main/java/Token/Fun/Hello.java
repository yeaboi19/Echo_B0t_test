package Token.Fun;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Hello extends ListenerAdapter {
    Boolean answered = false;
    Boolean hasStarted = false;
    User user;
    TextChannel channel;
    Guild guild;

    public boolean allEquals(User user, TextChannel channel, Guild guild, GuildMessageReceivedEvent event) {
        if (!user.getId().equals(event.getAuthor().getId())) return false;
        if (!channel.getId().equals(event.getChannel().getId())) return false;
        return guild.getId().equals(event.getGuild().getId());
    }
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        if (msg.equalsIgnoreCase(Constants.BotPrefix + "hello")) {
            hasStarted = true;
            user = event.getAuthor();
            channel = event.getChannel();
            guild = event.getGuild();
            event.getChannel().sendMessage("hi what's your name?").queue(e -> {
//                if(answered){
//                    return;
//                }
//                event.getChannel().sendMessage("время истекло").queueAfter(7400, TimeUnit.MILLISECONDS, message -> {
//                    event.getChannel().sendMessage("https://tenor.com/view/john-wick-burning-burn-it-down-john-wick-chapter2-everything-is-fine-gif-12959515").queue();
//                    hasStarted = false;
//                    user = null;
//                    channel = null;
//                    guild = null;
//                });
            });
            return;
        }
        if (user != null && channel != null && guild != null && !event.getAuthor().isBot()) {
            if (allEquals(user, channel, guild, event) && hasStarted && msg.length() < 2000) {
                event.getChannel().sendMessage("Hi " + msg).queue();
                hasStarted = false;
                answered = true;
                user = null;
                channel = null;
                guild = null;
            }
        }
    }
}
