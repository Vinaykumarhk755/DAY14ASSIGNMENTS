package bin.jdbc.assignment;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class DBUtil {

	public static Connection getConnection() throws SQLException, ClassNotFoundException { 	
		Class.forName("com.mysql.cj.jdbc.Driver"); 		
		String url = "jdbc:mysql://localhost:3306/demo1"; 	
		String user = "root"; 	
		String password = "1234"; 	
		Connection con = DriverManager.getConnection(url,user,password); 
		return con; 	
		}

	
	}

