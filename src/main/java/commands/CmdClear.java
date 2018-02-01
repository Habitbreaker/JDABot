package commands;

import embeds.EmbedError;
import embeds.EmbedSuccess;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class CmdClear implements Command{

    private int getInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(event.getAuthor().getId().equals("249171508247789570")) {
            return false;
        } else {
            event.getChannel().sendMessage(new EmbedError("You have no permissions to run this command!").getEmbed()).queue();
            return true;
        }
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        int numb = getInt(args[0]);

        if (args.length < 1) {
            event.getTextChannel().sendMessage(
                new EmbedError("Please enter number of messages to delete!").getEmbed()
            ).queue();
        }

        //must be between [2,100]
        if (numb > 1 && numb <= 100) {

            try {

                MessageHistory history = new MessageHistory(event.getTextChannel());
                List<Message> msgs;

                event.getMessage().delete().queue();

                msgs = history.retrievePast(numb).complete();
                event.getTextChannel().deleteMessages(msgs).queue();

               Message msg = event.getTextChannel().sendMessage( new EmbedSuccess(":wastebasket: Cleared " + numb + " messages").getEmbed()).complete();

               new Timer().schedule(new TimerTask() {
                   @Override
                   public void run() {
                       msg.delete().queue();
                   }
               },  3000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            event.getTextChannel().sendMessage(
                    new EmbedError("Number must be between 2 and 100!").getEmbed()
            ).queue();
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
