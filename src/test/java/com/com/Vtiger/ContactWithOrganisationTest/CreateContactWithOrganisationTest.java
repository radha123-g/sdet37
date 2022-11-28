package com.com.Vtiger.ContactWithOrganisationTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganisationTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
		//click on contact link
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("firstname")).sendKeys("achhu");
		driver.findElement(By.name("lastname")).sendKeys("alli");
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		 Set<String> selectname=driver.getWindowHandles();
		   for(String string:selectname) {
			   driver.switchTo().window(string);
			   String title=driver.getTitle();
			   if(title.contains("Accounts&action")) {
				   break;
			   }
		   }
			   driver.findElement(By.name("search_text")).sendKeys("akul");
			   driver.findElement(By.name("search")).click();
			   driver.findElement(By.xpath("//a[.='akul']")).click();
			   Set<String> mainwindow=driver.getWindowHandles();
			   for(String stings:mainwindow) {
				   driver.switchTo().window(stings);
				   String title1=driver.getTitle();
				   if(title1.contains("Contacts&action")) {
					   break;
				   }
			   }
			   driver.findElement(By.name("button")).click();
			   String contact=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
               if(contact.contains("achhu")) {
            	   System.out.println("contact is created");
               }
               else {
            	   System.out.println("not created");
               }
               Thread.sleep(20);
               WebElement emt=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
               Actions a=new Actions(driver);
               a.moveToElement(emt).perform();
               driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
