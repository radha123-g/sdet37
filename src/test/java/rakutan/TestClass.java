package rakutan;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestClass {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int N = Integer.parseInt(br.readLine().trim());
		String[] S = new String[N];
		for(int i=0; i<N; i++) {
			S[i] = br.readLine();
		}
		String[] out_= solve(N, S);
		for(int i=0;i<N;i++) {
			System.out.println(out_[i]);
		}
		wr.close();
		br.close();
	}
	static String[] solve(int N, String[] S) throws Throwable{
		Class.forName("com.mysql.jdbc.Driver");
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement = connection.createStatement();
		String[] str=new String[N];
		for(int i=0;i<N;i++) {
		String query="select * from employe";
		ResultSet result = statement.executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			String input = result.getString(1);	
			if(input.equals(S[i])) {
				flag=true;
				
			}
		}
		if(flag==true) 
		{
			str[i]="Yes";
		}
		else 
		{
			str[i]="No";
			String query1="insert into employe values('"+S[i]+"')";
			statement.executeUpdate(query1);
			
		}
		}
		return str;
	}

 
}




