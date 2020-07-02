package org.reference.config;

import java.io.IOException;
import java.util.Properties;
import org.reference.util.FileUtil;
import org.reference.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configuration class to set up properties for test execution. 
 * @author Pimpa
 *
 */
public class AppConfig {

	private final static Logger logger = LoggerFactory.getLogger(AppConfig.class);

	private final String url;
	private final String PROPERTIES_FILE = "config.properties";
	private final Properties propertiesConfiguration;

	public AppConfig(Properties properties) {
		logger.debug("Initializing test properties from files.");
		propertiesConfiguration = loadProperties(properties);
		url = propertiesConfiguration.getProperty(StringUtil.DOMAIN_URL);
		logger.debug("Configurationprocess has done successfully");
	}

	private Properties loadProperties(Properties properties) {
		try {
			properties.load(FileUtil.getFileContentAsStream(PROPERTIES_FILE));
		} catch (IOException e) {
			logger.error("Couldn't initialize configuration. System exits", e);
			System.exit(1);
		}
		return properties;
	}

	public String getUrl() {
		return this.url;
	}

}
