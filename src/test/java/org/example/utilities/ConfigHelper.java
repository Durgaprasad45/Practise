package org.example.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigHelper {
    private static Properties properties;
    private static String filepath = System.getProperty("user.dir")+ "/src/test/resources/config.properties";

    static{
        try{
            System.out.println(filepath);
            FileInputStream fis = new FileInputStream(filepath);
            properties = new Properties();
            properties.load(fis);
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
