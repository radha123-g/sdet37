package example;


//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopUpExaple {
@Test
public void popUp() throws Throwable {
	ChromeOptions co=new ChromeOptions();
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver(co);
	driver.get("https://mictests.com/");
	driver.findElement(By.id("mic-launcher ")).click();
	co.addArguments("--disable-notification");
//	Alert al=driver.switchTo().alert();
//	String popupmsg = al.getText();
//	System.out.println(popupmsg);
//	Thread.sleep(3000);
//	al.accept();
	driver.quit();
}
}
