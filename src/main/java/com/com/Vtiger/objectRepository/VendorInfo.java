package com.com.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfo {
//initialization 
	public VendorInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement vendorHeader;
	//utilization
	public WebElement getVendorHeader() {
		return vendorHeader;
	}
	
	
}
