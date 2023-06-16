package org.pom;

import org.baseclass.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage_POM extends BaseClass {
	public LoginPage_POM() {
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(name = "username")
	private WebElement userName;
	
	@FindBy(name = "password")
	private WebElement passWord;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void login(String username, String password){
		implicitWait(15);
		getUserName().sendKeys(username);
		getPassWord().sendKeys(password);
		getLoginBtn().click();
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
		
		
	}
	public void loginWithEnterKey(String username, String password){
		implicitWait(5);
		getUserName().sendKeys(username);
		getPassWord().sendKeys(password,Keys.ENTER);	
		
	}
}

