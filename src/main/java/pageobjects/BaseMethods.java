package pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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
	}

	public void scrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
	}

	public void scrollUp(String size) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + size + ")");
	}

	public void scrollDown(String size) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + size + ")");
	}

	public void scrollToView(String e) {
		By locator = ObjectLocators.getBySelector(e);
		while (!isElementPresent(locator)) {
			scrollUp("-500");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

		// wait(elementToBePresent(locator)); Fluent wait
	}

	public void click(String e) {
		By locator = ObjectLocators.getBySelector(e);
		WebElement element = driver.findElement(locator);
		element.click();
	}

	public void clickElements(String e) {
		By locator = ObjectLocators.getBySelector(e);
		List<WebElement> element = driver.findElements(locator);
		element.get(1).click();
	}

	public void getUrl(String url) {
		driver.get(url);
	}

	public String getText(String text) {
		By locator = ObjectLocators.getBySelector(text);
		WebElement element = driver.findElement(locator);
		return element.getText();
	}

	public boolean isElementPresent(By by) {
		try {
			WebElement element = driver.findElement(by);
			if (element != null) {
				return true;
			}
			return false;
		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Added fluet waits , but still we get ElementClickInterceptedException
	 * exception hence couldn't avoid adding one dynamic wait
	 */
	/*
	 * public static ExpectedCondition<WebElement> elementToBePresent(By by) {
	 * return ExpectedConditions.presenceOfElementLocated(by); }
	 * 
	 * public <U> U wait(ExpectedCondition<U> condition) {
	 * 
	 * FluentWait<WebDriver> wait = new
	 * FluentWait<WebDriver>(this.driver).ignoring(RuntimeException.class)
	 * .withTimeout(30, TimeUnit.SECONDS).pollingEvery(500,
	 * TimeUnit.MILLISECONDS); try { return wait.until(condition); } catch
	 * (TimeoutException err) { return null; } }
	 */
}
