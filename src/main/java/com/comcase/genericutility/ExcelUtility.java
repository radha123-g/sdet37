package com.comcase.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author RADHA
 *
 */

public class ExcelUtility {
	/**
	 * this method is used to fetch the data from excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public String getDataFromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook= WorkbookFactory.create(new FileInputStream(IConstants.excelpath));
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(cell);
		return value;
	}
	/**
	 * this method is used to insert data in excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void insertDataintoExcel(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IConstants.excelpath));
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fileoutputstream = new FileOutputStream(IConstants.excelpath);
		workbook.write(fileoutputstream);	
	}
	/**
	 * to get the last used row number from excel
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getLastRowNumFromExcel(String sheetname) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IConstants.excelpath));
		Sheet sheet = workbook.getSheet(sheetname);
		int row = sheet.getLastRowNum();
		return row;
	}

}

