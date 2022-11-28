package com.crm.Vtiger.OpportunitiesWithOrganisation;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.com.Vtiger.objectRepository.CreateOpportunities;
import com.com.Vtiger.objectRepository.HomePage;
import com.com.Vtiger.objectRepository.LoginPage;
import com.com.Vtiger.objectRepository.OppornutiesPage;
import com.com.Vtiger.objectRepository.OpportunitiesInfo;
import com.comcase.genericutility.ExcelUtility;
import com.comcase.genericutility.FileUtility;
import com.comcase.genericutility.JavaUtility;
import com.comcase.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOportunitiesWithOrganisationTest {

	public static void main(String[] args) throws IOException {
		
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		//maximize the browser
		wLib.maximizeTheBrowser(driver);
		
		//implicitly wait for 10 seconds
		wLib.waitTillPageGetsLoad(driver);
		 //fetch the data from property file
		 String BROWSER = fLib.getPropertyValue("browser");
		 String URL = fLib.getPropertyValue("url");
		 String USERNAME = fLib.getPropertyValue("username");
		 String PASSWORD = fLib.getPropertyValue("password");
		
		//enter the url of Vtiger application
		driver.get(URL);
		
		
		int createopp=jLib.getRandomNum();
		String createoppName=eLib.getDataFromExcel("Contact", 1, 4)+createopp;
		 String orgName=eLib.getDataFromExcel("Organisation", 1, 2);
		//enter username and password click on login
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginToApps(USERNAME, PASSWORD);
		
		//click on opportunities link
		HomePage homepage=new HomePage(driver);
		homepage.getOpportunitieslink().click();
		
		//click on opportunity lookup img
	    OppornutiesPage opportunitypage=new OppornutiesPage(driver);
	    opportunitypage.getOpplkupimg().click();
	    
	    //create opponame click on save buttuon
	    CreateOpportunities createoppo=new CreateOpportunities(driver);
	    createoppo.creatoppName(createoppName);
	    createoppo.selectOrgName(driver, orgName);
	    createoppo.getSaveBtn().click();
	    //verify
	   OpportunitiesInfo oppoInfo=new OpportunitiesInfo(driver);
	   String product=oppoInfo.getOppHeader().getText();
           if(product.contains(createoppName)) {
        	   System.out.println("opportunity is created");
           }else
           {
        	   System.out.println("not created");
           }
           //mouseover on adminstrator link
 	        homepage.Logout(driver);
 	      
 	      // quit the browser
 	      driver.quit();
		   

	}

}
