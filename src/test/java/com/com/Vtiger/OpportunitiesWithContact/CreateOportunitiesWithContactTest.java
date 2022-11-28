package com.com.Vtiger.OpportunitiesWithContact;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOportunitiesWithContactTest {

	public static void main(String[] args) {
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
		Random random=new Random();
		int createopp=random.nextInt(100);
		String opportunity="sales"+createopp;
		//click on login
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Opportunities']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("potentialname")).sendKeys(opportunity);
		WebElement contact=driver.findElement(By.id("related_to_type"));
		Select s=new Select(contact);
		s.selectByValue("Contacts");

		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		 Set<String> selectname=driver.getWindowHandles();
		   for(String string:selectname) {
			   driver.switchTo().window(string);
			   String title=driver.getTitle();
			   if(title.contains("Contacts&action")) {
				   break;
			   }
		   }
		   driver.findElement(By.name("search_text")).sendKeys(opportunity);
		   driver.findElement(By.name("search")).click();
		   driver.findElement(By.id("2")).click();
		   Set<String> selectname1=driver.getWindowHandles();
		   for(String string1:selectname1) {
			   driver.switchTo().window(string1);
			   String title=driver.getTitle();
			   if(title.contains("Potentials&action")) {
				   break;
			   }
		   }
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   String product=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
           if(product.contains(opportunity)) {
        	   System.out.println("opportunity is created");
           }else
           {
        	   System.out.println("not created");
           }
           //mouseover on adminstrator link
 	      WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 	      Actions a=new Actions(driver);
 	      a.moveToElement(ele).perform();
 	      
 	      // click on signout link
 	      driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		   
	}

}
