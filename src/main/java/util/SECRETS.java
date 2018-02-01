package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;

public class SECRETS {

    public static String TOKEN = null;

    public static String receiveTOKEN() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Config config = mapper.readValue(new File("config.yaml"), Config.class);
            return config.getTOKEN();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
