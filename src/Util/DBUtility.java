package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {

	public static Connection getConnect() 
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/fooddb";
			String user="root";
			String pass="root";
			con=DriverManager.getConnection(url,user,pass);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
}
