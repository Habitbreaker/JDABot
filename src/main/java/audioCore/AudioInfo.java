package audioCore;


import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.core.entities.Member;

public class AudioInfo {

    private final AudioTrack TRACK;
    private final Member AUTHOR;

    AudioInfo(AudioTrack track, Member author) {
        this.TRACK = track;
        this.AUTHOR = author;
    }

    public AudioTrack getTRACK() {
        return TRACK;
    }

    Member getAUTHOR() {
        return AUTHOR;
    }
}
