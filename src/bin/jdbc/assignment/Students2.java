package bin.jdbc.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Students2 {

		public static void main(String[] args) throws ClassNotFoundException, SQLException {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/demo1";
			String user = "root";
			String password = "1234";
			Connection connection = DriverManager.getConnection(url,user,password);

			
			String query = "update students set STUDENT_NAME=? where STUDENT_NAME=?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, "Mathiws");
			pstmt.setString(2, "shivu");
				int count = pstmt.executeUpdate();
			
                  System.out.println(count+ " row affected");
			

		connection.close();
}
}
