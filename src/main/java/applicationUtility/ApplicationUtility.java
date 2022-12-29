package applicationUtility;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import baselibrary.Baselibrary;
import propertyUtility.PropertyUtility;

public class ApplicationUtility extends Baselibrary {
	private static int waitTime;
	private static WebDriverWait wait;
	static org.apache.logging.log4j.Logger  log=LogManager.getLogger("ApplicationUtility");

	

	public static void sendKeys(WebElement ele, String str) {

		try {
			// log=LogManager.getLogger("ApplicationUtility");

			int waitTime = Integer.parseInt(PropertyUtility.getPropertyData("dynamicWait"));
			 wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.sendKeys(str);
			log.info(str+" send in "+ele.getText());

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	public static void clickToElement(WebElement ele) {

		try {
			//log = LogManager.getLogger("ApplicationUtility");
			 wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			log.info("Clicked on "+ele.getText());

		} catch (Exception e) {
			log.info(e.getMessage());
		}

	}

	public static void waitAlertWait() {

		try {
			log = LogManager.getLogger("ApplicationUtility");
			 wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.alertIsPresent());
			log.info("wait on alert implemented");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

}
