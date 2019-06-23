package main.java.com.shopping.cart;


/**
 * @author Nisha Tilekar
 * Custom Exeption raised if product not found
 */
public class ProductNotFoundException extends Exception {
	public ProductNotFoundException() {
	}

	public ProductNotFoundException(String msg) {
		super(msg);
	}
}