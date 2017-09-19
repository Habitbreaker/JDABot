package core;

import commands.CmdCall;
import commands.CmdClear;
import commands.CmdPing;
import commands.Music;
import listeners.CommandListener;
import listeners.ReadyListener;
import listeners.ReconnectListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import util.SECRETS;
import util.STATIC;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) {

        JDABuilder builder = new JDABuilder(AccountType.BOT);

        builder.setToken(SECRETS.TOKEN);
        builder.setAutoReconnect(true);

        builder.setStatus(OnlineStatus.ONLINE);
        addListeners(builder);
        addCommands(builder);

        builder.setGame(new Game() {
            @Override
            public String getName() {
                return "Say " + STATIC.PREFIX +" help";
            }

            @Override
            public String getUrl() {
                return null;
            }

            @Override
            public GameType getType() {
                return GameType.DEFAULT;
            }
        });

        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException | InterruptedException | RateLimitedException e) {
            e.printStackTrace();
        }


    }

    private static void addListeners(JDABuilder builder) {
        builder.addEventListener(new ReadyListener());
        builder.addEventListener(new ReconnectListener());
        builder.addEventListener(new CommandListener());
    }

    private static void addCommands(JDABuilder builder) {
        CommandHandler.commands.put("ping", new CmdPing());
        CommandHandler.commands.put("clear", new CmdClear());
        CommandHandler.commands.put("call", new CmdCall());
        CommandHandler.commands.put("m", new Music());
        CommandHandler.commands.put("music", new Music());
    }
}
