package xpathWithFlipkart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricBuzzExample2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.cricbuzz.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(.,'RSA vs IND - IND Won')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Scorecard')]")).click();
		   List<WebElement> batters = driver.findElements(By.xpath("//span[.='South Africa Innings']/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::div[@class='cb-col cb-col-27 ']"));

		    List<WebElement> runs = driver.findElements(By.xpath("//span[.='South Africa Innings']/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::div[@class='cb-col cb-col-27 ']/parent::div[@class='cb-col cb-col-100 cb-scrd-itms']/child::div[@class='cb-col cb-col-8 text-right text-bold']"));
		    int x = batters.size();
		    HashMap<String, Integer> map=new HashMap<String, Integer>();
		    for (int i = 0; i < x; i++) {
		      String s = batters.get(i).getText();
		      int n = Integer.parseInt(runs.get(i).getText());
		      map.put(s, n);      
		    }
		    Collection<Integer> value=map.values();
		    List<Integer> list=new ArrayList<Integer>(value);
		    Collections.sort(list);
		    int n = (int)   list.get(list.size()-1);

		    Set<Entry<String, Integer>> set = map.entrySet();
		    
		    for (Entry<String, Integer> entry : set) {
		      if (entry.getValue()==n) 
		      {
		        System.out.println(entry.getKey()+" "+entry.getValue());
		      }

		    }
		    driver.quit();

	}

}
