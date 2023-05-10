package org.workshop.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static Config instance;
    private Properties properties;

    private Config(String filePath) {
        properties = new Properties();
        loadPropertiesFromFile(filePath);
    }

    public static Config getInstance() {
        if (instance == null) {
            // Assuming there is a config.properties file in the project root directory
            instance = new Config("config.properties");
        }
        return instance;
    }


    private void loadPropertiesFromFile(String fileName) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                System.err.println("Resource file not found: " + fileName);
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            System.err.println("Error reading resource file: " + fileName);
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return getInstance().properties.getProperty(key);
    }
}
