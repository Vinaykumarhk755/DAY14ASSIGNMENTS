package bin.jdbc.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDemo1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//step1: load/register the driver
				Class.forName("com.mysql.cj.jdbc.Driver");

				//step 2: establish connection
				String url="jdbc:mysql://localhost:3306/DEMO1";
				String user="root";
				String password="1234";
				Connection connection=DriverManager.getConnection(url, user, password);

				//step3:create statement
				Statement statement =connection.createStatement();
				String query="select * from products";
				ResultSet resultSet=statement.executeQuery(query);

				//step5: use the data extract data from resultSet object 
				while(resultSet.next())
				{
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"    \t"+resultSet.getFloat(3)+"   \t"+resultSet.getString(4));
				}
	}

}
