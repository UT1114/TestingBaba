package jsUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import baselibrary.Baselibrary;

public class JSUtility extends Baselibrary {

	static JavascriptExecutor js;

	public JSUtility() {
		js = (JavascriptExecutor) driver;

	}

	public static void waitForScript() {
		try {
			js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");

		} catch (Exception e) {
			System.out.println("Isssue to wait Script");
		}
	}

	public static void jsClick(WebElement ele) {
		try {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);

		} catch (Exception e) {
			System.out.println("Isssue in to jsClick");
		}
	}

	public static void jsRefresh() {
		try {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("history.go(0)");

		} catch (Exception e) {
			System.out.println("Isssue in jsRefresh");
		}
	}

	public static void getInnerText() {
		try {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			String sText = js.executeScript("return document.documentElement.innerText;").toString();
			System.out.println(sText);

		} catch (Exception e) {
			System.out.println("Isssue in getInnerText");
		}
	}

	public static String getJSTitle() {

//		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();

		return title;
	}

	public static void jsSendKeys(String key, WebElement ele) {
		try {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value=key;", ele);

		} catch (Exception e) {
			System.out.println("Isssue in getJSTitle");
		}
	}

	public static void getScroll(WebElement ele) {
		try {

//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", ele);

		} catch (Exception e) {
			System.out.println("Isssue in Scroll");
		}
	}

}
