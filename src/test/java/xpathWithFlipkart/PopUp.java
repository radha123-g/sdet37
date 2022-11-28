package xpathWithFlipkart;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopUp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		Actions ac=new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//a[.='SwitchTo']"));
		ac.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[.='Windows']")).click();
		ac.doubleClick().perform();
		ac.doubleClick().perform();
	}

}
