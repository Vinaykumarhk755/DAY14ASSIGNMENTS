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
import java.sql.Connection;
public class ProductDAO {
	
public boolean insertProducts(Product products) throws ClassNotFoundException, SQLException {
    Connection con = DBUtil.getConnection();
    Statement statement = con.createStatement();
    boolean result = false;
    String query = "INSERT INTO products VALUES ("+products.getPROD_CODE()+",'"+products.getPROD_NAME()+"',"
            +products.getPROD_PRICE()+",'"+products.getPROD_CATG()+"')";
    int count = statement.executeUpdate(query);
    if (count!=0) {
        result = true;
    }
    return result;
}
public Product getProduct(int prodCode) throws ClassNotFoundException, SQLException {
    Connection con = DBUtil.getConnection();
    Statement statement = con.createStatement();
    String query = "SELECT * FROM products WHERE prod_code = "+prodCode ;
    ResultSet set = statement.executeQuery(query);
    Product product = new Product();;
    
    if (set.next()) {
        product.setPROD_CODE(set.getInt("prod_code"));
        product.setPROD_NAME(set.getString("prod_name"));
        product.setPROD_PRICE(set.getInt("prod_price"));
        product.setPROD_CATG(set.getString("prod_cate"));
        product = new Product(product.getPROD_CODE(), product.getPROD_NAME(), product.getPROD_PRICE(),product.getPROD_CATG());
    }
    return product;
}
}