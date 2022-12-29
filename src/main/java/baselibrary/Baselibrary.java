package baselibrary;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import propertyUtility.PropertyUtility;
import screenShotUtility.ScreenShotUtility;

public class Baselibrary {

	public static WebDriver driver;
	protected org.apache.logging.log4j.Logger log;

	public void getLaunchBrowser(String browser) {
		log = LogManager.getLogger("Baselibrary");

		try {

			if (browser.equalsIgnoreCase("chrome") && !browser.isEmpty()) {
				ChromeOptions options = new ChromeOptions();
				// options.addArguments("incognito");
				// options.addArguments("start-maximized");
				// log.info("Window Maximized");
				// options.addArguments("headless");
				// options.addArguments("version");
				driver = new ChromeDriver(options);
				log.info(browser + " Driver Initialized");
			}

			if (browser.equalsIgnoreCase("edge") && !browser.isEmpty()) {
				driver = new EdgeDriver();
				log.info(browser + " browser initialized");
			}

			String url = PropertyUtility.getPropertyData("URL");
			driver.get(url);
			log.info("URL Entered : " + url);

			driver.manage().window().maximize();
			log.info("Window Maximized");

			driver.manage().timeouts().pageLoadTimeout(
					Duration.ofSeconds(Integer.parseInt(PropertyUtility.getPropertyData("pageLoadTime"))));
			log.info("Pageload time implemented " + PropertyUtility.getPropertyData("pageLoadTime"));

			driver.manage().timeouts().implicitlyWait(
					Duration.ofSeconds(Integer.parseInt(PropertyUtility.getPropertyData("implecitTime"))));
			log.info("implicitlyWait implemented " + PropertyUtility.getPropertyData("implecitTime"));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@AfterTest
	public void getBrowserClose() {

		if (!(driver == null)) {
			log.info("Window closed : " + driver.getWindowHandle());

			driver.close();
		} else {
			log.info("Window already closed");
		}

	}

	@AfterMethod
	public void getResultAnalysis(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		if (result.isSuccess()) {
			ScreenShotUtility.getScreenShot("Passes", methodName);
			log.info("Scrrenshot saved in Passes folder with " + methodName + " name");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			ScreenShotUtility.getScreenShot("Failed", methodName);
			log.info("Scrrenshot saved in Failed folder with " + methodName + " name");

		} else if (result.getStatus() == ITestResult.SKIP) {
			ScreenShotUtility.getScreenShot("Skip", methodName);
			log.info("Scrrenshot saved in Skip folder with " + methodName + " name");

		}
	}
}
