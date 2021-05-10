package Token.Fun;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.utils.config.AuthorizationConfig;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Random;

public class Stupid extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        int millis = now.get(ChronoField.MILLI_OF_SECOND); // Note: no direct getter available.


        Random rng = new Random();
        if(event.getMessage().getContentRaw().equalsIgnoreCase(Constants.BotPrefix+"dateTest")){
            Guild guild = event.getGuild();
            Member self = guild.getSelfMember();
            for (Member member : guild.getMembers()) {
                String name = member.getEffectiveName();
                if (!name.startsWith("echo") && !member.isOwner()) {
                    member.modifyNickname("\u200E"+name).queue();
                }
            }
            event.getChannel().sendMessage(year+" "+month+" "+day+" "+hour+" "+minute+" "+second+" "+millis).queue();
        }
    }
}
