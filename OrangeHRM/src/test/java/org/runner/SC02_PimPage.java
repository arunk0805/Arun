package org.runner;

import static org.testng.Assert.assertEquals;
import org.baseclass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.pom.LoginPage_POM;
import org.pom.PimPage_POM;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SC02_PimPage extends BaseClass {
	WebDriver driver;

	@BeforeMethod
	public void loadUrl() {
		browserLaunch("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test
	public void addNewReport() throws Exception {
		LoginPage_POM login = new LoginPage_POM();
		PimPage_POM pim = new PimPage_POM();
		login.login(getPropertyValue("username"), getPropertyValue("password"));
		pim.addReport();
		pim.editReport();
		pim.deleteReport();
		
	}
	
//	@AfterMethod
//	public void closeBrowser() {
//		quite();
//	}
	
	
	

	


}
