package com.fetchexceldata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fetchDataFromfirstRowAndSecondcolumnDataTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\myExcel123.xlsx");
	       Workbook workbook=WorkbookFactory.create(fis);
	       Sheet sheet=workbook.getSheet("Sheet1");
	       int count=sheet.getLastRowNum();
	       for(int i=0;i<=count;i++) {
	    	   Row row=sheet.getRow(i);
	    	   String FirstColumn=row.getCell(0).toString();
	    	   String SecondColumn=row.getCell(1).toString();
	    			   System.out.println(FirstColumn+"\t"+SecondColumn);
	       }

	}

}
