package testingBabaTests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import testingBabaPages.WebTablePage;

public class WebTableTest extends Baselibrary {

	private WebTablePage ob;

	@BeforeClass
	@Parameters({ "browser" })
	public void getLaunchBrowserForWebTables(String browser) throws IOException {

		getLaunchBrowser(browser);
		ob = new WebTablePage();

	}

	@Test(priority = 3)
	public void webTableTest() {
		ob.getCheckBox();

	}

}
