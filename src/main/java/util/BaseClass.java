package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	protected WebDriver driver;

	public BaseClass() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\drivers\\chrome92\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public void waitForPageToLoad(int seconds) {
		driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
	}

	public void maximizePage() {
		driver.manage().window().maximize();
	}

	public void closeBrowser() {
		driver.close();
	}

}
