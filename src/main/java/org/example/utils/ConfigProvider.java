package org.example.utils;

import java.io.IOException;
import java.util.Properties;

public final class ConfigProvider {

    private static final String CONFIG_PATH = "config.properties";
    private static final Properties prop = initProperties();
    public static final int IMPLICITLY_WAIT = Integer.parseInt(prop.getProperty("implicitly.wait"));
    public static final int PAGE_LOAD_TIMEOUT = Integer.parseInt(prop.getProperty("page.load.timeout"));

    public static final String CUCUMBER_WEBSITE = prop.getProperty("cucumber.website");

    private ConfigProvider() {
    }

    private static Properties initProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file: " + CONFIG_PATH);
        }
        return properties;
    }
}