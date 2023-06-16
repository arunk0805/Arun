package org.pom;

import static org.testng.Assert.assertEquals;

import java.util.List;
import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PimPage_POM extends BaseClass {
	public PimPage_POM() {
		PageFactory.initElements(driver, this);

	}

	String selectPage = "//ul[@class='oxd-main-menu']//following::li";

	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement pimTab;

	@FindBy(xpath = "//div//following-sibling::li//a[text()='Reports']")
	private WebElement report;

	@FindBy(xpath = "//button[text()[contains(.,'Add')]]")
	private WebElement addBtn;

	@FindBy(xpath = "//label//following::input")
	private WebElement reportName;

	@FindBy(xpath = "//h6//preceding::div[text()[contains(.,'Select')]]")
	private WebElement selectionCriteria;

	@FindBys({ @FindBy(xpath = "//div[@role='listbox']//div//span") })
	private List<WebElement> dropDownBox;

	@FindBy(xpath = "//label[text()='Select Display Field Group']//parent::div//following-sibling::div")
	private WebElement selectDisplayFieldgroup;

	@FindBy(xpath = "//label[text()='Select Display Field']//parent::div//following-sibling::div")
	private WebElement displayField;

	@FindBy(xpath = "//label[text()='Select Display Field']//parent::div//following::button//i[contains(@class,'bi-plus')]")
	private WebElement addDisplayField;

	@FindBy(xpath = "//button[text()[contains(.,'Save')]]")
	private WebElement saveBtn;

	@FindBy(css = "p[class*='toast-message']")
	private WebElement successMessage;

	@FindBy(xpath = "//div[text()='Employee Report']/parent::div//following-sibling::div//button//i[contains(@class,'bi-pencil-fill')]")
	private WebElement editBtn;

	@FindBy(xpath = "//div[text()='Employee Report']//parent::div//preceding-sibling::div[@role='cell']")
	private WebElement checkBox;

	@FindBy(xpath = "//div[text()='Employee Report']/parent::div//following-sibling::div//button//i[contains(@class,'bi-trash')]")
	private WebElement deleteBtnIcon;

	@FindBy(xpath = "//button[text()[contains(.,'Yes, Delete')]]")
	private WebElement checkBoxDeletBtn;

	public WebElement getPimTab() {
		return pimTab;
	}

	public WebElement getReport() {
		return report;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getReportName() {
		return reportName;
	}

	public WebElement getSelectionCriteria() {
		return selectionCriteria;
	}

	public WebElement getSelectDisplayFieldgroup() {
		return selectDisplayFieldgroup;
	}

	public List<WebElement> getDropDownBox() {
		return dropDownBox;
	}

	public WebElement getDisplayField() {
		return displayField;
	}

	public WebElement getAddDisplayField() {
		return addDisplayField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSuccessMessage() {
		return successMessage;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getDeleteBtnIcon() {
		return deleteBtnIcon;
	}

	public WebElement getCheckBoxDeletBtn() {
		return checkBoxDeletBtn;
	}

	public void addReport() {

		CommonMethods.selectPage(selectPage, "PIM");
		getReport().click();
		getAddBtn().click();
		getReportName().sendKeys("Employee Report");
		getSelectionCriteria().click();
		CommonMethods.dropDown("Employee Name");
		getSelectDisplayFieldgroup().click();
		CommonMethods.dropDown("Personal");
		getDisplayField().click();
		CommonMethods.dropDown("Employee Id");
		getAddDisplayField().click();
		getDisplayField().click();
		CommonMethods.dropDown("Employee First Name");
		getAddDisplayField().click();
		getSaveBtn().click();
		explicitWait(3, getSuccessMessage());
		String successMsg = getSuccessMessage().getText();
		System.out.println("Add Report " + successMsg);
		Assert.assertEquals(successMsg, "Successfully Saved");

	}

	public void editReport() {
		getReport().click();
		getEditBtn().click();
		getSelectionCriteria().click();
		CommonMethods.dropDown("Education");
		getSaveBtn().click();
		explicitWait(3, getSuccessMessage());
		String successMsg = getSuccessMessage().getText();
		System.out.println("Edit report " + successMsg);
		Assert.assertEquals(successMsg, "Successfully Updated");

	}

	public void deleteReport() {
		getReport().click();
		getCheckBox().click();
		getDeleteBtnIcon().click();
		getCheckBoxDeletBtn().click();
		explicitWait(3, getSuccessMessage());
		String successMsg = getSuccessMessage().getText();
		System.out.println("Delete report " + successMsg);
		Assert.assertEquals(successMsg, "Successfully Deleted");

	}
}
