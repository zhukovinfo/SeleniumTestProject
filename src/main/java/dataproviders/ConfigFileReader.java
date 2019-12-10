package dataproviders;

import com.google.common.io.Resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath = "resources//config.properties";

    public ConfigFileReader(){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try{
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties file not found at " + propertyFilePath);
        }
    }

    public long getImplicitlyWait(){
        String implicitlyWait =  properties.getProperty("implicitWaitTime");
        if (implicitlyWait != null)
                return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("The 'implicitWaitTime' key not found in the config.properties file");
    }

    public String getUrl(){
        String url = properties.getProperty("url");
        if (url != null)
            return url;
        else throw new RuntimeException("The 'url' key not found in the config.properties file");
    }
}
