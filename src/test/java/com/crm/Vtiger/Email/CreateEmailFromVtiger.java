package com.crm.Vtiger.Email;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 *  * @author RADHA
 *
 */
public class CreateEmailFromVtiger {

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

		//click on login
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Email']")).click();
		driver.findElement(By.xpath("//a[.='Compose']")).click();
		Set<String> selectname=driver.getWindowHandles();
		for(String string:selectname) {
			driver.switchTo().window(string);
			String title=driver.getTitle();
			if(title.contains("Emails&action")) {
				break;
			}
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Set<String> selectname1=driver.getWindowHandles();
		for(String string1:selectname1) {
			driver.switchTo().window(string1);
			String title=driver.getTitle();
			if(title.contains("Contacts&action")) {
				break;
			}
		}
		driver.findElement(By.xpath("//a[.='achhu alli']")).click();
		Set<String> selectname2=driver.getWindowHandles();
		for(String string2:selectname2) {
			driver.switchTo().window(string2);
			String title=driver.getTitle();
			if(title.contains("Emails&action")) {
				break;
			}
		}
		driver.findElement(By.name("subject")).sendKeys("hi");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Set<String> selectname5=driver.getWindowHandles();
		for(String string5:selectname5) {
			driver.switchTo().window(string5);
			String title=driver.getTitle();
			if(title.contains("Emails&action")) {
				break;
			}
		}
		WebElement emt=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(emt).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
