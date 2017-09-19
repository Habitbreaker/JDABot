package embeds;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;

import java.awt.*;

public class EmbedSuccess {
    private EmbedBuilder embed;

    public EmbedSuccess(String content) {
        embed = new EmbedBuilder().setColor(Color.GREEN);
        embed.setDescription(content);
    }

    public MessageEmbed getEmbed() {
        return embed.build();
    }
}
