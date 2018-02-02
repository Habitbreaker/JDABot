package core;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {

    public CommandContainer parse(String raw, MessageReceivedEvent event) {
        String beheaded = raw.replaceFirst(Pattern.quote(STATIC.getPREFIX()), "");
        String[] splitBeheaded;
        Pattern pattern = Pattern.compile("(\"[\\W\\w]+\"$)");
        Matcher matcher = pattern.matcher(beheaded);
        if(matcher.find()) {
            splitBeheaded = new String[3];
            splitBeheaded[0] = beheaded.split(" ")[0];
            splitBeheaded[1]= beheaded.split(" ")[1];
            splitBeheaded[2] = matcher.group(1).replaceAll("\"", "");
        } else {
            splitBeheaded = beheaded.split(" ");
        }
        String invoke = splitBeheaded[0];
        ArrayList<String> split = new ArrayList<>();
        Collections.addAll(split, splitBeheaded);
        String[] args = new String[split.size() - 1];
        split.subList(1, split.size()).toArray(args);

        return new CommandContainer(raw, beheaded, splitBeheaded, invoke, args, event);
    }


    class CommandContainer {

        final String raw;
        final String beheaded;
        final String[] splitBeheaded;
        final String invoke;
        final String[] args;
        final MessageReceivedEvent event;

        CommandContainer(String rw, String beheaded, String[] splitBeheaded, String invoke, String[] args, MessageReceivedEvent event) {
            this.raw = rw;
            this.beheaded = beheaded;
            this.splitBeheaded = splitBeheaded;
            this.invoke = invoke;
            this.args = args;
            this.event = event;
        }

    }
}
