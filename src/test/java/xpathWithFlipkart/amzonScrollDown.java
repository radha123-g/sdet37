package xpathWithFlipkart;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amzonScrollDown {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("//span[text()='Refresh your home ambiance | Local shops collection']"));
		JavascriptExecutor j = (JavascriptExecutor)driver;
		//j.executeScript("window.scrollBy(0,2000)");
		j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//j.executeScript("arguments[0].scrollIntoView({block:'center',inline:'nearest'})",ele);
		System.out.println("text is:"+ele.getText());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshots/abc.PNG");
		try {
			FileUtils.copyFile(src, dst);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
