package pageobjects;

import org.openqa.selenium.WebDriver;
import util.PropertieReader;

public class MainPage extends BaseMethods {

	WebDriver driver;
	String latestHeadline = PropertieReader.getProperty("latestHeadline");
	String latestHeadlineSingapore = PropertieReader.getProperty("latestHeadlineSingapore");
	String headerSingapore = PropertieReader.getProperty("headerSingapore");
	String weatherSecondaryMenu = PropertieReader.getProperty("weatherSecondaryMenu");
	String headerAllSections = PropertieReader.getProperty("headerAllSections");
	String singaporeWeather = PropertieReader.getProperty("singaporeWeather");

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void launchUrl(String url) {
		getUrl(url);
	}

	public String getLatestHeadLine() {
		return getText(latestHeadline);
	}

	public void clickLatestHeadLine() {
		click(latestHeadline);
	}

	public String getLatestHeadLineSingapore() {
		return getText(latestHeadlineSingapore);
	}

	public void clickLatestHeadLineSingapore() {
		click(latestHeadlineSingapore);
	}

	public void selectSingapore() {
		click(headerSingapore);
	}

	public void selectAllSections() {
		click(headerAllSections);
	}

	public void clickWeather() {
		clickElements(weatherSecondaryMenu);
	}

	public String captureSingaporeWeather() {
		return getText(singaporeWeather);
	}

}
