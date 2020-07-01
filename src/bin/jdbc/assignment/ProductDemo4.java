package bin.jdbc.assignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDemo4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		   
		//step1: load/register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		//step 2: establish connection
		String url="jdbc:mysql://localhost:3306/DEMO1";
		String user="root";
		String password="1234";
		Connection connection=DriverManager.getConnection(url, user, password);
		Statement stmt = connection.createStatement();
		   Statement stmt1 = connection.createStatement();
		//step3:create statement

		
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = connection.createStatement();
		      String sql = "UPDATE Products SET PROD_PRICE =( PROD_PRICE+PROD_PRICE*0.1 )WHERE PROD_CATG ='Electronics' and PROD_PRICE<1000";
		      stmt.executeUpdate(sql);

		      String sql1 = "UPDATE Products SET PROD_PRICE =( PROD_PRICE-PROD_PRICE*0.1 )WHERE PROD_CATG ='Clothing' and PROD_PRICE>1000 ";
	      stmt1.executeUpdate(sql1);
		      // Now you can extract all the records
		      // to see the updated records
		      sql = "SELECT * FROM products";
		      sql1 = "SELECT * FROM products";
		      ResultSet rs = stmt.executeQuery(sql);
		      ResultSet rs1 = stmt1.executeQuery(sql1);

		      while(rs.next()){
		         //Retrieve by column name   PROD_CODE | PROD_NAME | PROD_PRICE | PROD_CATG
		         int PROD_CODE  = rs.getInt("PROD_CODE");
		         float PROD_PRICE = rs.getFloat("PROD_PRICE");
		         String PROD_NAME = rs.getString("PROD_NAME");
		         String PROD_CATG = rs.getString("PROD_CATG");

		         //Display values
		         System.out.print(PROD_CODE+"  \t");
		         System.out.print( PROD_NAME+"      \t");
		         System.out.print(  PROD_PRICE+"    \t");
		         System.out.println(  PROD_CATG+"  \t");
		      }
		      
		      while(rs1.next()){
			         //Retrieve by column name   PROD_CODE | PROD_NAME | PROD_PRICE | PROD_CATG
			         int PROD_CODE  = rs1.getInt("PROD_CODE");
			         float PROD_PRICE = rs1.getFloat("PROD_PRICE");
			         String PROD_NAME = rs1.getString("PROD_NAME");
			         String PROD_CATG = rs1.getString("PROD_CATG");

			         //Display values
			         System.out.print(PROD_CODE+"  \t");
			         System.out.print(PROD_NAME+"     \t");
			         System.out.print( PROD_PRICE+"   \t");
			         System.out.println(PROD_CATG+"  \t");
			      }
		      rs.close();
}
}