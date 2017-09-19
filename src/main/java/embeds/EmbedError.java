package embeds;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;

import java.awt.*;

public class EmbedError {
    private EmbedBuilder embed;

    public EmbedError(String content) {
        embed = new EmbedBuilder().setColor(Color.RED);
        embed.setDescription(content);
    }

    public MessageEmbed getEmbed() {
        return embed.build();
    }
}
