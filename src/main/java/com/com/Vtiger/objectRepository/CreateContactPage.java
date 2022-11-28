package com.com.Vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcase.genericutility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
//initialization
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(name="firstname")
	private WebElement firstnameEdt;
	
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//img=[@src='themes/softed/images/select.gif']")
	private WebElement selectLkupImg;
	
	@FindBy(name="search_text")
	private WebElement srchOrgEdt;
	
	@FindBy(name="search")
	private WebElement serchBtn;
	
	//utilization
	public WebElement getFirstName() {
		return firstnameEdt;
	}
	public WebElement getLastname() {
		return lastnameEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createContact(String enterFirstName,String enterLastname) {
		firstnameEdt.sendKeys(enterFirstName);
		lastnameEdt.sendKeys(enterLastname);
	}
	public void selectOrg(WebDriver driver,String orgname) {
		selectLkupImg.click();
		switchToWindow(driver, "Accounts&action");
		srchOrgEdt.sendKeys(orgname);
		serchBtn.click();
		driver.findElement(By.xpath("//a[.='"+orgname+"']")).click();
		switchToWindow(driver, "Contacts&action");
	}
}
