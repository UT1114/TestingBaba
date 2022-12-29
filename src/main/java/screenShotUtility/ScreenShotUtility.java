package screenShotUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import baselibrary.Baselibrary;
import propertyUtility.PropertyUtility;

public class ScreenShotUtility extends Baselibrary {
	org.apache.logging.log4j.Logger log;
	public static void getScreenShot(String folderName, String fileName) {
		org.apache.logging.log4j.Logger log = LogManager.getLogger("ScreenShotUtility");

		try {

			log.info("inside scrrenshot getScrrenshot method of ScreenShotUtility class");
			String location = System.getProperty("user.dir");
			String screenShotType = PropertyUtility.getPropertyData("screenshot.type");
			String path = location+"\\Screenshots\\"+folderName+"\\"+fileName+""+screenShotType;
			
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
			
		FileUtils.copyFile(file, new File(path));
		
		} catch (Exception e) {
			log.error(e.getMessage());
   		}
		
		
		
		
	}

}
