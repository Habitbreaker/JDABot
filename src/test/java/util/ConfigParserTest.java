package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class ConfigParserTest {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    File test1 = new File("testFiles/test1.yaml");
    File test2 = new File("testFiles/test2.yaml");

    @Test
    void shouldReadLines() {
        try {

            Config config = mapper.readValue(test1, Config.class);
            assertEquals("C:\\\\Dir\\\\To\\\\Music", config.getPATH_TO_SOUND_FILES());
            assertEquals("myToken", config.getTOKEN());
            assertEquals("!", config.getPREFIX());
        } catch (Exception e) {
            e.printStackTrace();
            assertFalse(true);
        }
    }


}
