package main.java.com.shopping.cart;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import org.json.simple.parser.ParseException;



/**
 * @author Nisha Tilekar
 * Interface which has methods for shopping cart
 */
public interface IOrder {
	void addProduct(String prodId) throws FileNotFoundException, IOException,ParseException;

	int productCount();

	double getCartPrice();
	
	Collection getCartDetails();
	
	boolean removeProduct(String pid) throws ProductNotFoundException;
}