package com.automation.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = new Properties();

    // Static block ensures properties are loaded once when class is loaded
    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            System.err.println("config.properties file not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error reading config.properties file!");
            e.printStackTrace();
        }
    }

    // All getters are static now
    public static String getBaseUrl() {
        return prop.getProperty("baseUrl");
    }

    public static String getSauceUrl() {
        return prop.getProperty("sauceUrl");
    }

    public static String getBrowser() {
        return prop.getProperty("browser");
    }

    public static int getTimeout() {
        return Integer.parseInt(prop.getProperty("timeout"));
    }

    public static String getUsername() {
        return prop.getProperty("sauceusername");
    }

    public static String getPassword() {
        return prop.getProperty("saucepassword");
    }
}