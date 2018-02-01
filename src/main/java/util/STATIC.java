package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;

public class STATIC {

    public static final String VERSION = "1.0.0";

    public static String PREFIX = "<";

    public static  String PATH_FUN_CMDS;

    public static void receiveSTATICS() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Config config = mapper.readValue(new File("config.yaml"), Config.class);
            PREFIX =  config.getPREFIX();
            PATH_FUN_CMDS = config.getPATH_FUN_CMDS();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
