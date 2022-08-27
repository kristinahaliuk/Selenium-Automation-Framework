package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    private static Properties properties;

    /*
     * This method will enable us to read the properties file based on its name and property we need value for
     * */

    public static String getProperty(String fileName, String key) {
        try {
            String path = "src/test/resources/"+ fileName;
            FileInputStream stream = new FileInputStream(path);
            properties = new Properties();
            properties.load(stream);
            stream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key); }

}
