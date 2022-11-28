package xpathWithFlipkart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcase.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getAllPhoneNames {
 @Test
 public void getAllPhoneName() {
	 WebDriverUtility wLib=new WebDriverUtility();
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 wLib.maximizeTheBrowser(driver);
	 wLib.waitTillPageGetsLoad(driver);
	 driver.get("https://www.flipkart.com/");
	 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("phone");
	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	 List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	 for (WebElement element : prices) {
		String text = element.getText();
		System.out.println(text);
	}
	 List<WebElement> names = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	 for (WebElement webElement : names) {
		String names1 = webElement.getText();
		System.out.println(names1);
	}
	 String specificPrice = driver.findElement(By.xpath("//div[.='SAMSUNG Galaxy F13 (Nightsky Green, 64 GB)']/../..//div[text()='₹9,499']")).getText();
	 System.out.println("SAMSUNG Galaxy F13 (Nightsky Green, 64 GB)="+specificPrice);
//	 List<WebElement> getAll = driver.findElements(By.xpath("//div[@class='_3pLy-c row']"));
//	 for (WebElement web : getAll) {
//		String get = web.getText();
//		System.out.println(get);
//	}
	 driver.quit();
 }
}
