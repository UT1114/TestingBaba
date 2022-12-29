package testingBabaTests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import testingBabaPages.ChechBoxPage;

public class CheckBoxTest extends Baselibrary
{

	private ChechBoxPage ob;
	
	@BeforeClass
	@Parameters({ "browser" })
	public void getBrowserCheckBox(String browser) throws IOException{
		getLaunchBrowser(browser);
		ob=new ChechBoxPage();
		
	}
	
	@Test(priority = 2,enabled = true)
	public void verifyCheckBox() {
		ob.getCheckBox();
		ob.verifyCheckBoxData();
	}
	
	
	
	
}
