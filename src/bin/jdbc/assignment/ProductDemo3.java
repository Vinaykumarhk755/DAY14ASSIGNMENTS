package bin.jdbc.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class ProductDemo3 {

	

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
				Product p=new Product();
				 ArrayList<Product> arraylist = new ArrayList<Product>(); 
				
				    Scanner scanner = new Scanner(System.in); 
				    System.out.println("enter number of products ");
				    int n=scanner.nextInt();
				 System.out.println("enter code-name-price-cat");
				      //Adding the Records of the table to the Array List
				     for(int i=0;i<n;i++) {
				         Product product = new Product();
				         product.setPROD_CODE(scanner.nextInt());
				         product.setPROD_NAME(scanner.next());
				         product.setPROD_PRICE(scanner.nextFloat());
				         product.setPROD_CATG(scanner.next());
				         arraylist.add(product);
				      }
				      for (Product obj : arraylist) {
				         System.out.print("code: "+obj.getPROD_CODE()+", ");
				         System.out.print("Name: "+obj.getPROD_NAME()+", ");
				         System.out.print("price: "+obj.getPROD_PRICE()+", ");
				         System.out.print("category: "+obj.getPROD_CATG()+", ");
				         System.out.println();
				      }
				      String query = "insert into PRODUCTS values(?,?,?,?)";
						PreparedStatement pstmt = connection.prepareStatement(query);
						
					/*	for(int i=0; i<n; i++) {
							 ArrayList<Product> arraylist1 = new ArrayList<Product>(); 
							pstmt.setInt(1,arraylist1.PROD_CODE[i]);
							pstmt.setString(2, str.PROD_NAME[i]);
							pstmt.setString(3, PROD_PRICE[i]);
							pstmt.setString(4, PROD_CATG[i]);
							
							int rowsAffected = pstmt.executeUpdate();
							System.out.println(rowsAffected + " row updated");
						}
					*/
						for (Iterator<Product> iterator = arraylist.iterator(); iterator.hasNext();) {
							Product product = (Product) iterator.next();
							pstmt.setInt(1, product.getPROD_CODE());
							pstmt.setString(2, product.getPROD_NAME());
							pstmt.setFloat(3, (float) product.getPROD_PRICE());
							pstmt.setString(4,product.getPROD_CATG());
							
							pstmt.addBatch();
						}
						int[] updateCounts = pstmt.executeBatch();
						System.out.println(Arrays.toString(updateCounts));
					    
	}
}
