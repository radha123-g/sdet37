package com.crm.Vtiger.InvoiceWithSalesAndOrganisation;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateInvoiceWithSalesOrderAndOrganisationTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		//maximize the browser
		driver.manage().window().maximize();
		
		//implicitly wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
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
		driver.findElement(By.name("Invoice")).click();
		 Random random =new Random();
		   int randomNumber = random.nextInt(1000);
		   String invoiceName="in"+randomNumber;
		   driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		   driver.findElement(By.name("subject")).sendKeys(invoiceName);
		   driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		   Set<String> selectname=driver.getWindowHandles();
		   for(String string:selectname) {
			   driver.switchTo().window(string);
			   String title=driver.getTitle();
			   if(title.contains("SalesOrder&action")) {
				   break;
			   }
		   }
			
				
			   driver.findElement(By.name("search_text")).sendKeys(invoiceName);
			
			   driver.findElement(By.name("search")).click();
			   driver.findElement(By.id("1")).click();
			   Set<String> selectname6=driver.getWindowHandles();
			   for(String string6:selectname6) {
				   driver.switchTo().window(string6);
				   String title=driver.getTitle();
				   if(title.contains("index.php")) {
					   break;
				   }
			   }
			   driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
			   Set<String> mainwindow=driver.getWindowHandles();
			   for(String string1:mainwindow) {
				   driver.switchTo().window(string1);
				   String title1=driver.getTitle();
				   if(title1.contains("Accounts&action")) {
					   break;
				   }
		   }
			   driver.findElement(By.name("search_text")).sendKeys("ranjan");
			
			   driver.findElement(By.name("search")).click();
			   driver.findElement(By.id("5")).click();
			   Set<String> mainwindow1=driver.getWindowHandles();
			   for(String string9:mainwindow1) {
				   driver.switchTo().window(string9);
				   String title1=driver.getTitle();
				   if(title1.contains("index.php")) {
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
				   if(title.contains("Products&action")) {
					   break;
				   }
			   }
			   driver.findElement(By.name("search_text")).sendKeys("pen722");
			   driver.findElement(By.name("search")).click();
			   driver.findElement(By.xpath("//a[.='pen722']")).click();
			   Set<String> mainwindow3=driver.getWindowHandles();
			   for(String string7:mainwindow3) {
				   driver.switchTo().window(string7);
				   String title1=driver.getTitle();
				   if(title1.contains("index.php")) {
					   break;
				   }
		   }
			   driver.findElement(By.id("qty1")).sendKeys("1");
			   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			  String product=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	           if(product.contains(invoiceName)) {
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
