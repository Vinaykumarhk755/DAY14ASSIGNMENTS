package bin.jdbc.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Students3 {

		public static void main(String[] args) throws ClassNotFoundException, SQLException {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/demo1";
			String user = "root";
			String password = "1234";
			Connection connection = DriverManager.getConnection(url,user,password);
			
			String query2="update students set mobileno=? where STUDENT_ID=?";
			PreparedStatement psst=connection.prepareStatement(query2);
			psst.setString(1,"9880800876");
			psst.setInt(2,109);
			int rowsAffected = psst.executeUpdate();
			System.out.println(rowsAffected+ " rows affected");
		
			

	
		connection.close();
}
}
