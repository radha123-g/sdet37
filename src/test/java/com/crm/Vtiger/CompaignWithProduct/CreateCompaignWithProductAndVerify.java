package com.crm.Vtiger.CompaignWithProduct;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCompaignWithProductAndVerify {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		//maximize the browser
		driver.manage().window().maximize();
		
		//implicitly wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//enter the url of Vtiger application
		driver.get("http://localhost:8888/");
		
		//enter the username
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		//enter the password
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		//click on login
		driver.findElement(By.id("submitButton")).click();
		//mouseOver on more link
				WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
				Actions ac=new Actions(driver);
				ac.moveToElement(element).perform();
				driver.findElement(By.xpath("//a[.='Campaigns']")).click();
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				driver.findElement(By.name("campaignname")).sendKeys("mmm");
				driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
				 Set<String> selectname=driver.getWindowHandles();
				   for(String string:selectname) {
					   driver.switchTo().window(string);
					   String title=driver.getTitle();
					   if(title.contains("Products&action")) {
						   break;
					   }
				   }
					   driver.findElement(By.name("search_text")).sendKeys("xxx");
					   driver.findElement(By.name("search")).click();
					   driver.findElement(By.xpath("//a[.='xxx']")).click();
					   Set<String> mainwindow=driver.getWindowHandles();
					   for(String stings:mainwindow) {
						   driver.switchTo().window(stings);
						   String title1=driver.getTitle();
						   if(title1.contains("Campaigns&action")) {
							   break;
						   }
					   }
					   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					   String compaign=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
                       if(compaign.contains("mmm")) {
                    	   System.out.println("compaign is created");
                       }
                       else {
                    	   System.out.println("not created");
                       }
                       WebElement emt=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
                       Actions a=new Actions(driver);
                       a.moveToElement(emt).perform();
                       driver.findElement(By.xpath("//a[.='Sign Out']")).click();
				   }
                       }
	


