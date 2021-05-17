package Token.Commands.LavaPlayer.NormalCommands;

import Token.Helper.AccessControl;
import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;
import org.jetbrains.annotations.NotNull;

public class Join extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        AccessControl ac = new AccessControl();
        Splitter splitter = new Splitter();
        String msg = event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg, 1);
        String other = splitter.Splitter(msg, 2);
        if (index.equalsIgnoreCase(Constants.BotPrefix + "join")) {
            if (ac.AccessControl(event.getAuthor().getId())) {
                TextChannel channel = event.getChannel();
                Member self = event.getMember().getGuild().getSelfMember();
                GuildVoiceState selfVoiceState = self.getVoiceState();
                if (selfVoiceState.inVoiceChannel()) {
                    channel.sendMessage("Im already in VC").queue();
                    return;
                }

                Member member = event.getMember();
                GuildVoiceState memberVoiceState = member.getVoiceState();
                if (!memberVoiceState.inVoiceChannel()) {
                    channel.sendMessage("You are not in VC").queue();
                    return;
                }

                AudioManager audioManager = event.getGuild().getAudioManager();
                VoiceChannel memberChannel = memberVoiceState.getChannel();

                audioManager.openAudioConnection(memberChannel);
                channel.sendMessage("Connected to " + memberChannel.getName()).queue();
            }
        }
    }
}
