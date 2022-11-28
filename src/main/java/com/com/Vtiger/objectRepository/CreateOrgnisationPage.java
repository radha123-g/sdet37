package com.com.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcase.genericutility.WebDriverUtility;

public class CreateOrgnisationPage extends WebDriverUtility{
 //initialization
	public CreateOrgnisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(name="accountname") private WebElement orgNameEdt;

   @FindBy(xpath = "//input[@title='Save [Alt+S]']")
   private WebElement saveBtn;
   @FindBy(name="industry")
   private WebElement industryDrpDwn;
   
   @FindBy(name="accounttype")
   private WebElement typeDrpDwn;
   
   //utilization
   public WebElement getOrgnameEdt() {
	   return orgNameEdt;
}
   public WebElement getSaveBtn() {
	return saveBtn;
}
   public void createOrg(String orgname) {
	orgNameEdt.sendKeys(orgname);
}
   public void selectIndustry(String Industry) {
	select(Industry, industryDrpDwn);
}
   public void selectType(String type) {
	   select(type, typeDrpDwn);
   }
}
