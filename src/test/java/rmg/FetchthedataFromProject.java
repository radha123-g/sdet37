package rmg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchthedataFromProject {

	public static void main(String[] args) throws SQLException {
		
		 //step 1: register to DB
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		//step 2:connect to mysql
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		//step3: create statement\querry
		Statement statement=connection.createStatement();
		String querry="select * from project";
		//step4: execute the querry
		ResultSet result=statement.executeQuery(querry);
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6)+"\t");
		}
		connection.close();
	}

}
