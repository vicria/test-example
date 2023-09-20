package rest.utils;

import lombok.extern.slf4j.Slf4j;
import rest.constants.PropertyConstants;

import java.io.FileInputStream;
import java.util.Properties;

import static rest.constants.PropertyConstants.CONFIG;

@Slf4j
public class PropertyManager {
    public static String propHandler(PropertyConstants file, String key) {
        FileInputStream props = null;
        Properties property = new Properties();
        try {
            if (file.equals(CONFIG)) {
                props = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
            }
            property.load(props);
        } catch (Exception e) {
            log.info("Properties were not found...");
            e.printStackTrace();
        }
        return property.getProperty(key);
    }
}
