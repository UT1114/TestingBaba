package testingBabaTests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import testingBabaPages.AlertPage;

public class AlertTest extends Baselibrary
{

	public AlertPage ob;
	@BeforeClass
	@Parameters({"browser"})  
	public void getLaunchBrowserToTest(String browser) throws IOException {
		getLaunchBrowser(browser);

		ob = new AlertPage();
	}

	
	@Test(priority = 6)
	public void getAlertTest() {
		ob.getCheckBox();
		ob.getAlertWindowElements();
	}
	
}
