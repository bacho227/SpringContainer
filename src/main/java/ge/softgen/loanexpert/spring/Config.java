package ge.softgen.loanexpert.spring;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Bacho on 3/5/15.
 */
public class Config {
	private static final String appPropertiesFile = "application.properties";
	private static final Properties properties = new Properties();

	static {
		try {
			InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(appPropertiesFile);
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(properties);
		System.out.println("###############################################################################################");
	}

	public static String getConfig(String key) {
		return (properties != null && properties.get(key) != null) ? properties.get(key).toString() : null;
	}

}
