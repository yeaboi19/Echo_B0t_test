package Token.MainThings;


//import Token.UnfinishedProjects.NewDepTest;

import Token.Commands.*;
import Token.Fun.*;
import Token.Helper.Console_input;
import Token.Helper.See;
import Token.Helper.User_info;
import Token.UnfinishedProjects.Calculator;
import Token.UnfinishedProjects.Secret;
import Token.UnfinishedProjects.TestFun;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA Echo_Bot = JDABuilder.createDefault(Secret.token).setChunkingFilter(ChunkingFilter.ALL).setMemberCachePolicy(MemberCachePolicy.ALL).enableIntents(GatewayIntent.GUILD_MEMBERS)
                .setActivity(Activity.playing("with " + Constants.BotPrefix + "help"))
                .addEventListeners(
                        new Ping(), new Rename(), new HighLow(), new RoleStuff(),
                        new RussianRoulette(), new TestFun(), new GuildGets(), new ListAll(),
                        new Pp(), new RandomUserChoice(), new Ping_bot(), new Echo(), new Help(),
                        new Annoy(), new Joke(), new User_info(), new CommandAvalebility(),
                        new Invite(), new Dont(), new Alphabet(), new Console_input(),
                        new Calculator(), new See(), new Words(), new KillerQueen()
                )
                .build().awaitReady();

    }
}