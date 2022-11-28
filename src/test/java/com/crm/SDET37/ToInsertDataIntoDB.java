package com.crm.SDET37;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ToInsertDataIntoDB {

	public static void main(String[] args) throws SQLException {
		 //step 1: register to DB
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		//step 2:connect to mysql
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		//step3: create statement\querry
		Statement statement=connection.createStatement();
		String query="insert into student values('virat','kohli','88888','1998/07/23','male')";
		//step4: execute the querry
	
		int result=statement.executeUpdate(query);
		if(result==1) {
			System.out.println("data is created");
		}else {
			System.out.println("not created");
		}
		connection.close();
		
	}

}
