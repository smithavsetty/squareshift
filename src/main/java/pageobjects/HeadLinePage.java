package pageobjects;

import org.openqa.selenium.WebDriver;

import util.PropertieReader;

public class HeadLinePage extends BaseMethods {
	WebDriver driver;
	String expandToReadSecondInstance = PropertieReader.getProperty("expandToReadSecondInstance");

	public HeadLinePage(WebDriver driver) {
		super(driver);
	}

	public String getPageTitle() {
		return getTitle();
	}

	public void scrollInToSecondExpandBtn() {
		scrollToEnd();
		scrollToView(expandToReadSecondInstance);
		scrollUp("200");
	}

	public void clickSecondExpandBtn() {		
		click(expandToReadSecondInstance);
	}

}
