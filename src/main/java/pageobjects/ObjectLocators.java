package pageobjects;

import org.openqa.selenium.By;

public class ObjectLocators {

	public static By getBySelector(String propKey) {
		// get the value from selenium.properties and split the type and value
		String[] split = propKey.split(";");
		String type = split[0];

		// generate the By selector based on the type
		if (type.equalsIgnoreCase("id")) {
			return By.id(split[1]);
		} else if (type.equalsIgnoreCase("css")) {
			return By.cssSelector(split[1]);
		} else if (type.equalsIgnoreCase("tagname")) {
			return By.tagName(split[1]);
		} else if (type.equalsIgnoreCase("classname") || type.equalsIgnoreCase("class")) {
			return By.className(split[1]);
		} else if (type.equalsIgnoreCase("name")) {
			return By.name(split[1]);
		} else if (type.equalsIgnoreCase("xpath")) {
			return By.xpath(split[1]);
		} else if (type.equalsIgnoreCase("link")) {
			return By.linkText(split[1]);
		} else {
			throw new RuntimeException("Invalid element locator parameter -" + propKey);
		}
	}
}
