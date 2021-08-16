package pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseMethods {
	WebDriver driver;

	public BaseMethods(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void scrollToEnd() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void scrollUp(String size) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + size + ")");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void scrollDown(String size) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + size + ")");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void scrollToView(String e) {
		By locator = ObjectLocators.getBySelector(e);
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void click(String e) {
		By locator = ObjectLocators.getBySelector(e);
		WebElement element = driver.findElement(locator);
		element.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void clickElements(String e) {
		By locator = ObjectLocators.getBySelector(e);
		List<WebElement> element = driver.findElements(locator);
		element.get(1).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void getUrl(String url) {
		driver.get(url);
	}

	public String getText(String text) {
		By locator = ObjectLocators.getBySelector(text);
		WebElement element = driver.findElement(locator);
		return element.getText();
	}

}
