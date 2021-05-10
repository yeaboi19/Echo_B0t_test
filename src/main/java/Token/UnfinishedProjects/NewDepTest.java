package Token.UnfinishedProjects;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.jagrosh.jdautilities.examples.command.PingCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.concurrent.TimeUnit;

public class NewDepTest extends Command {
    private final EventWaiter waiter;
    public NewDepTest(EventWaiter waiter)
    {
        this.waiter = waiter;
        this.name = "hello";
        this.aliases = new String[]{"hi"};
        this.help = "says hello and waits for a response";
    }

    @Override
    protected void execute(CommandEvent event)
    {
        // ask what the user's name is
        event.reply("Hello. What is your name?");

        // wait for a response
        waiter.waitForEvent(MessageReceivedEvent.class,
                // make sure it's by the same user, and in the same channel, and for safety, a different message
                e -> e.getAuthor().equals(event.getAuthor())
                        && e.getChannel().equals(event.getChannel())
                        && !e.getMessage().equals(event.getMessage()),
                // respond, inserting the name they listed into the response
                e -> event.reply("Hello, `"+e.getMessage().getContentRaw()+"`! I'm `"+e.getJDA().getSelfUser().getName()+"`!"),
                // if the user takes more than a 15 sec, time out
                15, TimeUnit.SECONDS, () -> event.reply("Sorry, you took too long."));
    }
}

