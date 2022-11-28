package rakutan;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Example {
	public static void main(String[] args) throws Throwable {
		Class.forName("com.mysql.jdbc.Driver");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a name");
		String s = sc.next();
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement = connection.createStatement();
		if(s.length()>=6) {
		String query="select * from employe";
		ResultSet result = statement.executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			String sc2 = result.getString(1);
			if(s.contains(sc2)) {
				System.out.println("yes,already data is inserted");
				flag=true;
				break;
			}
		}if(!flag) {
			System.out.println("no,i will insert now");
			String query1 = "insert into employe values('"+s+"')";
			int result1 = statement.executeUpdate(query1);
			if(result1==1) {
				System.out.println("data is present");
			}
		}
	}
		else {
			System.out.println("enter valid length");
		}
		connection.close();
	}
}
