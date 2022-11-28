package com.crm.SDET37;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateRMGYantra {
public static void main(String[] args) throws Throwable {
	String project_name="Dream12";
	Connection connection=null;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		//implicitly wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//enter the url of RMG yantra application
		driver.get("http://localhost:8084");
		//enter the username textfield
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		//enter the password textfield
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		//click on sign in button
		driver.findElement(By.xpath("//button[contains(.,'Sign in')]")).click();
		//click on projects link
		driver.findElement(By.xpath("//a[contains(.,'Projects')]")).click();
		//click on create project link
		driver.findElement(By.xpath("//span[contains(.,'Create Project')]")).click();
		//enter the project name
		driver.findElement(By.name("projectName")).sendKeys(project_name);
		//enter the project manager name
		driver.findElement(By.name("createdBy")).sendKeys("anjan");
		//select the status from project status dropdown
		WebElement statusdropdown=driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select"));
		
		Select select=new Select(statusdropdown);
		select.selectByValue("Created");
		//click on project button
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		
		try {
			//get register for mysql db
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			
			//connect to mysql Db using url
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			
			//create a statement
			Statement statement=connection.createStatement();
		   
			//write a querry
			String querry="select * from project";
			//fetch all the column data
			ResultSet result=statement.executeQuery(querry);
			//verify the data in db
			while(result.next()) {
				String allProject=result.getString(4);
				if(allProject.contains(project_name)) {
					System.out.println("project is created in DB");
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//close the DB connection
			connection.close();		}
		 //close the browser
	      driver.quit();


	}
    
}
