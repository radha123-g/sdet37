package com.crm.Vtiger.OrganisationWithContact;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.com.Vtiger.objectRepository.ContactInfoPage;
import com.com.Vtiger.objectRepository.ContactPage;
import com.com.Vtiger.objectRepository.CreateContactPage;
import com.com.Vtiger.objectRepository.CreateOrgnisationPage;
import com.com.Vtiger.objectRepository.HomePage;
import com.com.Vtiger.objectRepository.LoginPage;
import com.com.Vtiger.objectRepository.OrganisationInfoPage;
import com.com.Vtiger.objectRepository.OrganisationPage;
import com.comcase.genericutility.ExcelUtility;
import com.comcase.genericutility.FileUtility;
import com.comcase.genericutility.IConstants;
import com.comcase.genericutility.JavaUtility;
import com.comcase.genericutility.WebDriverUtility;

//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateOrganisationwithContactTest 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		//fetch data from propertyFile
		fLib.getPropertyValue("browser");
		String URL=fLib.getPropertyValue("url");
		String USERNAME=fLib.getPropertyValue("username");
		String PASSWORD=fLib.getPropertyValue("password");
		System.setProperty(IConstants.chromekey, IConstants.chromevalue);
		WebDriver driver=new ChromeDriver();
		
		//WebDriver driver=new ChromeDriver();
		//maximize the browser
		wLib.maximizeTheBrowser(driver);
		
		//implicitly wait for 10 seconds
		wLib.waitTillPageGetsLoad(driver); 

	   //get a random number
	   int randomNumber = jLib.getRandomNum();
	    
	   //fetch the orgname from excel
	   String firstname=eLib.getDataFromExcel("Contact", 1, 0)+randomNumber;
	   String lastname=eLib.getDataFromExcel("Contact", 1, 1)+randomNumber;
	   String orgName=eLib.getDataFromExcel("Organisation", 1, 2)+randomNumber;
	   //enter the url of apllication
	   driver.get(URL);
	   
	   //enter the username and password click login
	   LoginPage loginpage=new LoginPage(driver);
	   loginpage.loginToApps(USERNAME, PASSWORD);
	   
	   //click on organisation link
	   HomePage homepage=new HomePage(driver);
	   homepage.getOrganizationLink().click();
	   
	   //click on organisationlookupimg
	   OrganisationPage organisationpage=new OrganisationPage(driver);
	   organisationpage.getOrganisationlkpImg().click();
	   
	   //enter orgname click on save button
	   CreateOrgnisationPage createorganisation=new CreateOrgnisationPage(driver);
	   createorganisation.createOrg(orgName);
	   createorganisation.getSaveBtn().click();
	   
	    //verify the whether organation is created or not
	   OrganisationInfoPage organisationInfoPage=new OrganisationInfoPage(driver);
	   String name=organisationInfoPage.getOrgName().getText();
	   	 if(name.contains(orgName)) 
	    {
	    	System.out.println("organation is created");
	    }else 
	    {
	    	System.out.println("organation is  not created");
	    }
	    	
	    //click on contact link
	   homepage.getContactsLink().click();
	    
	    //click on create contact lookup image
	   ContactPage contactpage=new ContactPage(driver);
	   contactpage.getCnctLkpImg().click();
	   
	   //enter the Firstname and lastname click on save button
	   CreateContactPage createcontactpage=new CreateContactPage(driver);
	 createcontactpage.createContact(firstname, lastname);
	 createcontactpage.selectOrg(driver, orgName);
	 createcontactpage.getSaveBtn().click();
		   
		   //verify whether the contact is created or not
	 ContactInfoPage contactInfoPage=new ContactInfoPage(driver);
	 String contact=contactInfoPage.getContactName().getText(); 
	      if(contact.contains(lastname)) {
	    	  System.out.println("contact is created");
	    	  
	      }else {
	    	  System.out.println("not created");
	    	  
	      }
	     //click on signout link
	      homepage.Logout(driver);
	      
	      // quit the browser
	      driver.quit();
			
	   }
		
	   
	 
	}



	



