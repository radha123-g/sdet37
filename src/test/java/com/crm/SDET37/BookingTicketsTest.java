package com.crm.SDET37;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcase.genericutility.ExcelUtility;

public class BookingTicketsTest {
@Test(dataProvider="bookingTickets")
public void bookingTickets(String src,String dst,String value) {
	System.out.println("from"+src+"to"+dst+"price"+value);
}
@DataProvider
public Object[][] bookingTickets() throws Throwable{
	ExcelUtility eLib=new ExcelUtility();
	Object[][] objarr=new Object[3][3];
	objarr[0][0]=eLib.getDataFromExcel("Sheet3", 0, 0);
	objarr[0][1]=eLib.getDataFromExcel("Sheet3", 0, 1);
	objarr[0][2]=eLib.getDataFromExcel("Sheet3", 0, 2);
	objarr[1][0]=eLib.getDataFromExcel("Sheet3", 1, 0);
	objarr[1][1]=eLib.getDataFromExcel("Sheet3", 1, 1);
	objarr[1][2]=eLib.getDataFromExcel("Sheet3", 1, 2);
	objarr[2][0]=eLib.getDataFromExcel("Sheet3", 2, 0);
	objarr[2][1]=eLib.getDataFromExcel("Sheet3", 2, 1);
	objarr[2][2]=eLib.getDataFromExcel("Sheet3", 2, 2);
	return objarr;
	
}

	

}
