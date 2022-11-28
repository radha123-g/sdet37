package com.comcase.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * 
 * @author RADHA
 *
 */

public class DatabaseUtility {
	static Driver driverRef;
	static Connection connection;
	static ResultSet result;
	/**
	 * This method is used to connect to DB
	 * @param DBname
	 */
	public void connectToDB(String DBname) {
		try {
			driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			connection=DriverManager.getConnection(IConstants.Dburl+DBname,IConstants.Dbusername,IConstants.Dbpassword);


		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method is used to close the DB
	 */
	public void closeDB() {
		try {
			connection.close();
		}catch(Exception e) {

		}
	}
	/**
	 * this method is used to excute query
	 * @param query
	 * @param columnNum
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */

	public boolean excuiteQuery(String query,int columnNum,String expectedData) throws SQLException {
		result=connection.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			if(result.getString(columnNum).equals(expectedData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println("data is present");
			return flag;
		}else {
			System.out.println("data id=s not present");
			return flag;
		}

	}
	/**
	 * this method is used to update the data in DB
	 * @param query
	 * @throws SQLException
	 */
	public void exciteUpdate(String query) throws SQLException {
		int res=connection.createStatement().executeUpdate(query);
		if(res==1) {
			System.out.println("data is updated");
		}else {
			System.out.println("data is not updated");
		}

	}
}
