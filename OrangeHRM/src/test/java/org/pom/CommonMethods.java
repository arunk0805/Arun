package org.pom;

import java.util.List;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CommonMethods extends BaseClass {

	public static void dropDown(String selectText) {
		List<WebElement> list = findElements("//div[@role='listbox']//div//span");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(selectText)) {
				System.out.println(list.get(i).getText() + " selectText");
				list.get(i).click();
				break;
			}
		}
	}

	public static void selectPage(String element, String selectText) {
		List<WebElement> list = findElements(element);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(selectText)) {
				list.get(i).click();
				break;
			}
		}
	}
	public static void verifyAssert(WebElement element, String message) {
		explicitWait(3, element);
		String successMsg = element.getText();
		Assert.assertEquals(successMsg, message);

	}
	
	public static void hintDropDown(String element1,String hintText,String element2, String selectText) {
		locatorByXpath(element1).sendKeys(hintText);
		List<WebElement> list = findElements(element2);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(selectText)) {
				list.get(i).click();
				break;
			}
		}
	}

}
