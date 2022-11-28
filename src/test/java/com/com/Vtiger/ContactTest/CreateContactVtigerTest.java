package com.com.Vtiger.ContactTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.com.Vtiger.objectRepository.ContactInfoPage;
import com.com.Vtiger.objectRepository.ContactPage;
import com.com.Vtiger.objectRepository.CreateContactPage;
import com.com.Vtiger.objectRepository.HomePage;
import com.com.Vtiger.objectRepository.LoginPage;
import com.comcase.genericutility.ExcelUtility;
import com.comcase.genericutility.FileUtility;
import com.comcase.genericutility.IConstants;
import com.comcase.genericutility.JavaUtility;
import com.comcase.genericutility.WebDriverUtility;
@Listeners(com.comcase.genericutility.ListnerImpltn.class)
public class CreateContactVtigerTest {
@Test(groups = "SmokeTest",retryAnalyzer = com.comcase.genericutility.RetryAnalyImp.class)
	public void createContactVtiger() throws IOException {
		// TODO Auto-generated method stub
		JavaUtility jLib = new JavaUtility();
		 FileUtility fLib = new FileUtility();
		 ExcelUtility eLib = new ExcelUtility();
		 WebDriverUtility wLib = new WebDriverUtility();
		 String BROWSER = fLib.getPropertyValue("browser");
		 String URL = fLib.getPropertyValue("url");
		 String USERNAME = fLib.getPropertyValue("username");
		 String PASSWORD = fLib.getPropertyValue("password");
		System.setProperty(IConstants.chromekey, IConstants.chromevalue);
		 //WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//get random number
		 int randNum = jLib.getRandomNum();
		 //fetch the first name from excel
		 String firstname=eLib.getDataFromExcel("Contact", 1, 0)+randNum;
         
		 //fetch the last name from excel
		 String lastname=eLib.getDataFromExcel("Contact", 1, 1)+randNum;
		//maximize the browser
		wLib.maximizeTheBrowser(driver);
		
		//implicitly wait for 10 seconds
		wLib.waitTillPageGetsLoad(driver);
		
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//enter the url of Vtiger application
		driver.get(URL);
		
		//enter the username and password click on login button
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApps(USERNAME, PASSWORD);
		//click on contact link
		HomePage homepage=new HomePage(driver);
		homepage.getContactsLink().click();
		
		//click on contactlookup image
		ContactPage contactpage=new ContactPage(driver);
		contactpage.getCnctLkpImg().click();
		
		//enter contact name and click on save button
		CreateContactPage createcontactpage=new CreateContactPage(driver);
		createcontactpage.createContact(firstname, lastname);
		createcontactpage.getSaveBtn().click();
		//verify
		ContactInfoPage contactinfopage=new ContactInfoPage(driver);
		String contact=contactinfopage.getContactName().getText();
		Assert.fail();
		//assertion 
		SoftAssert softassert = new SoftAssert();
	    softassert.assertTrue(contact.contains(lastname));
		Reporter.log("test is pass",true);
		softassert.assertAll();
		
		/*if(contact.contains(lastname)) {
			System.out.println("is created");
			
		}else {
			System.out.println("not created");
		}*/
		//mouseover on adminstrator link click on signout link
		homepage.Logout(driver);
		//quit the browser
		driver.quit();
	}

}
