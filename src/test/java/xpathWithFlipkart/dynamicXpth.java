package xpathWithFlipkart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dynamicXpth {
	 @Test(dataProvider = "data")
	  private void IccTest(String name) 
	  {
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://www.icc-cricket.com/rankings/womens/team-rankings/odi");
	    List<WebElement> list = driver.findElements(By.xpath("//div[@class='rankings-block__container full rankings-table']/table/tbody/tr[contains(.,'"+name+"')]/td[5]"));
	    for (WebElement ele : list) {
	      String test = ele.getText();
	      System.out.println(test);
	      driver.quit();
 
	    }
	  }
	  @DataProvider(name="data")

	  public Object[] getdata()
	  {
	    Object[] obj=new Object[11];
	    obj[0]="Australia";
	    obj[1]="South Africa";
	    obj[2]="England";
	    obj[3]="India";
	    obj[4]="New Zealand";
	    obj[5]="West Indies";
	    obj[6]="Bangladesh";
	    obj[7]="Pakistan";
	    obj[8]="Ireland";
	    obj[9]="Sri Lanka";
	    obj[10]="Zimbabwe";

	    return obj;
	  }
}


