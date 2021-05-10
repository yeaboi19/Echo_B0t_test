package Token.Commands;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Ping extends ListenerAdapter {
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String msg1 = event.getMessage().getContentRaw();
        if (msg1.equalsIgnoreCase(Constants.BotPrefix + "ping")) {

            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage("Wait...")
                    .queue(response-> {
                        response.editMessageFormat("Ping: %d ms", System.currentTimeMillis() - time).queue();
                    });


        }


//            event.getChannel().sendMessage("yes,im up").queue();
//            event.reply("Ping: ...",
//                    (m) -> { long ping = event.getMessage().getTimeCreated().until(m.getTimeCreated(), ChronoUnit.MILLIS);
//                    m.editMessage("Ping: " + ping + "ms | Websocket: " + event.getJDA().getGatewayPing() + "ms").queue(); });

//            long ping = event.getMessage().getTimeCreated().until(event.getMessage().getTimeCreated(),ChronoUnit.MILLIS);
//            event.getChannel().sendMessage("Ping: "+ping).queue();

//            event.getChannel().sendMessage(
//                (@Nonnull GuildMessageReceivedEvent m) ->{
//                long ping1 = event.getMessage().getTimeCreated().until(m.getMessage().getTimeCreated(),ChronoUnit.MILLIS);
//                m.getChannel().sendMessage("ping : "+ping1);
//            })

//            String words = event.getMessage().getContentRaw().substring(5);
//
//            Message msg = event.getMessage();
//            Member target = msg.getMember();
//
//            assert target != null;
//            event.getChannel().sendMessage("__***WARN :***__\n**DATE:** " + msg.getTimeCreated()).queue();
//            event.getChannel().sendMessage("**Message:** " + words + "\n**Warned from:** " + target.getUser().getAsTag()).queue();

//    }
//    public Ping() {
//        this.name = "ping";
//        this.help = "checks the bot's latency";
//        this.guildOnly = false;
//        this.aliases = new String[]{"pong"};
//    }
//
//    protected void execute(CommandEvent event) {
//        event.reply("Ping: ...", (m) -> {
//            long ping = event.getMessage().getTimeCreated().until(m.getTimeCreated(), ChronoUnit.MILLIS);
//            m.editMessage("Ping: " + ping + "ms | Websocket: " + event.getJDA().getGatewayPing() + "ms").queue();
//        });
//    }
    }
}
