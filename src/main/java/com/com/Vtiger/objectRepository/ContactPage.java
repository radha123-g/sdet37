package com.com.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
//initialization
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement cnctLkupImg;
	//utilization
	public WebElement getCnctLkpImg() {
		return cnctLkupImg;
	}
}
