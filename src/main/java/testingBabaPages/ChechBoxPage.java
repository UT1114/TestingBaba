package testingBabaPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationUtility.ApplicationUtility;
import baselibrary.Baselibrary;
import jsUtility.JSUtility;

public class ChechBoxPage extends Baselibrary
{

	public ChechBoxPage() {
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
	
	@FindBy(xpath = "//iframe[@src='Checkbox.html']")
	private WebElement checkBoxFrame;
	
	
	@FindBy(xpath = "//label[text()='Mobile:']")
	private WebElement mobile;
	
	@FindBy(xpath = "//h6[@id='text']")
	private WebElement mobileText;
	
	
	
	@FindBy(xpath = "//label[text()='Laptop:']")
	private WebElement laptop;
	
	@FindBy(xpath = "//h6[@id='text1']")
	private WebElement laptopText;
	
	@FindBy(xpath = "//input[@id='mydesktop']")
	private WebElement destop;
	
	@FindBy(xpath = "//h6[@id='text2']")
	private WebElement destopText;
	
	private List <String> expectedCheckBoxData;
	private List <String> actualCheckBoxData;
	
	
	public void getCheckBox() {
		expectedCheckBoxData=new ArrayList<String>();
		actualCheckBoxData=new ArrayList<String>();
		ApplicationUtility.clickToElement(closeButton);
		ApplicationUtility.clickToElement(practice);
		driver.switchTo().frame(frameOuter);
		driver.switchTo().frame(frameInner);
		ApplicationUtility.clickToElement(closeAdds);
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		ApplicationUtility.clickToElement(elementButton);
		for (WebElement li : elementsList) {
			if (li.getText().equalsIgnoreCase("Check Box")) {
				
				ApplicationUtility.clickToElement(li);

				
				
			}
	}
		
		driver.switchTo().frame(checkBoxFrame);
		ApplicationUtility.clickToElement(mobile);
		actualCheckBoxData.add(mobileText.getText());
		ApplicationUtility.clickToElement(laptop);
		actualCheckBoxData.add(laptopText.getText());
		//ApplicationUtility.clickToElement(destop);
		JSUtility.jsClick(destop);
		actualCheckBoxData.add(destopText.getText());
		
		expectedCheckBoxData.add("You are selected Mobile");
		expectedCheckBoxData.add("You are Selected Laptop");
		expectedCheckBoxData.add("You are Selected Desktop");
	
	
}
	
public void verifyCheckBoxData() {
	

		for (String Act : actualCheckBoxData) {

			for (String exp : expectedCheckBoxData) {

				System.out.println(Act+"   "+exp);
				org.testng.Assert.assertEquals(Act, exp);

				expectedCheckBoxData.remove(0);
				break;

			
			
		}

	}
		
		driver.switchTo().defaultContent();
}




}
