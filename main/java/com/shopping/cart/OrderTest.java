package main.java.com.shopping.cart;


/**
 * @author Nisha Tilekar
 * Main class for Application
 */
public class OrderTest {

	public static void main(String[] args) throws Exception {
		Order o = new Order("Nisha Tilekar");
		o.addProduct("1");
		o.addProduct("1");
		o.addProduct("4");
		o.addProduct("7");
		System.out.println(" ****************** ");
		System.out.println("Total Bill :");
		System.out.println("\nNo. of Product : " + o.productCount());
		System.out.println("Order Places By : " + o.uid);
		System.out.println("Amount : "+o.getCartPrice());
		
	}

}