package DAL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	private String configFilePath = "src/app.config";
	private Properties prop;

	public ConfigManager() throws FileNotFoundException, IOException {
		FileInputStream fis;
		fis = new FileInputStream(configFilePath);
		prop = new Properties();
		prop.load(fis);
	}

	public String getDBConnectionString() {
		return prop.getProperty("DB_CON");
	}

	public String getDBUser() {
		return prop.getProperty("DB_USER");
	}

	public String getDBPass() {
		return prop.getProperty("DB_PASS");
	}
}