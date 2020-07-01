package bin.jdbc.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Product {

	int PROD_CODE;
	String PROD_NAME;
	float PROD_PRICE;	
	String PROD_CATG;
	public Product() {}
	public Product(int pROD_CODE, String pROD_NAME, float pROD_PRICE, String pROD_CATG) {
		super();
		PROD_CODE = pROD_CODE;
		PROD_NAME = pROD_NAME;
		PROD_PRICE = pROD_PRICE;
		PROD_CATG = pROD_CATG;
	}
	@Override
	public String toString() {
		return "Product [PROD_CODE=" + PROD_CODE + ", PROD_NAME=" + PROD_NAME + ", PROD_PRICE=" + PROD_PRICE
				+ ", PROD_CATG=" + PROD_CATG + "]";
	}
	public int getPROD_CODE() {
		return PROD_CODE;
	}
	public void setPROD_CODE(int pROD_CODE) {
		PROD_CODE = pROD_CODE;
	}
	public String getPROD_NAME() {
		return PROD_NAME;
	}
	public void setPROD_NAME(String pROD_NAME) {
		PROD_NAME = pROD_NAME;
	}
	public float getPROD_PRICE() {
		return PROD_PRICE;
	}
	public void setPROD_PRICE(float pROD_PRICE) {
		PROD_PRICE = pROD_PRICE;
	}
	public String getPROD_CATG() {
		return PROD_CATG;
	}
	public void setPROD_CATG(String pROD_CATG) {
		PROD_CATG = pROD_CATG;
	}
	
	}


