package Token.Fun;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Pp extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
//        EmbedBuilder embedBuilder = new EmbedBuilder();
//        String msg = event.getMessage().getContentRaw();
//        Splitter splitter = new Splitter();
//        AccessControl accessControl = new AccessControl();
//
//        if (accessControl.AccessControl(event.getAuthor().getId()) || accessControl.AccessRoleControl(event.getMember().getRoles()) || accessControl.zukasGuildId.equalsIgnoreCase(event.getGuild().getId())) {
//            if (splitter.Splitter(msg, 1).equalsIgnoreCase("!pp")) {
////            embedBuilder.setTitle("poo");
////            embedBuilder.setDescription("<@!322398589936730112>");
////            embedBuilder.setFooter("pee");
//                event.getChannel().sendMessage("> ...............…………………………._¸„„„„_\n" +
//                        "…………………….…………...„--~*'¯…….'\\\n" +
//                        "………….…………………… („-~~--„¸_….,/ì'Ì\n" +
//                        "…….…………………….¸„-^\"¯ : : : : :¸-¯\"¯/'\n" +
//                        "……………………¸„„-^\"¯ : : : : : : : '\\¸„„,-\"\n" +
//                        "**¯¯¯'^^~-„„„----~^*'\"¯ : : : : : : : : : :¸-\"\n" +
//                        ".:.:.:.:.„-^\" : : : : : : : : : : : : : : : : :„-\"\n" +
//                        ":.:.:.:.:.:.:.:.:.:.: : : : : : : : : : ¸„-^¯\n" +
//                        ".::.:.:.:.:.:.:.:. : : : : : : : ¸„„-^¯\n" +
//                        ":.' : : '\\ : : : : : : : ;¸„„-~\"\n" +
//                        ":.:.:: :\"-„\"\"***/*'ì¸'¯\n" +
//                        ":.': : : : :\"-„ : : :\"\\\n" +
//                        ".:.:.: : : : :\" : : : : \\,\n" +
//                        ":.: : : : : : : : : : : : 'Ì\n" +
//                        ": : : : : : :, : : : : : :/\n" +
//                        "\"-„_::::_„-*__„„~\"").queue();
////            event.getChannel().sendMessage(embedBuilder.build()).queue();
//            }
//        }
        Random rng = new Random();
        String msg = event.getMessage().getContentRaw();
        if (msg.equalsIgnoreCase(Constants.BotPrefix + "pp") && event.getAuthor().getId().equalsIgnoreCase("322398589936730112")) {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Your penis size is...");
            embedBuilder.setDescription("8====================D");
            embedBuilder.setFooter("pee");
            event.getChannel().sendMessage(embedBuilder.build()).queue();
        } else if (msg.equalsIgnoreCase(Constants.BotPrefix + "pp")) {
            int ppLength = rng.nextInt(15);
            ppLength++;
            String output = "8";
            for (int i = 0; i < ppLength; i++) {
                output += "=";
            }
            output += "D";
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Your penis size is...");
            embedBuilder.setDescription(output);
            embedBuilder.setFooter("pee");
            event.getChannel().sendMessage(embedBuilder.build()).queue();
        }
    }
}