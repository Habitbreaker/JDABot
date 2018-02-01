package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;

public class STATIC {

    private static final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    public static String getVERSION() {
        try {
            Config config = mapper.readValue(new File("config.yaml"), Config.class);
            return config.getPREFIX();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1.0.0";
    }

    public static String getPREFIX() {
        try {
            Config config = mapper.readValue(new File("config.yaml"), Config.class);
            return config.getPREFIX();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "!";
    }



    public static String getPathSoundFiles() {
        try {
            Config config = mapper.readValue(new File("config.yaml"), Config.class);
            return config.getPATH_TO_SOUND_FILES();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}