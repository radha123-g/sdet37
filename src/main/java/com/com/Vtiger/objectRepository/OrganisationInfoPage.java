package com.com.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
//intiliaztion
	public OrganisationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ornameHeader;
	
	//utilization
	public WebElement getOrgName() {
		return ornameHeader;
	}
}
