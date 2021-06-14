package Token.Fun;

import Token.Helper.AccessControl;
import Token.MainThings.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Ping_bot extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String authID = event.getAuthor().getId();
        String msg = event.getMessage().getContentRaw();
        if (msg.equalsIgnoreCase("<@!804600135039713360>")) {
            event.getChannel().sendMessage("au am chemisas rato gamakvidze").queue();
        } else if (msg.equalsIgnoreCase("@everyone")) {
            event.getChannel().sendMessage("<:vibecheck:787006649281937438>").queue();
        } else if (msg.equalsIgnoreCase("<@!772892222428282920>")) {
            event.getChannel().sendMessage("softblues mimarte...").queue();
        } else if (msg.equalsIgnoreCase("<@!322398589936730112>") && !authID.equalsIgnoreCase("322398589936730112") && !authID.equalsIgnoreCase("804600135039713360")) {
            event.getChannel().sendMessage("ra ginda e").queue();
        } else if (msg.equalsIgnoreCase("<@!402499653419139072>") && !new AccessControl().AccessControl(authID)) {
            event.getChannel().sendMessage("https://tenor.com/view/flipping-off-flip-off-middle-finger-smile-happy-gif-4746862").queue();
        } else if (msg.equalsIgnoreCase("||penis||")) {
            event.getChannel().sendMessage("its a trap!").queue();
        } else if (msg.equalsIgnoreCase("<@!772892222428282920>")) {
            event.getChannel().sendMessage("hot aris ara?\n...\nyle abia").queue();
//        } else if (msg.equalsIgnoreCase("¯\\_(ツ)_/¯")) {
//            event.getChannel().sendMessage("<:senkobread:786969515539169280>").queue();
        } else if (msg.equalsIgnoreCase("<@!614171745187790924>")) {
            event.getChannel().sendMessage("https://tenor.com/view/sergio-perez-sergio-perez-checo-f1-gif-19466059").queue();
        } else if (msg.equalsIgnoreCase("cum")) {
            event.getChannel().sendMessage("<:flush:787006756210999366>").queue();
        } else if (msg.equalsIgnoreCase("hoda")) {
            event.getChannel().sendMessage("**H O D A**").queue();
        } else if (msg.equalsIgnoreCase("you are gay")) {
            event.getChannel().sendMessage("we know\n<:sadge:789149830014173204>").queue();
        } else if (msg.equalsIgnoreCase(Constants.BotPrefix + "spoki")) {
            event.getChannel().sendMessage("<:imWatching:754402799130902609>").queue();
        } else if (msg.equalsIgnoreCase(":sadge:")) {
            event.getChannel().sendMessage("<:sadge:789149830014173204>").queue();
        } else if (msg.equalsIgnoreCase(":sayoriSob:")) {
            event.getChannel().sendMessage("<:SayoriSob:802481273510821918>").queue();
        } else if (msg.equalsIgnoreCase(":pepeKek:")) {
            event.getChannel().sendMessage("<:pepegakek:780860308067188766>").queue();
        } else if (msg.equalsIgnoreCase(":kannaPog:")) {
            event.getChannel().sendMessage("<:kanna_pog:789156079677210705>").queue();
        } else if (msg.equalsIgnoreCase(":kannaSip:")) {
            event.getChannel().sendMessage("<:776870991133016124:799754968752062464>").queue();
        } else if (msg.equalsIgnoreCase(":kannaLove:")) {
            event.getChannel().sendMessage("<:781181016084971552:799752480292339765>").queue();
        } else if (msg.equalsIgnoreCase(":aeugh:")) {
            event.getChannel().sendMessage("<a:aeugh:833241046669721611>").queue();
        } else if (msg.equalsIgnoreCase(":satann:")) {
            event.getChannel().sendMessage("<a:Satan:805073376955465738>").queue();
        } else if (msg.equalsIgnoreCase(":sosage:")) {
            event.getChannel().sendMessage("<a:giphy10:833246332511846411>").queue();
        } else if (msg.equalsIgnoreCase("!ara")) {
            if (authID.equalsIgnoreCase("260466498068283393")) {
                event.getChannel().sendMessage("https://tenor.com/view/echidna-ara-ara-re-zero-gif-19959889").queue();
            } else if (authID.equalsIgnoreCase("811672489808625665")) {
                event.getChannel().sendMessage("lizi kai gogoa").queue();
            } else if (authID.equalsIgnoreCase("720283775560581192")) {
                event.getChannel().sendMessage("Ketta magari gogoa").queue();
            } else if (authID.equalsIgnoreCase("398893725842931722")) {
                event.getChannel().sendMessage("https://tenor.com/view/yuru-yuri-ayano-sugiura-yuruyuri-gif-16813669").queue();
            } else {
                event.getChannel().sendMessage("ara ara " + event.getAuthor().getName() + "-kun").queue();
            }
        } else if (msg.equalsIgnoreCase("!no")) {
            event.getChannel().sendMessage("<:vibecheck:787006649281937438>").queue();
        } else if (msg.equalsIgnoreCase(":omfg:")) {
            event.getChannel().sendMessage("<:775270688427868180:819871498181410817>").queue();
        } else if (msg.equalsIgnoreCase("rogor xar") || msg.equalsIgnoreCase("rogor xar?") || msg.equalsIgnoreCase("rogor xarr?")) {
            event.getChannel().sendMessage("Nichivooo").queue();
        } else if (msg.equalsIgnoreCase("movedi") || msg.equalsIgnoreCase("zd")) {
            if (authID.equalsIgnoreCase("823285493939699742") || authID.equalsIgnoreCase("837386035667009558") && authID.equalsIgnoreCase("841664239876964412")) {
                event.getChannel().sendMessage("https://tenor.com/view/cruella-emma-stone-flame-fire-gif-20410154").queue();
            } else if (authID.equalsIgnoreCase("772161064955019274")) {
                event.getChannel().sendMessage("vaime chemi shemqnmelis fani movidaa <:781181016084971552:799752480292339765>").queue();
            } else {
                event.getChannel().sendMessage("va zd").queue();
            }
        } else if (msg.equalsIgnoreCase("bacho")) {
            Random rng = new Random();
            if (rng.nextInt(101) % 3 == 0) {
                event.getChannel().sendMessage("<:TheBachoDrip:842288595334332426>").queue();
            } else {
                event.getChannel().sendMessage("<:bacho:834315747870244864>").queue();
            }
        } else if (msg.equalsIgnoreCase("testpilot69")) {
            event.getChannel().sendMessage("you have confirmed that you have 2 braincells").queue();
        } else if (msg.equalsIgnoreCase(":thonk:")) {
            event.getChannel().sendMessage("<:thonk:787007033286328320>").queue();
        } else if (msg.equalsIgnoreCase(":F:")) {
            event.getChannel().sendMessage("""
                    ⬛⬛⬛⬛⬛
                    ⬛⬜⬜⬜⬛
                    ⬛⬜⬛⬛⬛
                    ⬛⬜⬜⬛⬛
                    ⬛⬜⬛⬛⬛
                    ⬛⬜⬛⬛⬛
                    ⬛⬛⬛⬛⬛""").queue();
        } else if (msg.equalsIgnoreCase(":lmfao:")) {
            event.getChannel().sendMessage("<:lmfao:793468947293929512>").queue();
        } else if (msg.equalsIgnoreCase(":piso:")) {
            event.getChannel().sendMessage("<:ruth:818947888628891659>").queue();
        } else if (msg.equalsIgnoreCase("<:yle:833665582167359509>")) {
            event.getChannel().sendMessage("morchi ra yelshi amoxvedi bavshvo").queue();
        } else if (msg.equalsIgnoreCase("!ok")) {
            event.getChannel().sendMessage("<:y_:757516897758740480>").queue();
        } else if (msg.equalsIgnoreCase(":mad:")) {
            event.getChannel().sendMessage("<:mad:835957113607422042>").queue();
        } else if (msg.equalsIgnoreCase("acm") || msg.equalsIgnoreCase(":acm:")) {
            event.getChannel().sendMessage("<:madZUKA:835957113607422042>").queue();
        } else if (msg.equalsIgnoreCase("<@!810048628335968288>")) {
            event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/795409781589671966/834105027827990548/coverdab.png").queue();
        } else if (msg.equalsIgnoreCase("jaba")) {
            event.getChannel().sendMessage("<:mpuahh:830396524776521790>").queue();
        } else if (msg.equalsIgnoreCase("ping me")) {
            event.getChannel().sendMessage("<@!" + authID + ">").queue();
        } else if (msg.equalsIgnoreCase("debili")) {
            event.getChannel().sendMessage("<:mpuahh:830396524776521790>").queue();
        } else if (msg.equalsIgnoreCase(":die?:")) {
            event.getChannel().sendMessage("<:RAvQNA:830390521003245588>").queue();
        } else if (msg.equalsIgnoreCase("dark souls") && !event.getAuthor().getId().equalsIgnoreCase("700747192784125972")){
            event.getChannel().sendMessage("hello "+event.getAuthor().getAsMention()).queue();
        }
    }// ⬛⬜
}