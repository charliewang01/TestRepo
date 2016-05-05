package com.zxtech.apptools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//Develop Branch Push test by Xiaofu at 09:23
/**
 * ¸µÌÚóÏ
 * @author solar AliyunTest CharlieWong
 *
 */

public class ConfigUtil {
	private static Properties props = new Properties(); 
	static{
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getValue(String key){
		return props.getProperty(key);
	}

    public static void updateProperties(String key,String value) {    
            props.setProperty(key, value); 
    } 
}
