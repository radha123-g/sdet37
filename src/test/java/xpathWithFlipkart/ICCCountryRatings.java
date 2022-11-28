package xpathWithFlipkart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcase.genericutility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCCountryRatings {
	
	
@Test(dataProvider="get")
//	public static void main(String[] args) {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
//		driver.manage().window().maximize();
//		WebElement country = driver.findElement(By.xpath("//table/descendant::span[text()='England']"));
//		WebElement rating = driver.findElement(By.xpath("//table/descendant::span[text()='England']/ancestor::tr/td[@class='table-body__cell u-text-right rating']"));
//        System.out.println(" "+country.getText());
//		System.out.println("   "+rating.getText());
//		driver.close();
//	}
	//generic method for this program
	public void ICCRanking(String countryName) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
	driver.manage().window().maximize();
	String ratings = driver.findElement(By.xpath("//table/descendant::span[text()='"+countryName+"']/ancestor::tr/td[@class='table-body__cell u-text-right rating']")).getText();
	// String Ratings = driver.findElement(By.xpath("//table/descendant::span[text()='"+countryName+"']/ancestor::tr/td[@class='rankings-block__banner--rating u-text-right']")).getText();
    System.out.println("country="+countryName+"  ratings="+ratings);
    
    driver.quit();
		
	}
@DataProvider(name="get")
 public Object[][] countryRating() throws Throwable{
	
	ExcelUtility eLib=new ExcelUtility();
	Object[][] obj=new Object[1][1];
	 
	//String country1 = eLib.getDataFromExcel("country", 0, 0);
	
	obj[0][0]=eLib.getDataFromExcel("country", 1, 0);

	obj[1][0]=eLib.getDataFromExcel("country", 2, 0);

	obj[2][0]=eLib.getDataFromExcel("country", 3, 0);

	obj[3][0]=eLib.getDataFromExcel("country", 4, 0);

	obj[4][0]=eLib.getDataFromExcel("country", 5, 0);

	obj[5][0]=eLib.getDataFromExcel("country", 6, 0);

	obj[6][0]=eLib.getDataFromExcel("country", 7, 0);

	obj[7][0]=eLib.getDataFromExcel("country", 8, 0);

	obj[8][0]=eLib.getDataFromExcel("country", 9, 0);
	
	return obj;
	
	 
 }

}

