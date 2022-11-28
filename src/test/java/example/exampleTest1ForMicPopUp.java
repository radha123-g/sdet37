package example;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class exampleTest1ForMicPopUp {
 @Test
 public void exampleTestMicPopUp() throws Throwable {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://mictests.com/");
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//button[contains(text(),'Test my mic')]")).click();
	 Robot r=new Robot();
	 r.keyPress(KeyEvent.VK_ESCAPE);
	 r.keyRelease(KeyEvent.VK_ESCAPE);
    
 }
}
