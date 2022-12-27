package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Logger LOGGER = LogManager.getLogger(Config.class);
    private static final Properties properties;
    static {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/config.properties"));
        } catch (FileNotFoundException e) {
            LOGGER.error("Error, could not read config.properties file.");
            throw new RuntimeException(e);
        }
        properties = new Properties();
        try {
            properties.load(reader);
        } catch (IOException e) {
            LOGGER.error("Error, could not load config.properties file.");
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String propertyName){
        return properties.getProperty(propertyName);
    }
}
