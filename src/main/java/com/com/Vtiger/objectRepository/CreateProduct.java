package com.com.Vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcase.genericutility.WebDriverUtility;

public class CreateProduct extends WebDriverUtility{
//initialization
	public CreateProduct(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(name="productname")
	private WebElement productname;
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement vendorlkupimg;
	@FindBy(name="search_text")
	private WebElement srchText;
	@FindBy(name="search")
	private WebElement srchBtn;
	@FindBy(name = "button")
	private WebElement saveBtn;
	//utilization
	public WebElement getProductname() {
		return productname;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createProduct(String pName) {
		productname.sendKeys(pName);
	}
	public void selectVendName(WebDriver driver,String vName) {
		vendorlkupimg.click();
		switchToWindow(driver, "Vendors&action");
		srchText.sendKeys(vName);
		srchBtn.click();
		driver.findElement(By.xpath("//a[.='"+vName+"']")).click();
		switchToWindow(driver, "Products&action");
				
	}
	
}
