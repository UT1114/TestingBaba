package testingBabaTests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import testingBabaPages.BottonsPage;

public class ButtonsTest extends Baselibrary {

	public BottonsPage ob;

	@BeforeClass
	@Parameters({"browser"})  
	public void getLaunchBrowserToTest(String browser) throws IOException {
		getLaunchBrowser(browser);

		ob = new BottonsPage();
	}

	@Test(priority = 1)
	public void getTitleTest() {

		ob.getCheckBox();

	}

}
