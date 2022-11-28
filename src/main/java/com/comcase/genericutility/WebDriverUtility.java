package com.comcase.genericutility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * used to maximize the browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * used to minimize the browser
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver){
		driver.manage().window().minimize();
	}
	/**
	 * 
	 * @param driver
	 */
	public void refreshthepage(WebDriver driver) {
		driver.navigate().refresh();
	}
	/**
	 * get previous page
	 * @param driver
	 */
	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}
	/**
	 * get forward to next page
	 * @param driver
	 */
	public void forwardToNextPage(WebDriver driver) {
		driver.navigate().forward();
	}
	/**
	 * will wait till the page gets loaded
	 * @param driver
	 */
	public void waitTillPageGetsLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.implicitlyWaitDuration));
	}
	/**
	 * will wait until element to click
	 * @param driver
	 * @param element
	 */
	public void waitTillElementtoClick(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * it will wait till element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitTillElementtoVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * it will wait for title of the page
	 * @param driver
	 * @param title
	 */
	public void waitTillPageLoadTitle(WebDriver driver,String title) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * it will wait for url of the page
	 * @param driver
	 * @param url
	 */
	public void waitTillPageLoadURL(WebDriver driver,String url) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.urlContains(url));
	}
	/**
	 * it will ignore no such element exception for the particular element
	 * @param driver
	 */
	public void ignoringNoSuchElementException(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * it will wait till the alert msg to be visible
	 * @param driver
	 */
	public void waitForAlertMsg(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * it is used to switch frame using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * it is used to switch frame using id
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver,String id) {
		driver.switchTo().frame(id);
	}
	/**
	 * it is used to switch frame using element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * it is used to switch main frame
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * it is used to get element in a dropdown by using idex
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * used to get element in a dropdown using value
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	/**
	 * used to visible element on the dropdown
	 * @param text
	 * @param element
	 */
	public void select(String text,WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * it is used to fetch all the options from dropdown
	 * @param element
	 */
	public void getAllOptionFromDropDown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> option = select.getOptions();
		for(WebElement webelement:option) {
			String text = webelement.getText();
			System.out.println(text);
		}
	}
	/**
	 * used to mouse over on element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * used to do right click on element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * used to do double click on element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * used to click on enter
	 * @param driver
	 */
	public void clockOnEnterKey(WebDriver driver) {
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * used to take screenshot
	 * @param driver
	 * @param sName
	 */
	public void takeScreenshot(WebDriver driver,String sName) {
		TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
		File src = takeScreenshot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshots/"+sName+".PNG");
		try {
			FileUtils.copyFile(src, dst);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * used for custom wait
	 * @param driver
	 */
	public void waitAndClickUsingCustomWait(WebDriver driver) {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(10));
		wait.ignoring(NoSuchElementException.class);
		try {
			wait.wait(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * used for custom wait
	 * @param element
	 * @param duration
	 * @param pollingTime
	 */
	public void waitAndClick(WebElement element,int duration,long pollingTime) {
		int count=0;
		while(count<duration) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(pollingTime);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				count++;
			}
		}
	}
	/**
	 * used to switch window using title
	 * @param driver
	 * @param actualTitle
	 */
	public void switchToWindow(WebDriver driver,String actualTitle) {
		Set<String> set = driver.getWindowHandles();
		for (String string : set) {
			driver.switchTo().window(string);
			String title = driver.getTitle();
			if(title.contains(actualTitle)) {
				break;
			}
		}
	}
	/**
	 * used to switch window using URL
	 * @param actualUrl
	 * @param driver
	 */
	public void switchToWindow(String actualUrl,WebDriver driver) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String wId=it.next();
			driver.switchTo().window(wId);
			String url = driver.getCurrentUrl();
			if(url.contains(actualUrl)) {
				break;
			}
		}
	}
	/**
	 * used to switch alert popup and accept
	 * @param driver
	 * @param expectedMsg
	 */
	public void switchToAlertPopupAndAccept(WebDriver driver,String expectedMsg) {
		Alert alrt = driver.switchTo().alert();
		if(alrt.getText().trim().equalsIgnoreCase(expectedMsg.trim())){
			System.out.println("alert msg is verified");
		}else {
			System.out.println("alert msg is not verified");
		}
		alrt.accept();
	}
	/**
	 * used to switch to alert popup and dismiss
	 * @param driver
	 * @param expectedMsg
	 */
	public void switchToAlertPopupAndDismiss(WebDriver driver,String expectedMsg) {
		Alert alrt = driver.switchTo().alert();
		if(alrt.getText().trim().equalsIgnoreCase(expectedMsg.trim())){
			System.out.println("alert msg is verified");
		}else {
			System.out.println("alert msg is not verified");
		}
		alrt.dismiss();
	}

}

