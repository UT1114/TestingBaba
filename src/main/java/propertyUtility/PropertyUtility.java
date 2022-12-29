package propertyUtility;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyUtility {

	static String path = "C:\\Users\\23135201\\eclipse-workspace\\TestingBaba\\PropertyData";

	static String value;
	private static Logger log;
	public static String getPropertyData(String key) {
		try {
			log = LogManager.getLogger("ExcelUtility");

			FileInputStream fis = new FileInputStream(path);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);

		} catch (Exception e) {
          log.info("Exception is reading property file data is "+e.getMessage());

		}

		return value;

	}

}
