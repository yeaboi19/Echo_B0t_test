package Token.Commands;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Joke extends ListenerAdapter {
    String[] jokeArr = new String[10];


    public void fillArr() {
        jokeArr[1] = "y=mx+b jokes are fine, but..\n" +
                "At some point, we'll have to draw the line";
        jokeArr[2] = "I'm reading a horror book in braille.\n" +
                "Something bad is going to happen. I can feel it.";
        jokeArr[3] = "didi traki";
        jokeArr[4] = "An 18 yr old died during a driving test.\n" +
                "They passed anyway";
        jokeArr[5] = "traki";
        jokeArr[6] = "I recently wrote a paper about erotic photography of plants\n" +
                "It's a photo-sin-thesis";
        jokeArr[7] = "What do you call an old snow man?\n" +
                "Water";
        jokeArr[8] = "chichikia shedis saxinkleshi, 99 xinkali mindao \n" +
                "mimtani idzaxis barem 100 aixe sheni xori dedaco ";
        jokeArr[9] = "traki";
        jokeArr[0] = "shedarebit upro didi traki";
    }


    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {

        Random rng = new Random();
        EmbedBuilder embedBuilder = new EmbedBuilder();
        String msg = event.getMessage().getContentRaw();
        fillArr();
        int indexJoke = rng.nextInt(jokeArr.length);
        if (msg.equalsIgnoreCase(Constants.BotPrefix + "joke")) {
            String TEMP = jokeArr[indexJoke];
            embedBuilder.setDescription(TEMP);
            event.getChannel().sendMessage(embedBuilder.build()).queue();


        }
    }
}
/*

if(msg.equalsIgnoreCase(Constants.BotPrefix+"joke")){
            event.getChannel().sendMessage("you will see a big fat ass joke in the mirror").queue();
        }



 */