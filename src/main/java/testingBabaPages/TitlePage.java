package testingBabaPages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationUtility.ApplicationUtility;
import baselibrary.Baselibrary;
import excelUtility.ExcelUtility;
import jdbcUtility.JDBCUtility;
import jsUtility.JSUtility;
import propertyUtility.PropertyUtility;

public class TitlePage extends Baselibrary {

	public org.apache.logging.log4j.Logger log;
	
	public TitlePage() {
		log = LogManager.getLogger("TitlePage");
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[text()='Practice'])[1]")
	private WebElement practice;

	@FindBy(xpath = "//button[@class='close']")
	private WebElement closeButton;

	@FindBy(id = "aswift_1")
	private WebElement frameOuter;

	@FindBy(id = "ad_iframe")
	private WebElement frameInner;

	@FindBy(xpath = "//span[text()='Close']")
	private WebElement closeAdds;

	@FindBy(xpath = "//button[@data-target='#elements']")
	private WebElement elementButton;

	@FindBy(xpath = "//a[@class='nav-link']")
	private List<WebElement> elementsList;

	@FindBy(xpath = "//input[@id='fullname1']")
	private WebElement fullName;

	@FindBy(xpath = "//input[@id='fullemail1']")
	private WebElement fullEmail;

	@FindBy(xpath = "//textarea[@id='fulladdresh1']")
	private WebElement fullAddress;

	@FindBy(xpath = "//textarea[@id='paddresh1']")
	private WebElement permanentAddress;

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submitTextData;

	@FindBy(xpath = "//div[@class='col-md-6 mt-5']/label")
	private List<WebElement> dataTextBox;

	// form/input

	List<String> ActualData = new ArrayList<String>();
	List<String> expectedData = new ArrayList<String>();

	public String getHomePageTitle() {
		String title = driver.getTitle();
		return title;

	}

	public void toElementBtn() {
		try {
			log.info("Inside toElementBtn method");
		
		ApplicationUtility.clickToElement(closeButton);
		ApplicationUtility.clickToElement(practice);
		driver.switchTo().frame(frameOuter);
		driver.switchTo().frame(frameInner);
		ApplicationUtility.clickToElement(closeAdds);
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		ApplicationUtility.clickToElement(elementButton);

		for (WebElement li : elementsList) {
			if (li.getText().equalsIgnoreCase("Text Box")) {
				ApplicationUtility.clickToElement(li);
				ApplicationUtility.sendKeys(fullName, PropertyUtility.getPropertyData("fullname"));
				ApplicationUtility.sendKeys(fullEmail, PropertyUtility.getPropertyData("email"));
				ApplicationUtility.sendKeys(fullAddress, PropertyUtility.getPropertyData("fAddress"));
				ApplicationUtility.sendKeys(permanentAddress, PropertyUtility.getPropertyData("PAddress"));
				ApplicationUtility.clickToElement(submitTextData);
				expectedData.add("Avdehesh");
				expectedData.add("Avdhesh@gmail.com");
				expectedData.add("Ghaziabad Agra India");
				expectedData.add("Yamuna Vihar Delhi Bombay India");

				for (int i = 0; i < dataTextBox.size(); i++) {
					i++;
					System.out.println(dataTextBox.get(i).getText());

					ActualData.add(dataTextBox.get(i).getText());

				}
			}
		}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	public void VerifyData() {

		for (String Act : ActualData) {

			for (String exp : expectedData) {

				System.out.println(Act + "   " + exp);
				// org.testng.Assert.assertEquals(Act, exp);

				expectedData.remove(0);
				break;

			}

		}

		// List<String> active_msisdn = JDBCUtility.getDBData("select * from
		// kyc_numbers_details where barring_status='Active' order by 1 desc");
		// for (String msdn : active_msisdn) {
//			System.out.println(msdn);
//		}

	}

	public void exceldatafetched() {
		log = LogManager.getLogger("TitlePage");

		try {

			log.info("inside exceldatafetched to method");
			List<String> listExcelData = ExcelUtility.getCompleteRowData(1, 2,
					PropertyUtility.getPropertyData("excel.data.path"));
			log.info("Fetched Excel data");

			for (String Act : listExcelData) {

				System.out.println(Act);

			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

}
