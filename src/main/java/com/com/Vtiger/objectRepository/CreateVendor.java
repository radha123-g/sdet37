package com.com.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendor {
//initialization
	public CreateVendor(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(name="vendorname")
	private WebElement vedorName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	   private WebElement saveBtn;
	//utilization

	public WebElement getVedorName() {
		return vedorName;
	}
	public void createvendorname(String vendornm) {
		vedorName.sendKeys(vendornm);
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
}
