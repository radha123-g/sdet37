package xpathWithFlipkart;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PriceInSortedOrder {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("phones");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		
		//validation of url page
				String urlphonespage = driver.getCurrentUrl();
				SoftAssert softassert = new  SoftAssert();
				softassert.assertTrue(true, urlphonespage);
				Reporter.log(urlphonespage, true);
				List<WebElement> allphnNames = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
				ArrayList<Integer> phones = new ArrayList<Integer>();
				for (WebElement p : allphnNames) {
				 String price = p.getText();
				 String mobilePrice = price.substring(1).replace(",", "");
				 int mPrice = Integer.parseInt(mobilePrice);
				 phones.add(mPrice);
				}
				
				Collections.sort(phones);
				for(int i=0;i<=phones.size()-1;i++) {
					System.out.println(phones.get(i));
				}
		driver.quit();

	}

}
