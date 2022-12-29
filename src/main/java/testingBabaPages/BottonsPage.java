package testingBabaPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationUtility.ApplicationUtility;
import baselibrary.Baselibrary;

public class BottonsPage extends Baselibrary
{
	public BottonsPage() {
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
	
	
	
	
	
	
	
	
	public void getCheckBox() {
		
		ApplicationUtility.clickToElement(closeButton);
		ApplicationUtility.clickToElement(practice);
		driver.switchTo().frame(frameOuter);
		driver.switchTo().frame(frameInner);
		ApplicationUtility.clickToElement(closeAdds);
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		ApplicationUtility.clickToElement(elementButton);	
}
	






}
