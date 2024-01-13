package UtilityLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BaseLayer.BaseClass;

public class HandleDropDown extends BaseClass {

	public static void selectByVisibleText(WebElement wb, String value) {
		new Select(Wait.visibilityStatus(wb)).selectByVisibleText(value);
	}

	public static void selectByValue(WebElement wb, String value) {
		new Select(Wait.visibilityStatus(wb)).selectByValue(value);
	}

	public static void selectByIndex(WebElement wb, int index) {
		new Select(Wait.visibilityStatus(wb)).selectByIndex(index);
	}
}
