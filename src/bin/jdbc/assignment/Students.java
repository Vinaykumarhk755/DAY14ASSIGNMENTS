package bin.jdbc.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Students {

		public static void main(String[] args) throws ClassNotFoundException, SQLException {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/demo1";
			String user = "root";
			String password = "1234";
			Connection connection = DriverManager.getConnection(url,user,password);

			
			String query = "select * from students where student_city=?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, "bangalore");			
				ResultSet resultSet = pstmt.executeQuery();
			

			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"    \t"+resultSet.getString(3)+"   \t"+resultSet.getString(4)+"	\t"
				+resultSet.getString(5)+"    \t" +resultSet.getBigDecimal(6)+"    \t");
			}

		connection.close();
}
}
