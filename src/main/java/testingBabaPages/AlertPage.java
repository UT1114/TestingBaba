package testingBabaPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import applicationUtility.ApplicationUtility;
import baselibrary.Baselibrary;
import propertyUtility.PropertyUtility;

public class AlertPage extends Baselibrary {
	public AlertPage() {
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

	@FindBy(xpath = "//button[@data-target='#alerts']")
	private WebElement alertButton;

	@FindBy(xpath = "//a[@class='nav-link']")
	private List<WebElement> elementsList;

	@FindBy(xpath = "//button[@onclick='aftersec5()']")
	private WebElement aftersec5;

	String customXpathBefor = "//a[@href='#tab_";
	String customXpathAfter = "']";

	public void getCheckBox() {

		ApplicationUtility.clickToElement(closeButton);
		ApplicationUtility.clickToElement(practice);
		driver.switchTo().frame(frameOuter);
		driver.switchTo().frame(frameInner);
		ApplicationUtility.clickToElement(closeAdds);
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		ApplicationUtility.clickToElement(alertButton);

	}

	public void getAlertWindowElements() {

		for (int i = 11; i < 16; i++) {

			String intStringValue = Integer.toString(i);
			String finalXpath = customXpathBefor + intStringValue + customXpathAfter;
			WebElement element = driver.findElement(By.xpath(finalXpath));

			System.out.println(element.getText());
			if (element.getText().equalsIgnoreCase("alerts")) {
				ApplicationUtility.clickToElement(element);
			}
		}

		ApplicationUtility.clickToElement(aftersec5);
		ApplicationUtility.waitAlertWait();
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		Assert.assertEquals(alertText, PropertyUtility.getPropertyData("expectedAlerttext"));

		driver.switchTo().alert().accept();

	}

}
