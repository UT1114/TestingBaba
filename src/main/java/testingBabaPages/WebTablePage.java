package testingBabaPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationUtility.ApplicationUtility;
import baselibrary.Baselibrary;

public class WebTablePage extends Baselibrary
{
	public WebTablePage() {
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
	
	@FindBy(xpath = "//input[@pattern='^[a-zA-Z][\\sa-zA-Z]{2,32}']")
	private WebElement name;
	
	@FindBy(xpath = "//input[@pattern='[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$']")
	private WebElement email;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement save;
	
	@FindBy(xpath = "//button[text()='Edit']")
	private WebElement edit;
	
	@FindBy(xpath = "//input[@name='edit_name']")
	private WebElement editName;
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement update;
	
	
	@FindBy(xpath = "//tbody/tr/td")
	private List <WebElement> verifyNameEmail;
	
	@FindBy(xpath = "//iframe[@src='Webtable.html']")
	private WebElement webTableFrame;
	
	
	
	public void getCheckBox() {
		
		ApplicationUtility.clickToElement(closeButton);
		ApplicationUtility.clickToElement(practice);
		driver.switchTo().frame(frameOuter);
		driver.switchTo().frame(frameInner);
		ApplicationUtility.clickToElement(closeAdds);
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		ApplicationUtility.clickToElement(elementButton);
		for (WebElement li : elementsList) {
			if (li.getText().equalsIgnoreCase("Web Tables")) {
				
				ApplicationUtility.clickToElement(li);

				
				
			}
	}
		driver.switchTo().frame(webTableFrame);

		ApplicationUtility.sendKeys(name, "Ajay Sharma");
		ApplicationUtility.sendKeys(email, "Ajay12345@gmail.com");
		ApplicationUtility.clickToElement(save);
		
		ApplicationUtility.clickToElement(edit);
		editName.clear();
		ApplicationUtility.sendKeys(editName, "Vijay Singh");
		ApplicationUtility.clickToElement(update);
		
		for (int i = verifyNameEmail.size()-1; i>55; i--) {
			System.out.println(verifyNameEmail.get(i).getText());
			
			
		}

		
		
		
}}
