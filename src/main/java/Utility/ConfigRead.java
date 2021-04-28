package Utility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ConfigRead {

    Properties properties = new Properties();

    public ConfigRead() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(fileInputStream);
        }
        catch (Exception e){
            System.out.println("Exception is : " + e.getMessage());
        }
    }

    public String url(){
        String url = properties.getProperty("url");
        return url;
    }

    public String chromePath(){
        String chromePath = properties.getProperty("chromepath");
        return chromePath;
    }

    public String firefoxPath(){
        String firefoxPath = properties.getProperty("firefoxpath");
        return firefoxPath;
    }
}

