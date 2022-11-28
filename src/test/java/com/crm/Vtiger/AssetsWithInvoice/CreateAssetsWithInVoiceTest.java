package com.crm.Vtiger.AssetsWithInvoice;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAssetsWithInVoiceTest {

	public static void main(String[] args) {
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
		WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(element).perform();
		driver.findElement(By.name("Assets")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Random random =new Random();
		   int randomNumber = random.nextInt(1000);
		   String assetNum="a"+randomNumber;
		   driver.findElement(By.name("serialnumber")).sendKeys(assetNum);
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
		   
		   Set<String> selectname1=driver.getWindowHandles();
		   for(String string1:selectname1) {
			   driver.switchTo().window(string1);
			   String title=driver.getTitle();
			   if(title.contains("Assets&action")) {
				   break;
			   }
		   }
		  
		   driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		   Set<String> selectname2=driver.getWindowHandles();
		   for(String string2:selectname2) {
			   driver.switchTo().window(string2);
			   String title=driver.getTitle();
			   if(title.contains("Invoice&action")) {
				   break;
			   }
		   }
		   driver.findElement(By.name("search_text")).sendKeys("sdafaf");
		   driver.findElement(By.name("search")).click();
		   driver.findElement(By.id("1")).click();
		   Set<String> selectname3=driver.getWindowHandles();
		   for(String string3:selectname3) {
			   driver.switchTo().window(string3);
			   String title=driver.getTitle();
			   if(title.contains("Assets&action")) {
				   break;
			   }
		   }
		   String assetName="asset"+randomNumber;
		   driver.findElement(By.id("assetname")).sendKeys(assetName);
		   driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		   Set<String> selectname4=driver.getWindowHandles();
		   for(String string4:selectname4) {
			   driver.switchTo().window(string4);
			   String title=driver.getTitle();
			   if(title.contains("Accounts&action")) {
				   break;
			   }
		   }
		   driver.findElement(By.name("search_text")).sendKeys("ranjan");
		   driver.findElement(By.name("search")).click();
			driver.findElement(By.id ("5")).click();
			 Set<String> selectname5=driver.getWindowHandles();
			   for(String string5:selectname5) {
				   driver.switchTo().window(string5);
				   String title=driver.getTitle();
				   if(title.contains("Assets&action")) {
					   break;
				   }
			   }
			   driver.findElement(By.name("button")).click();
			   String headtext = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			   if(headtext.contains(assetName))
			   {
				System.out.println("asset is created");
				
			   }else {
				   System.out.println("not created");
				   
			   }
			   WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			   Actions action=new Actions(driver);
			   action.moveToElement(ele).perform();
			   driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			   
			   
			   
			   }

}
