package example;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class sampleReadAndWriteaDataintoTheExcel {

	public static void main(String[] args) throws Throwable {
	 
	 FileInputStream fis=new FileInputStream("./src/test/resources/myExcel.xlsx");
	 Workbook wb=WorkbookFactory.create(fis);
	 Sheet sheet = wb.getSheet("sample");
	 Row row = sheet.getRow(0);
	 Cell cell = row.getCell(0);
	 cell.setCellValue("manju");
	 String sample = cell.toString();
	 System.out.println(sample);
	 FileOutputStream fos=new FileOutputStream("./src/test/resources/myExcel.xlsx");
	 sheet.createRow(1).createCell(5).setCellValue(sample);
	 wb.write(fos);

	}

}
