package Token.MainThings;


//import Token.UnfinishedProjects.NewDepTest;

import Token.Commands.*;
import Token.Commands.LavaPlayer.NormalCommands.Join;
import Token.Commands.LavaPlayer.NormalCommands.Leave;
import Token.Commands.LavaPlayer.NormalCommands.Play;
import Token.Fun.*;
import Token.Helper.Console_input;
import Token.Helper.See;
import Token.Helper.User_info;
import Token.UnfinishedProjects.Calculator;
import Token.UnfinishedProjects.TestFun;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA Echo_Bot = JDABuilder.createDefault(Secret.token).setChunkingFilter(ChunkingFilter.ALL).setMemberCachePolicy(MemberCachePolicy.ALL).enableIntents(GatewayIntent.GUILD_MEMBERS)
                .setActivity(Activity.streaming(Constants.BotPrefix + "help", "https://youtu.be/dQw4w9WgXcQ"))
                .addEventListeners(
                        new Ping(), new Rename(), new HighLow(), new RoleStuff(),
                        new RussianRoulette(), new GuildGets(), new ListAll(),
                        new Pp(), new RandomUserChoice(), new Ping_bot(), new Echo(), new Help(),
                        new Annoy(), new Joke(), new User_info(), new CommandAvalebility(),
                        new Invite(), new Dont(), new Alphabet(), new Console_input(),
                        new Calculator(), new See(), new Words(), new KillerQueen(),
                        new PrivateMessages(), new Delay(), new GifTest(),new Mute(),
                        new TestFun(),new Play(),new Join(),new Leave()
                ).enableCache(CacheFlag.VOICE_STATE)
                .build().awaitReady();

    }
}