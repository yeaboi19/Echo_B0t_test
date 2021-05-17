package Token.Fun;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class GifTest extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        if (msg.equalsIgnoreCase(Constants.BotPrefix + "EmojiTst")) {
            for (int i = 0; ; i++) {
                event.getChannel().sendMessage("https://cdn.discordapp.com/emojis/756785948070641666.gif?v=1&size=" + i * 5).queue();
            }
        }
    }
}
