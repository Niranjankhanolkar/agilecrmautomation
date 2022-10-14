package com.AgileCrmAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandling {

	private Properties properties;

	public PropertyHandling() {
		// confg file path
		String confgFilePath = System.getProperty("user.dir") + "//confg.properties";
		try {
			 FileInputStream input= new FileInputStream(confgFilePath);
			properties = new Properties();
			properties.load(input);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public String getValue(String key) {
		return properties.getProperty(key);
	}
}
