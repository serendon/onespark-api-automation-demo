package dataProvider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
    private static Properties properties;


    static {
        properties = new Properties();
        try {
            /*Setting a default config file*/
            String configFile = System.getProperty("config.file", "config-production.properties");
            try (InputStream inputStream = ConfigFileReader.class.getClassLoader().getResourceAsStream(configFile)) {
                if (inputStream != null) {
                    properties.load(inputStream);
                } else {
                    throw new FileNotFoundException(configFile + " file not found");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
