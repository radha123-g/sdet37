package xpathWithFlipkart;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;     
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get("https://www.google.com/");
//	    driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("java programs");
//	    driver.findElement(By.xpath("//div[@jsmodel='sj77Re vWNDde P9Kqfe']")).click();
//	    driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/descendant::input[@value='Google Search']")).click();
	    List<WebElement> links = driver.findElements(By.xpath("//a"));
	    for (WebElement ele : links) {
	      String link = ele.getAttribute("href");
	      URL url=new URL(link);
	      HttpURLConnection con= (HttpURLConnection) url.openConnection();
	      con.connect();
	      if (con.getResponseCode()==200) {
	        System.out.println(url+" is validated" );

	      }else {
	        System.out.println(url +" is not validated");
	      }
	    }
	    driver.quit();

	}

}
