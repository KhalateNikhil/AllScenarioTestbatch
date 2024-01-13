package UtilityLayer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class Wait extends BaseClass {

	public static int time = 30;

	public static WebElement visibilityStatus(WebElement wb) {
		return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(wb));
	}

	public static List<WebElement> visibilityAll(WebElement wb) {
		return new WebDriverWait(driver, Duration.ofSeconds(time))
				.until(ExpectedConditions.visibilityOfAllElements(wb));

	}

	public static void sendKeys(WebElement wb, String value) {
		visibilityStatus(wb).sendKeys(value);
	}

	public static void click(WebElement wb) {
		visibilityStatus(wb).click();

	}

	public static String getText(WebElement wb) {
		return visibilityStatus(wb).getText();
	}

	public static String getAttribute(WebElement wb, String keyname) {
		return visibilityStatus(wb).getAttribute(keyname);
	}

	public static boolean isSelected(WebElement wb) {
		return visibilityStatus(wb).isSelected();
	}

	public static void selectAnyCheckBox(List<WebElement> ls, String value) {
		for (WebElement wb1 : ls) {
			if (wb1.getText().equalsIgnoreCase(value)) {
				wb1.click();
				break;
			}
		}
	}

}
