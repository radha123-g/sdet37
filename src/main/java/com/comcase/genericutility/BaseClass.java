package com.comcase.genericutility;
/**
 * 
 * @author SanjayBabu
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.com.Vtiger.objectRepository.HomePage;
import com.com.Vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver sdriver;
	public WebDriver driver;
	public DatabaseUtility dLib=new DatabaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility  wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();

	/**
	 * connecting to database
	 */
	@BeforeSuite
	public void dbConfig()
	{
		//dLib.connectToDB();
	}
	/**
	 * launching the browser
	 * @throws Throwable
	 */
	
	@BeforeClass
	public void launchTheBrowser()
	{  
		String BROWSER = null;
		try {
			BROWSER = fLib.getPropertyValue("browser");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(BROWSER);
		String URL = null;
		try {
			URL = fLib.getPropertyValue("url");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else {
			driver=new ChromeDriver();
		}

		System.out.println("Browser successfully launched");
		//implicitly wait
		sdriver=driver;
		wLib.waitTillPageGetsLoad(driver);
		//enter the URL of the Application
		sdriver.get(URL);
		//maximize the screen
		driver.manage().window().maximize();
	}
	/**
	 * login to application
	 */
	@BeforeMethod(enabled=false)
	public void loginToAppln()
	{
		String USERNAME = null;
		try {
			USERNAME = fLib.getPropertyValue("username");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		String PASSWORD = null;
		try {
			PASSWORD = fLib.getPropertyValue("password");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		LoginPage lpage=new LoginPage(driver);
		lpage.loginToApps(USERNAME, PASSWORD);
		System.out.println("Login successful");
	}
	
	/**
	 * logout from application
	 */
	@AfterMethod(enabled=false)
	public void logoutFromAppln()
	{
		HomePage hpage=new HomePage(driver);
		hpage.Logout(driver);
		System.out.println("Logout successful");
	}
	/**
	 * close the browser
	 */
	@AfterClass
	public void closeTheBrowser()
	{
		driver.quit();
		System.out.println("Browser successfully closed");
	}
	/**
	 * close database configuration
	 */
	@AfterSuite
	public void closeDBconfig()
	{
		dLib.closeDB();
	}
}