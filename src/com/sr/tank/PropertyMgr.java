package com.sr.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author admin
 * @date 2020/5/28
 */
public class PropertyMgr {

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static Object getProperties(String key){
        if(properties == null) {
            return null;
        }
        return properties.get(key);

    }

}
