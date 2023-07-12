package utils;

import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {

	protected InputStream is;
	protected Properties prop;

	public ReadConfigFile() {
		try {
			ReadConfigFile.class.getClassLoader().getResourceAsStream(Constants.Chrome_Driver_Directory);
			prop = new Properties();
			prop.load(is);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBrowser() {
		if (prop.getProperty("browser") == null) {
			return "";
		}
		return prop.getProperty(getBrowser());
	}

}
