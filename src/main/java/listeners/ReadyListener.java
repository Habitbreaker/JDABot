package listeners;

import agent.VoiceChannelCleanup;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.sound.midi.Soundbank;

public class ReadyListener extends ListenerAdapter{

    public void onReady(ReadyEvent event) {

        StringBuilder out = new StringBuilder("\nThis bot is running on following servers: \n");

        for (Guild guild: event.getJDA().getGuilds()) {
            out.append(guild.getName()).append(" (").append(guild.getId()).append(") \n");

        }
        System.out.println(out);

        for (Guild guild : event.getJDA().getGuilds()) {
            System.out.println("Bot joined " + guild);
        }

        }


}
