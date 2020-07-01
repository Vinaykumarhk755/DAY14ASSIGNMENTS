package bin.jdbc.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.Scanner;
public class ProductDemoFive {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ProductDAO dao = new ProductDAO();
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the no of product you want to insert");
        int noOfProd = scn.nextInt();
        for (int i = 0; i < noOfProd; i++) {
            System.out.println("enter the Product code");
            int code = scn.nextInt();
            System.out.println("enter the product name");
            String name = scn.next();
            System.out.println("enter the product price");
            double price = scn.nextDouble();
            System.out.println("enter the product category");
            String category = scn.next();
            Product product =new Product(code, name, (float) price, category);
            if(dao.insertProducts(product)) {
                System.out.println("product inserted successfully");
            }
        }
        System.out.println("enter the product id to be search");
        System.out.println(dao.getProduct(scn.nextInt()));
        scn.close();
    }

 

}
 