package bin.jdbc.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductDemo2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner=new Scanner(System.in);
		//step1: load/register the driver
				Class.forName("com.mysql.cj.jdbc.Driver");

				//step 2: establish connection
				String url="jdbc:mysql://localhost:3306/DEMO1";
				String user="root";
				String password="1234";
				Connection connection=DriverManager.getConnection(url, user, password);

				//step3:create statement
				Statement statement =connection.createStatement();
				System.out.println("enter the product code");
				int PROD_CODE =scanner.nextInt();
				String query = "select * from products where PROD_CODE="+PROD_CODE;
				ResultSet resultSet=statement.executeQuery(query);

				//step5: use the data extract data from resultSet object 
				while(resultSet.next())
				{
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"    \t"+resultSet.getFloat(3)+"   \t"+resultSet.getString(4));
				}
				connection.close();
				scanner.close();
			
	}

}
