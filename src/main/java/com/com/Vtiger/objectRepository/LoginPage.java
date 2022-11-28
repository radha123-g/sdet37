package com.com.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement userpasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement submitBtn;
	
	//utilization
	public WebElement getusernameEdt() {
		return usernameEdt;
	}
	public WebElement getpasswordEdt() {
		return userpasswordEdt;
	}
	public WebElement getsubmitBtn() {
		return submitBtn;
	}
	public void loginToApps(String username,String password) {
		usernameEdt.sendKeys(username);
		userpasswordEdt.sendKeys(password);
		submitBtn.click();
	}
}
