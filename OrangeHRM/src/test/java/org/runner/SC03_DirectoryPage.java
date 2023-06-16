package org.runner;

import static org.testng.Assert.assertEquals;
import org.baseclass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.pom.DirectoryPage_POM;
import org.pom.LoginPage_POM;
import org.pom.PimPage_POM;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SC03_DirectoryPage extends BaseClass {
	WebDriver driver;

	@BeforeMethod
	public void loadUrl() {
		browserLaunch("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	

	@Test(priority = 1)
	public void addNewReport() throws Exception {
		LoginPage_POM login = new LoginPage_POM();
		DirectoryPage_POM directory = new DirectoryPage_POM();
		login.login(getPropertyValue("username"), getPropertyValue("password"));
		directory.addEmployee();
		//directory.verifyEmpName();

	}
//	@Test (priority = 2)
//	public void actionsInDirectoryPage() throws Exception {
//		login.login(getPropertyValue("username"), getPropertyValue("password"));
//
//		
//
//	}

//	@AfterMethod
//	public void closeBrowser() {
//		quite();
//	}

}
