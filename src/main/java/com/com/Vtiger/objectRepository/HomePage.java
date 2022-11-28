package com.com.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcase.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(xpath = "//a[.='Organizations']")
	private WebElement organizationlink;
	
	@FindBy(xpath = "//a[.='Contacts']")
	private WebElement contactslink;
	
	@FindBy(xpath = "//a[.='Products']")
	private WebElement productslink;
	
	@FindBy(name="Vendors")
	private WebElement vendorslink;
	
	@FindBy(xpath="//a[.='Opportunities']")
	private WebElement opportunitieslink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorlink;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signoutLink;
	
	//utilization
	public WebElement getOrganizationLink() {
		return organizationlink;
	}
	public WebElement getContactsLink() {
		return contactslink;
	}
	public WebElement getMorelink() {
		return moreLink;
	}
	public WebElement getAdminstratorLink() {
		return adminstratorlink;
	}
	public WebElement getProductslink() {
		return productslink;
	}
	
	public WebElement getVendorslink() {
		return vendorslink;
	}
	
	public WebElement getOpportunitieslink() {
		return opportunitieslink;
	}
	public WebElement getSignoutLink() {
		return signoutLink;
	}
	public void Logout(WebDriver driver) {
		mouseOverOnElement(driver, adminstratorlink);
		signoutLink.click();
	}

}
