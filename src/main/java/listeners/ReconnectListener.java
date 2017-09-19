package listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReconnectedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ReconnectListener extends ListenerAdapter {

    @Override
    public void onReconnect(ReconnectedEvent event) {
        for (Guild guild : event.getJDA().getGuilds()) {
            System.out.println("Reconnected");
        }
    }
}
