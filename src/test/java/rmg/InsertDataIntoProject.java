package rmg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataIntoProject {

	public static void main(String[] args) throws SQLException {
		 //step 1: register to DB
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		//step 2:connect to mysql
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		//step3: create statement\querry
		Statement statement=connection.createStatement();
		String query="insert into project values('113','kohli','21/02/2021','txzz','created','4')";
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
