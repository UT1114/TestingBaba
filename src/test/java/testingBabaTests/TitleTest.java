package testingBabaTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import baselibrary.Baselibrary;
import testingBabaPages.TitlePage;

public class TitleTest extends Baselibrary {

	private org.apache.logging.log4j.Logger log;

	public TitlePage ob;

	@BeforeClass
	@Parameters({ "browser" })
	public void getLaunchBrowserToTest(String browser) throws IOException {
		log = LogManager.getLogger("TitleTest");

		getLaunchBrowser(browser);
		log.info("called getLaunchBrowser method");
		ob = new TitlePage();
	}

	@Test(priority = 1, enabled = true)
	public void getHomePageTitleTest() {
		String title = ob.getHomePageTitle();
		log.info("called getHomePageTitle method");

		Assert.assertEquals(title, "Testing Baba software training and development");

	}

	@Test(priority = 2, enabled = true)
	public void verifyElementBTN() {

		ob.toElementBtn();
		log.info("called toElementBtn method");

		ob.VerifyData();
		log.info("called VerifyData method");

	}

	@Test(description="This test case fetch the data from excel file ",priority = 3)
	public void verifyExceldatafetched() {

		ob.exceldatafetched();
		log.info("called exceldatafetched method");

	}

}
