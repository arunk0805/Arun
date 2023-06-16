package org.runner;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.pom.LoginPage_POM;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SC01_Login extends BaseClass {
	WebDriver driver;

	@BeforeMethod
	public void loadUrl() {
		browserLaunch("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test
	public void validInput() throws Exception {
		LoginPage_POM login = new LoginPage_POM();
		login.login(getPropertyValue("username"), getPropertyValue("password"));
	}
	@Test
	public void validInputWithEnterKey() throws Exception {
		LoginPage_POM login = new LoginPage_POM();
		login.loginWithEnterKey(getPropertyValue("username"), getPropertyValue("password"));
	}
	@Test
	public void invalidUser() throws Exception {
		LoginPage_POM login = new LoginPage_POM();
		login.login(getPropertyValue("invalidUserame"), getPropertyValue("password"));

	}
	@Test
	public void invalidPass() throws Exception {
		LoginPage_POM login = new LoginPage_POM();
		login.login(getPropertyValue("username"), getPropertyValue("invalidPassword"));

	}
	@Test
	public void invalidInput() throws Exception {
		LoginPage_POM login = new LoginPage_POM();
		login.login(getPropertyValue("invalidUserame"), getPropertyValue("invalidPassword"));

	}
	@Test
	public void withoutInput() throws Exception {
		LoginPage_POM login = new LoginPage_POM();
		login.login(getPropertyValue("blankUsername"), getPropertyValue("blankPassword"));

	}
	@AfterMethod
	public void closeBrowser() {
		quite();
	}
	
	
	

	


}
