package com.databox;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Uros Majeric
 *
 */
public class Environment {
	private static final Logger logger = LoggerFactory.getLogger(Environment.class);

	public static Properties prop = new Properties();

	static {
		try {
			prop.load(Environment.class.getClassLoader().getResourceAsStream("config.properties"));
			try {
				String configFile = System.getProperty("configFile");
				if (configFile != null && !configFile.isEmpty()) {
					prop.load(new FileInputStream(configFile));
				}
			} catch (IOException ex) {
				/* ignore if there is no override conf file - use defualts */
				logger.error("Configuration error: {}", ex.getLocalizedMessage());
			}
		} catch (IOException ex) {
			logger.error(ex.getLocalizedMessage(), ex);
		}
	}

	public static String getDataboxBaseURL() {
		return prop.getProperty("databox-base-url");
	}

	public static String getUserAgent() {
		return prop.getProperty("user-agent");
	}

}