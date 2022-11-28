import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class crickBuzzLiveeBattersNRuns {


	  @Test
	  public void cricbuzz() 
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://www.cricbuzz.com/live-cricket-scorecard/43171/aus-vs-afg-38th-match-super-12-group-1-icc-mens-t20-world-cup-2022");
			
			//afg innings
			List<WebElement> afgbatter = driver.findElements(By.xpath("//span[.='Afghanistan Innings']/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::div[@class='cb-col cb-col-27 ']"));
			List<WebElement> afgrun = driver.findElements(By.xpath("//span[.='Afghanistan Innings']/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/child::div[@class='cb-col cb-col-100 cb-scrd-itms']/child::div[@class='cb-col cb-col-8 text-right text-bold']"));
			int Size = afgbatter.size();
			ArrayList<String> array=new ArrayList<String>();
			for (int i = 0; i < Size; i++) 
			{
				array.add(afgbatter.get(i).getText()+" "+afgrun.get(i).getText());

			}
			System.out.println("Afghanistan innings Afg batting");
			System.out.println();
			for (int i = 0; i < Size; i++) 
			{
				System.out.println(array.get(i)+" runs");
			}

			List<WebElement> ausbowler = driver.findElements(By.xpath("//span[.='Afghanistan Innings']/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/following-sibling::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::div[@class='cb-col cb-col-40']"));
			List<WebElement> auswicket = driver.findElements(By.xpath("//span[.='Afghanistan Innings']/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/following-sibling::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::div[@class='cb-col cb-col-8 text-right text-bold']"));
			int Size1 = ausbowler.size();
			ArrayList<String> array1=new ArrayList<String>();
			for (int i = 0; i < Size1; i++)
			{
				array1.add(ausbowler.get(i).getText()+" "+auswicket.get(i).getText());

			}
			System.out.println();
			System.out.println("Afghanistan innings Aus bowling");
			System.out.println();
			for (int i = 0; i < Size1; i++)
			{
				System.out.println(array1.get(i)+" wkts");
			}

			//aus innings
			List<WebElement> ausbatter = driver.findElements(By.xpath("//span[.='Australia Innings']/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::div[@class='cb-col cb-col-27 ']"));
			List<WebElement> ausrun = driver.findElements(By.xpath("//span[.='Australia Innings']/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/child::div[@class='cb-col cb-col-100 cb-scrd-itms']/child::div[@class='cb-col cb-col-8 text-right text-bold']"));
			int Size2 = ausbatter.size();
			ArrayList<String> array2=new ArrayList<String>();
			for (int i = 0; i < Size2; i++) 
			{
				array2.add(ausbatter.get(i).getText()+" "+ausrun.get(i).getText());

			}
			System.out.println();
			System.out.println("Australia innings Aus batting");
			System.out.println();
			for (int i = 0; i < Size2; i++) 
			{
				System.out.println(array2.get(i)+" runs");
			}

			List<WebElement> afgbowler = driver.findElements(By.xpath("//span[.='Australia Innings']/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/following-sibling::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::div[@class='cb-col cb-col-40']"));
			List<WebElement> afgwicket = driver.findElements(By.xpath("//span[.='Australia Innings']/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/following-sibling::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::div[@class='cb-col cb-col-8 text-right text-bold']"));
			int Size3 = afgbowler.size();
			ArrayList<String> array3=new ArrayList<String>();
			for (int i = 0; i < Size3; i++)
			{
				array3.add(afgbowler.get(i).getText()+" "+afgwicket.get(i).getText());

			}
			System.out.println();
			System.out.println("Australia innings Afg bowling");
			System.out.println();
			for (int i = 0; i < Size3; i++)
			{
				System.out.println(array3.get(i)+" wkts");
			}

			driver.quit();
	  }

}
