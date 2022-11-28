package com.com.Vtiger.OrganasationWithIndustry;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganasationandIndustryAndVerify {

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
		//click on organisation link
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		//click on create organisation lookup image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//enter the organisation name
		driver.findElement(By.name("accountname")).sendKeys("akul");
		WebElement typedrop1=driver.findElement(By.name("industry"));
		Select s=new Select(typedrop1);
		s.selectByValue("Banking");
		WebElement typedrop=driver.findElement(By.name("accounttype"));
		Select s1=new Select(typedrop);
		s1.selectByValue("Customer");
		driver.findElement(By.name("button")).click();
		String header=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header.contains("akul")) {
			System.out.println("is created");
			
		}else {
			System.out.println("not created");
		}
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions ac=new Actions(driver);
		 ac.moveToElement(ele).perform();
		 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		

	}

}
