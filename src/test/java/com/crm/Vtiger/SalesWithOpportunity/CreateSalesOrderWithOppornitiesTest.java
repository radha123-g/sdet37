package com.crm.Vtiger.SalesWithOpportunity;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateSalesOrderWithOppornitiesTest {

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
		Random random=new Random();
		int createopp=random.nextInt(100);
		String salesOrder="sales"+createopp;
		//click on login
				driver.findElement(By.id("submitButton")).click();
				//mouseOver on more link
				WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
				Actions ac=new Actions(driver);
				ac.moveToElement(element).perform();
				driver.findElement(By.name("Sales Order")).click();
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				driver.findElement(By.name("subject")).sendKeys(salesOrder);
				driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
				 Set<String> selectname=driver.getWindowHandles();
				   for(String string:selectname) {
					   driver.switchTo().window(string);
					   String title=driver.getTitle();
					   if(title.contains("Potentials&action")) {
						   break;
					   }
				   }
				   driver.findElement(By.name("search_text")).sendKeys("sales82");
				   driver.findElement(By.name("search")).click();
				   driver.findElement(By.id("2")).click();
				   Set<String> selectname1=driver.getWindowHandles();
				   for(String string1:selectname1) {
					   driver.switchTo().window(string1);
					   String title=driver.getTitle();
					   if(title.contains("SalesOrder&action")) {
						   break;
					   }
				   }
				   driver.findElement(By.name("bill_street")).sendKeys("Bangalore");
				   driver.findElement(By.name("ship_street")).sendKeys("Mangalore");
				   driver.findElement(By.id("searchIcon1")).click();
				   Set<String> selectname2=driver.getWindowHandles();
				   for(String string2:selectname2) {
					   driver.switchTo().window(string2);
					   String title=driver.getTitle();
					   if(title.contains("Potentials&action")) {
						   break;
					   }
				   }
				   driver.findElement(By.name("search_text")).sendKeys("pen722");
				   driver.findElement(By.name("search")).click();
				   driver.findElement(By.xpath("//a[.='pen722']")).click();
				   Set<String> selectname3=driver.getWindowHandles();
				   for(String string3:selectname3) {
					   driver.switchTo().window(string3);
					   String title=driver.getTitle();
					   if(title.contains("SalesOrder&action")) {
						   break;
					   }
				   }
				   driver.findElement(By.id("qty1")).sendKeys("2");
				   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				   String product=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		           if(product.contains(salesOrder)) {
		        	   System.out.println("salesorder is created");
		           }else
		           {
		        	   System.out.println("not created");
		           }
		           Thread.sleep(1000);		           
		           //mouseover on adminstrator link
		 	      WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 	      Actions a=new Actions(driver);
		 	      a.moveToElement(ele).perform();
		 	      
		 	      // click on signout link
		 	      driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
