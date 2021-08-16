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
		scrollUp("-2000");
		int i = 0;
		while (i < 10) {
			scrollDown("550");
			scrollUp("-200");
			i++;
		}
		scrollToView(expandToReadSecondInstance);
		scrollUp("200");
	}

	public void clickSecondExpandBtn() {
		
		click(expandToReadSecondInstance);
	}

}
