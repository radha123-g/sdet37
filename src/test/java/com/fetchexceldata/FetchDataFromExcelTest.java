package com.fetchexceldata;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\myExcel1.xlsx");
       Workbook workbook=WorkbookFactory.create(fis);
       Sheet sheet=workbook.getSheet("Sheet1");
       Row row=sheet.getRow(0);
       Cell cell=row.getCell(0);
       DataFormatter format=new DataFormatter();
       String value=format.formatCellValue(cell);
       System.out.println(value);
       
	}

}
