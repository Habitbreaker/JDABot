package core;

import commands.Command;

import java.util.HashMap;
/**
 * Copy pasta from Youtube ¯\_(ツ)_/¯
 */
public class CommandHandler {
    public static final CommandParser parser = new CommandParser();
    static HashMap<String, Command> commands = new HashMap<>();

    public static void handleCommand(CommandParser.CommandContainer cmd) {

        if (commands.containsKey(cmd.invoke)) {

            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if (!safe) {
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);
            } else {
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }

        }

    }
}

