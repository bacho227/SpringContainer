package ge.softgen.loanexpert.spring;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Bacho on 3/5/15.
 */
public class ApplicationConfig {
	private static final String appPropertiesFile = "application.properties";
	private static final Properties properties = new Properties();
	public static final String schema = "VANO";

	static {
		try {
			InputStream inputStream = ApplicationConfig.class.getClassLoader().getResourceAsStream(appPropertiesFile);
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		schema = getConfig("spring.datasource.schema");
	}

	public static String getConfig(String key) {
		return (properties != null && properties.get(key) != null) ? properties.get(key).toString() : null;
	}

	public static boolean isDevMod() {
		return Boolean.valueOf(getConfig("application.isDevMode"));
	}

}
