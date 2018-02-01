package listeners;

import core.CommandHandler;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

import java.util.Objects;

public class CommandListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getMessage().getContentDisplay().startsWith(STATIC.getPREFIX()) && !Objects.equals(event.getMessage().getAuthor().getId(), event.getJDA().getSelfUser().getId())) {
            CommandHandler.handleCommand(CommandHandler.parser.parse(event.getMessage().getContentRaw(), event));

        }

    }
}
