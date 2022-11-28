package com.crm.Vtiger.Document;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentInVtiger {
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
	driver.findElement(By.xpath("//a[.='Documents']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.name("notes_title")).sendKeys("title");
	driver.findElement(By.id("filename_I__")).sendKeys("F:\\Chaya C M (1).docx");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String title=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(title.contains("title")) {
		System.out.println("document created");
		
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
