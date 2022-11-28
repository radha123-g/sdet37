package com.com.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeader;
	
	//utilization
	public WebElement getContactName() {
		return contactHeader;
	}
}
