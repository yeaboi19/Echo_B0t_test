package Token.Commands.LavaPlayer.NormalCommands;

import Token.Commands.LavaPlayer.PlayerManager;
import Token.Helper.AccessControl;
import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Play extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        AccessControl ac = new AccessControl();
        Splitter splitter = new Splitter();
        String msg = event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg, 1);
        String other = splitter.Splitter(msg, 2);
        if (index.equalsIgnoreCase(Constants.BotPrefix + "play")) {
            if (ac.AccessControl(event.getAuthor().getId())) {
                TextChannel channel = event.getChannel();
                Member self = event.getMember().getGuild().getSelfMember();
                GuildVoiceState selfVoiceState = self.getVoiceState();
                if (!selfVoiceState.inVoiceChannel()) {
                    channel.sendMessage("execute command " + Constants.BotPrefix + "join first").queue();
                    return;
                }
                Member member = event.getMember();
                GuildVoiceState memberVoiceState = member.getVoiceState();
                if (!memberVoiceState.inVoiceChannel()) {
                    channel.sendMessage("You are not in VC").queue();
                    return;
                }

                if (!memberVoiceState.getChannel().equals(selfVoiceState.getChannel())) {
                    channel.sendMessage("bot and user must be in a same VC").queue();
                    return;
                }

                PlayerManager.getINSTANCE().loadAndPlay(channel, other);
            }
        }
    }
}
