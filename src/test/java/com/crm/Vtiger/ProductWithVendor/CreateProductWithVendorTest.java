package com.crm.Vtiger.ProductWithVendor;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.com.Vtiger.objectRepository.CreateProduct;
import com.com.Vtiger.objectRepository.CreateVendor;
import com.com.Vtiger.objectRepository.HomePage;
import com.com.Vtiger.objectRepository.LoginPage;
import com.com.Vtiger.objectRepository.ProductInfo;
import com.com.Vtiger.objectRepository.ProductPage;
import com.com.Vtiger.objectRepository.VendorInfo;
import com.com.Vtiger.objectRepository.VendorPage;
import com.comcase.genericutility.ExcelUtility;
import com.comcase.genericutility.FileUtility;
import com.comcase.genericutility.JavaUtility;
import com.comcase.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;





public class CreateProductWithVendorTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
       JavaUtility jLib=new JavaUtility();
       ExcelUtility eLib=new ExcelUtility();
       FileUtility fLib=new FileUtility();
       WebDriverUtility wLib=new WebDriverUtility();
       String BROWSER=fLib.getPropertyValue("browser");
       String URL = fLib.getPropertyValue("url");
       String USERNAME = fLib.getPropertyValue("username");
       String PASSWORD = fLib.getPropertyValue("password");
		//maximize the browser
        wLib.maximizeTheBrowser(driver);
		
		//implicitly wait for 10 seconds
		wLib.waitTillPageGetsLoad(driver);
		
		//enter the url of Vtiger application
		driver.get(URL);
		
		//enter the username aand password click on login
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginToApps(USERNAME, PASSWORD);
		
		//mouseOver on more link click on vendors link
		HomePage homepage=new HomePage(driver);
		homepage.getMorelink().click();
		homepage.getVendorslink().click();
		
		//click on vendorlookupImage
		VendorPage vendorpage=new VendorPage(driver);
		vendorpage.getVendorlkpImg().click();
		//get a random number
          int randomNumber = jLib.getRandomNum();
		//fetch the data from excel sheet
          String vendorName=eLib.getDataFromExcel("Contact", 1, 2)+randomNumber;
	     //create vendorname click on save button
          CreateVendor createvendor=new CreateVendor(driver);
          createvendor.createvendorname(vendorName);
          createvendor.getSaveBtn().click();
          
         //verify
		VendorInfo vendorinfopage=new VendorInfo(driver);
		String vendorinfo=vendorinfopage.getVendorHeader().getText();
	    if(vendorinfo.contains(vendorName)) {
	    	System.out.println("Vendor is created");
	    }else {
	    	System.out.println(" not created");
	    }
	   //click on product link
	    HomePage homepage1=new HomePage(driver);
	    homepage1.getProductslink().click();
	    
	   //click on product lookupimg
	    ProductPage productpage=new ProductPage(driver);
	    productpage.getProductlkpImg().click();
	    String proName=eLib.getDataFromExcel("Contact", 1, 3)+randomNumber;
	    //enter product name click on save button
	    CreateProduct createproduct=new CreateProduct(driver);
	    createproduct.createProduct(proName);
	   vendorpage.getVendorlkpImg().click();
	   createproduct.selectVendName(driver, vendorName);
	   createproduct.getSaveBtn().click();
		//verify
	   ProductInfo productinfo=new ProductInfo(driver);
	   String product=productinfo.getProductHeader().getText();
	   if(product.contains(proName)) {
            	   System.out.println("product is created");
               }else
               {
            	   System.out.println("not created");
               }
               //mouseover on adminstrator link n signout
     	    homepage.Logout(driver);
     	      // quit the browser
     	    driver.quit();
     	    
	}
	
	}
	


