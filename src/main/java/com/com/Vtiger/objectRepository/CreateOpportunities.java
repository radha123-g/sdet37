package com.com.Vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcase.genericutility.WebDriverUtility;

public class CreateOpportunities extends WebDriverUtility{
    //initiliazation
	public CreateOpportunities(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//declaration
	@FindBy(name="potentialname")
	private WebElement oppName;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement orglkupimg;
	
	@FindBy(name="search_text")
	private WebElement srchOrgEdt;
	
	@FindBy(name="search")
	private WebElement serchBtn;
	@FindBy(name = "button")
	private WebElement saveBtn;
	
 //utilization
	public WebElement getOppName() {
		return oppName;
	}
	
    public WebElement getSaveBtn() {
		return saveBtn;
	}
    public void creatoppName(String oppoName) {
    oppName.sendKeys(oppoName);
    }
    public void selectOrgName(WebDriver driver,String orgname) {
    	orglkupimg.click();
        switchToWindow(driver, "Accounts&action");
        srchOrgEdt.sendKeys(orgname);
        serchBtn.click();
        driver.findElement(By.xpath("//a[.='"+orgname+"']")).click();
        switchToWindow(driver, "Potentials&action");
    }
    
}
