package com.com.Vtiger.Organisation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganationTest {
	@Test(groups = "SmokeTest")
 public void createOrganationTest() throws IOException  {
	 WebDriver driver=null;
	 JavaUtility jLib = new JavaUtility();
	 FileUtility fLib = new FileUtility();
	 ExcelUtility eLib = new ExcelUtility();
	 WebDriverUtility wLib = new WebDriverUtility();
	 //fetch the data from property file
	 String BROWSER = fLib.getPropertyValue("browser");
	 String URL = fLib.getPropertyValue("url");
	 String USERNAME = fLib.getPropertyValue("username");
	 String PASSWORD = fLib.getPropertyValue("password");
	  if(BROWSER.equalsIgnoreCase("chrome")) {
			 System.setProperty(IConstants.chromekey, IConstants.chromevalue);
			 //WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
		 }else  if(BROWSER.equalsIgnoreCase("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
			  driver=new FirefoxDriver();
		 }else {
			 driver=new ChromeDriver();
		 }
		 //to get the Random number
		 /*Random random=new Random();
		 int randomNum=random.nextInt();*/
		 int randNum = jLib.getRandomNum();
		 
		 //fetch the data from excel
		 /*FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\testcase1.xlsx");
		 Workbook workbook=WorkbookFactory.create(fis1);
		 Sheet sheet=workbook.getSheet("Organisation");
		 Row row=sheet.getRow(1);
		 Cell cell=row.getCell(2);
		 String value=cell.toString();
		 String orgName=value+randomNum;*/
		 String orgName = eLib.getDataFromExcel("Organisation", 1, 2)+randNum;
		 
		 
		 
		
		//maximize the browser
		//driver.manage().window().maximize();
		wLib.maximizeTheBrowser(driver);
		
		//implicitly wait for 10 seconds
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	 
		wLib.waitTillPageGetsLoad(driver);
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 
		//enter the url of Vtiger application
		driver.get(URL);
		
		//enter the username and password click on save button
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApps(USERNAME, PASSWORD);
		
		//click on organisation link
		HomePage homepage=new HomePage(driver);
		homepage.getOrganizationLink().click();
		
		//click on create organisation lookup image
		OrganisationPage organisationPage=new OrganisationPage(driver);
		organisationPage.getOrganisationlkpImg().click();
		
		//enter the organisation name and click on save button
		CreateOrgnisationPage createOrganisationPage=new CreateOrgnisationPage(driver);
		createOrganisationPage.createOrg(orgName);
		createOrganisationPage.getSaveBtn().click();
		
		//verify whether organisation is created or not
		OrganisationInfoPage organisationInfo=new OrganisationInfoPage(driver);
		String name=organisationInfo.getOrgName().getText();
		if(name.contains(orgName)) {
			System.out.println("organisation is created");
		}
		else {
			System.out.println("not created");
		}
		 WebElement administrator=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 //Actions ac=new Actions(driver);
		 //ac.moveToElement(ele).perform();
		 wLib.mouseOverOnElement(driver, administrator);
		 
		 //click on signout link
		homepage.Logout(driver);
		
		 //quit the browser
		 driver.quit();
 }
}
