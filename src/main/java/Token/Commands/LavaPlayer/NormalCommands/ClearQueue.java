package Token.Commands.LavaPlayer.NormalCommands;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ClearQueue extends ListenerAdapter {
//    @Override
//    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
//        AccessControl ac = new AccessControl();
//        Splitter splitter = new Splitter();
//        String msg = event.getMessage().getContentRaw();
//        String index = splitter.Splitter(msg, 1);
//        String other = splitter.Splitter(msg, 2);
//        if (index.equalsIgnoreCase(Constants.BotPrefix + "clearQueue")) {
//            if (ac.AccessControl(event.getAuthor().getId())) {
//                TextChannel channel = event.getChannel();
//                Member self = event.getMember().getGuild().getSelfMember();
//                GuildVoiceState selfVoiceState = self.getVoiceState();
//
//                Member member = event.getMember();
//                GuildVoiceState memberVoiceState = member.getVoiceState();
//                if (!memberVoiceState.inVoiceChannel()) {
//                    channel.sendMessage("You are not in VC").queue();
//                    return;
//                }
//
//                AudioManager audioManager = event.getGuild().getAudioManager();
//                VoiceChannel memberChannel = memberVoiceState.getChannel();
//
//                audioManager.openAudioConnection(memberChannel);
//                channel.sendMessage("Connected to " + memberChannel.getName()).queue();
//            }
//        }
//    }
}
