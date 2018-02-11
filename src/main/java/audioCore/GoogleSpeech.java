package audioCore;

import com.darkprograms.speech.synthesiser.SynthesiserV2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;

public class GoogleSpeech {
    private SynthesiserV2 synthesiser = new SynthesiserV2("YOUR API KEY");
    private String text;

    public GoogleSpeech(String text) {
        this.text = text;
    }


    public File writeToFile() throws IOException {
        InputStream initialStream = synthesiser.getMP3Data(this.text);
        File targetFile = new File("out/tts/tts_file.mp3");

        java.nio.file.Files.copy(
                initialStream,
                targetFile.toPath(),
                StandardCopyOption.REPLACE_EXISTING);

        initialStream.close();

        return targetFile;
    }
}
