package xpathWithFlipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphones");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement name = driver.findElement(By.xpath("//span[.='Apple iPhone 14 128GB Starlight']"));
        String text = name.getText();
        System.out.println(text);
        driver.quit();
	}

}
