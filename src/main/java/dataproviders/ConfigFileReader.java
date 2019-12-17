package dataproviders;

import com.google.common.io.Resources;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFileName = "config.properties";

    public ConfigFileReader() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
        if (inputStream == null){
            throw new RuntimeException("Config.properties file not found at Resources");
        }

        try{
            properties = new Properties();
            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public long getImplicitlyWait(){
        String implicitlyWait =  properties.getProperty("implicitWaitTime");
        if (implicitlyWait != null)
                return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("'ImplicitWaitTime' key not found at " + propertyFileName);
    }

    public String getUrl(){
        String url = properties.getProperty("url");
        if (url != null)
            return url;
        else throw new RuntimeException("'Url' key not found at " + propertyFileName);
    }

}
