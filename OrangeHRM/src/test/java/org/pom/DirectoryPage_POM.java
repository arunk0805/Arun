package org.pom;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DirectoryPage_POM extends BaseClass {

	public DirectoryPage_POM() {
		PageFactory.initElements(driver, this);
	}

	String selectPage = "//ul[@class='oxd-main-menu']//following::li";

	@FindBy(xpath = "//span[text()='Directory']")
	private WebElement directoryPage;

	@FindBy(xpath = "//a[text()='Add Employee']")
	private WebElement addEmployee;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstNameBox;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastNameBox;

	@FindBy(xpath = "//button[text()[contains(.,'Save')]]")
	private WebElement saveBtn;

	@FindBy(xpath = "//a[text()='Job']")
	private WebElement addJobBtn;

	@FindBy(xpath = "//label[text()='Job Title']//parent::div//following-sibling::div")
	private WebElement jobTitleBox;

	@FindBy(xpath = "//label[text()='Location']//parent::div//following-sibling::div")
	private WebElement locationBox;

	@FindBy(xpath = "//label[text()='Job Title']//parent::div//following-sibling::div")
	private WebElement jobTitleName;

	@FindBy(xpath = "//label[text()='Employee Name']/parent::div//following-sibling::div")
	private WebElement employeeNameField;

	@FindBy(xpath = "//label[text()='Job Title']/parent::div//following-sibling::div")
	private WebElement jobTitleField;

	@FindBy(xpath = "//label[text()='Location']/parent::div//following-sibling::div")
	private WebElement locationField;

	@FindBys(@FindBy(xpath = "//div[@role='listbox']//div[@role='option']//span"))
	private WebElement dropDown;

	@FindBy(xpath = "//button[@type='reset']")
	private WebElement reset;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement search;

	@FindBy(xpath = "//span[text()='(1) Record Found']")
	private WebElement verifyMessage;

	@FindBy(xpath = "//p[text()='AHardik  Pandya ']")
	private WebElement verifyLoaction;

	@FindBy(xpath = "//a[text()='Employee List']")
	private WebElement empList;

	@FindBy(xpath = "//div[text()='AHardik ']/parent::div//following-sibling::div//button//i[contains(@class,'bi-trash')]")
	private WebElement deleteBtn;

	@FindBy(xpath = "//button[text()[contains(.,'Yes, Delete')]]")
	private WebElement checkBoxDeletBtn;

	@FindBy(css = "p[class*='toast-message']")
	private WebElement successMessage;

	public WebElement getDirectoryPage() {
		return directoryPage;
	}

	public WebElement getAddEmployee() {
		return addEmployee;
	}

	public WebElement getFirstNameBox() {
		return firstNameBox;
	}

	public WebElement getLastNameBox() {
		return lastNameBox;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getAddJobBtn() {
		return addJobBtn;
	}

	public WebElement getJobTitleBox() {
		return jobTitleBox;
	}

	public WebElement getLocationBox() {
		return locationBox;
	}

	public WebElement getJobTitleName() {
		return jobTitleName;
	}

	public WebElement getEmployeeNameField() {
		return employeeNameField;
	}

	public WebElement getJobTitleField() {
		return jobTitleField;
	}

	public WebElement getLocationField() {
		return locationField;
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public WebElement getReset() {
		return reset;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getVerifyMessage() {
		return verifyMessage;
	}

	public WebElement getVerifyLoaction() {
		return verifyLoaction;
	}

	public WebElement getEmpList() {
		return empList;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getCheckBoxDeletBtn() {
		return checkBoxDeletBtn;
	}

	public WebElement getSuccessMessage() {
		return successMessage;
	}

	public void addEmployee() throws Exception {
		CommonMethods.selectPage(selectPage, "PIM");
		getAddEmployee().click();
		getFirstNameBox().sendKeys("AHardik");
		getLastNameBox().sendKeys("Pandya");
		getSaveBtn().click();
		explicitWait(3, getSuccessMessage());
		String successMsg = getSuccessMessage().getText();
		System.out.println("Add Employee " + successMsg);
		Assert.assertEquals(successMsg, "Successfully Saved");

		getAddJobBtn().click();
		getJobTitleField().click();
		CommonMethods.dropDown("QA Engineer");
		getLocationField().click();
		CommonMethods.dropDown("Texas R&D");
		getSaveBtn().click();
		CommonMethods.verifyAssert(getSuccessMessage(), "Successfully Updated");
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Directory']")));
		getDirectoryPage().click();
		//CommonMethods.selectPage(selectPage, "Directory");
		getEmployeeNameField().sendKeys("AHradik");
		CommonMethods.dropDown("AHardik  Pandya");
		getSearch().click();
		CommonMethods.verifyAssert(getVerifyMessage(), "(1) Record Found");
	}

	public void verifyEmpName() {
		// CommonMethods.selectPage(selectPage, "Directory");
//		CommonMethods.selectPage(selectPage, "Admin");
//		getEmployeeNameField().sendKeys("AHradik");
//		CommonMethods.dropDown("AHardik  Pandya");
//		getSearch().click();
//		CommonMethods.verifyAssert(getVerifyMessage(), "(1) Record Found");

	}

	public void verifyEmpJobTitle() {

	}

	public void verifyEmpLocation() {

	}

}
