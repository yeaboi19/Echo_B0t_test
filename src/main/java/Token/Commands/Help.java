package Token.Commands;

import Token.Helper.Splitter;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Help extends ListenerAdapter {
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        Splitter splitter = new Splitter();


        String msg = event.getMessage().getContentRaw();
        String index = splitter.Splitter(msg, 1);
        String other = splitter.Splitter(msg, 2);

        if (msg.equals(Constants.BotPrefix + "help")) {

            embedBuilder.setTitle("All Commands... ");
            embedBuilder.setDescription("" +
                    "" +
                    "Echo_B0t commands:\n" +
                    "---------------------------\n" +
                    ""+Constants.BotPrefix+"help - type this if you need som help\n" +
                    ""+Constants.BotPrefix+"ping - it checks if bot is online idk\n" +
                    ""+Constants.BotPrefix+"echo [message] - repeats the message\n" +
                    ""+Constants.BotPrefix+"inv - makes invite to my test server\n" +
                    ""+Constants.BotPrefix+"ann [int] [message] - sends messages int- number of times\n" +
                    ""+Constants.BotPrefix+"joke - joke\n" +
                    ""+Constants.BotPrefix+"sleep [int] - i really dont know what is...\n" +
                    ""+Constants.BotPrefix+"pp - just type it\n" +
                    ""+Constants.BotPrefix+"dont - dont\n" +
                    ""+Constants.BotPrefix+"iDumb - just types alphabet\n" +
                    ""+Constants.BotPrefix+"listAll - lists all users/bots public info\n" +
                    ""+Constants.BotPrefix+"listUsr [@mention] - lists users/bots public info\n");

            embedBuilder.setFooter("skidaadle skodoodle ur penis is now a noodle");
            event.getChannel().sendMessage(embedBuilder.build()).queue();
        }
        if (index.equalsIgnoreCase(Constants.BotPrefix + "help") && other.equalsIgnoreCase("emoji")) {
            embedBuilder.setTitle("Emoji help");
            embedBuilder.setDescription("""
                    @ everyone - <:vibecheck:787006649281937438>
                    cum - <:flush:787006756210999366>
                    :sadge: - <:sadge:789149830014173204>
                    :sayoriSob: - <:SayoriSob:802481273510821918>
                    :pepeKek: - <:pepegakek:780860308067188766>
                    :kannaPog: - <:kanna_pog:789156079677210705>
                    :kannaSip: - <:776870991133016124:799754968752062464>
                    :kannaLove: - <:781181016084971552:799752480292339765>
                    :aeugh: - <a:aeugh:833241046669721611>
                    :satann: - <a:Satan:805073376955465738>
                    :sosage: - <a:giphy10:833246332511846411>
                    :omfg: - <:775270688427868180:819871498181410817>
                    :bacho: - <:bacho:834315747870244864>
                    :thonk: - <:thonk:787007033286328320>
                    :F: - F
                    :lmfao: - <:lmfao:793468947293929512>
                    """);
            event.getChannel().sendMessage(embedBuilder.build()).queue();
        }
    }
}
