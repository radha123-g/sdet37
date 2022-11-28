package com.fetchexceldata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataIntoExcelTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\myExcel1.xlsx");
	       Workbook workbook=WorkbookFactory.create(fis);
	       Sheet sheet=workbook.getSheet("Sheet1");
	       Row row=sheet.getRow(0);
	       Cell cell=row.createCell(1);
	       cell.setCellValue("hi");
	       FileOutputStream fos=new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\myExcel1.xlsx");
	       workbook.write(fos);
	}

}
