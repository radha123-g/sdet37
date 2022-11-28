package com.com.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	//initialization
		public ProductPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		//declaration
		@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement productLokupimg;
		
		//utilization
		public WebElement getProductlkpImg() {
			return productLokupimg;
		}
}
