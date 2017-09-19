package agent;

import audioCore.TrackManager;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import embeds.EmbedSuccess;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.VoiceChannel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoiceChannelCleanup extends Thread{

    private static final int CLEANUP_INTERVAL_MILLIS = 60000 * 10;
    private final AudioPlayer player;
    private Guild guild;
    private TrackManager manager;



    public VoiceChannelCleanup(Guild guild, TrackManager manager, AudioPlayer player) {
        this.guild = guild;
        this.manager = manager;
        this.player = player;
    }

    @Override
    public void run() {
        System.out.println("Started voice-cleanup");

        while(true) {

            try {
                System.out.println("Cleaning...");
                cleanup();
                sleep(CLEANUP_INTERVAL_MILLIS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cleanup() {
        if (guild != null
                && guild.getSelfMember() != null
                && guild.getSelfMember().getVoiceState() != null
                && guild.getSelfMember().getVoiceState().getChannel() != null) {


            VoiceChannel vc = guild.getSelfMember().getVoiceState().getChannel();
            if (getHumanMembersInVC(vc).size() == 0) {
                guild.getTextChannels().get(0).sendMessage(new EmbedSuccess("Disconnected from empty voice-channel!").getEmbed()).queue();
                if (player.getPlayingTrack() != null) {
                    player.getPlayingTrack().stop();
                }
                manager.purgeQueue();
                guild.getAudioManager().closeAudioConnection();
                System.out.println("Player disconnected!");
            }
        }
    }


    private List<Member> getHumanMembersInVC(VoiceChannel vc){
        ArrayList<Member> l = new ArrayList<>();

        for(Member m : vc.getMembers()){
            if(!m.getUser().isBot()){
                l.add(m);
            }
        }

        return l;
    }
}
