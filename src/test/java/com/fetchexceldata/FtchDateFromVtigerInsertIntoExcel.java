package com.fetchexceldata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FtchDateFromVtigerInsertIntoExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\myExcel.xlsx");
	       Workbook workbook=WorkbookFactory.create(fis);
	       Sheet sheet=workbook.getSheet("Sheet1");
	       WebDriver driver=WebDriverManager.chromedriver().create();
	       driver.get("http://localhost:8888");
	       driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			List<WebElement> links = driver.findElements(By.xpath("//a"));
			int count=links.size();
			for(int i=0;i<count;i++) {
				 Row row=sheet.createRow(i);
			       Cell cell=row.createCell(0);
			       cell.setCellValue(links.get(i).getAttribute("href"));
				
			}
	      
	       FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\myExcel.xlsx");
	       workbook.write(fos);
	}

}
