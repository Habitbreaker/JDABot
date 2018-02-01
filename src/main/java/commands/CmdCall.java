package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;



public class CmdCall implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        StringBuilder msg = new StringBuilder();
        for (String arg : args) {
            msg.append(":telephone_receiver: :upside_down: ");
            msg.append(arg);
        }
        event.getTextChannel().sendMessage(msg.toString()).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
