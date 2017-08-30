package listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter{

    public void onReady(ReadyEvent event) {

        StringBuilder out = new StringBuilder("\nThis bot is running on following servers: \n");

        for (Guild guild: event.getJDA().getGuilds()) {
            out.append(guild.getName()).append(" (").append(guild.getId()).append(") \n");

        }
        System.out.println(out);

        for (Guild guild : event.getJDA().getGuilds()) {
            guild.getTextChannels().get(0).sendMessage(
                   "Hello darkness my old friend :neutral_face:"
            ).queue();
        }
        }


}
