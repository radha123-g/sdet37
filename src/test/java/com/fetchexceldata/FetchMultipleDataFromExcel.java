package com.fetchexceldata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\myExcel.xlsx");
	       Workbook workbook=WorkbookFactory.create(fis);
	       Sheet sheet=workbook.getSheet("Sheet1");
	       for(int i=0;i<=sheet.getLastRowNum();i++) {
	    	   Row row=sheet.getRow(i);
	    	   for(int j=0;j<=row.getLastCellNum();j++) {
		       Cell cell=row.getCell(j);
		       DataFormatter format=new DataFormatter();
		       String value=format.formatCellValue(cell);
		       System.out.println(value);
		       
	    	   
	       }
	      

	}

	}
}
