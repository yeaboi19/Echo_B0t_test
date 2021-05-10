package Token.Helper;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.entities.UserById;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.OffsetDateTime;
import java.util.Locale;
import java.util.Random;

public class User_info extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        Splitter splitter = new Splitter();
        Random rng = new Random();
        String msg= event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg,1);
        String other = splitter.Splitter(msg,2);
        if(index.equalsIgnoreCase(Constants.BotPrefix+"embed")) {
            if(!other.contains("<@") && !other.contains(">")){
                Member mem =event.getGuild().getMemberById(event.getAuthor().getId());
                OffsetDateTime boostTime = mem.getTimeBoosted();
                if(boostTime!=null){
                    embedBuilder.setDescription("Time Created - "+mem.getTimeCreated().getYear()+" "+mem.getTimeCreated().getMonth().toString().toLowerCase()+" "+mem.getTimeCreated().getDayOfMonth()+
                            "\nTime Joined -"+mem.getTimeJoined().getYear()+" "+mem.getTimeJoined().getMonth().toString().toLowerCase()+" "+mem.getTimeJoined().getDayOfMonth()+
                            "\nTime Boosted -"+mem.getTimeBoosted().getYear()+" "+mem.getTimeBoosted().getMonth().toString().toLowerCase()+" "+mem.getTimeBoosted().getDayOfMonth());
                }else{
                    embedBuilder.setDescription("Time Created - "+mem.getTimeCreated().getYear()+" "+mem.getTimeCreated().getMonth().toString().toLowerCase()+" "+mem.getTimeCreated().getDayOfMonth()+
                            "\nTime Joined -"+mem.getTimeJoined().getYear()+" "+mem.getTimeJoined().getMonth().toString().toLowerCase()+" "+mem.getTimeJoined().getDayOfMonth()+
                            "\nTime Boosted -NULL");
                }
                embedBuilder.setTitle(event.getAuthor().getName());
                embedBuilder.setColor(new Color(rng.nextInt(255),rng.nextInt(255),rng.nextInt(255)));
                embedBuilder.setThumbnail(event.getAuthor().getAvatarUrl());
                embedBuilder.setFooter(event.getAuthor().getAsTag());
                event.getChannel().sendMessage(embedBuilder.build()).queue();
            }else{
                String id="";
                for (int i = 3; i < other.length()-1; i++) {
                    id += other.charAt(i);
                }
                Member mem =event.getGuild().getMemberById(id);
                OffsetDateTime boostTime = mem.getTimeBoosted();
                if(boostTime!=null){
                    embedBuilder.setDescription("Time Created - "+mem.getTimeCreated().getYear()+" "+mem.getTimeCreated().getMonth().toString().toLowerCase()+" "+mem.getTimeCreated().getDayOfMonth()+
                            "\nTime Joined -"+mem.getTimeJoined().getYear()+" "+mem.getTimeJoined().getMonth().toString().toLowerCase()+" "+mem.getTimeJoined().getDayOfMonth()+
                            "\nTime Boosted -"+mem.getTimeBoosted().getYear()+" "+mem.getTimeBoosted().getMonth().toString().toLowerCase()+" "+mem.getTimeBoosted().getDayOfMonth());
                }else{
                    embedBuilder.setDescription("Time Created - "+mem.getTimeCreated().getYear()+" "+mem.getTimeCreated().getMonth().toString().toLowerCase()+" "+mem.getTimeCreated().getDayOfMonth()+
                            "\nTime Joined -"+mem.getTimeJoined().getYear()+" "+mem.getTimeJoined().getMonth().toString().toLowerCase()+" "+mem.getTimeJoined().getDayOfMonth()+
                            "\nTime Boosted -NULL");
                }
                embedBuilder.setTitle(mem.getEffectiveName());
                embedBuilder.setColor(new Color(rng.nextInt(255),rng.nextInt(255),rng.nextInt(255)));
                embedBuilder.setThumbnail(mem.getUser().getAvatarUrl());
                embedBuilder.setFooter(mem.getUser().getAsTag());
                event.getChannel().sendMessage(embedBuilder.build()).queue();
            }
        }
    }
}
