package main.java.com.shopping.cart;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Nisha Tilekar
 * Order class which includes business logic for adding and billing product.
 */
public class Order implements IOrder {

	public String uid;
	private Map map;

	public Order() {
	}

	public Order(String uid) {
		this.uid = uid;
		map = new HashMap();
	}// Order

	/* User defined method to add product to cart */
	public void addProduct(String prodId) throws FileNotFoundException,
			IOException, ParseException {

		Object obj = new JSONParser()
				.parse(new FileReader(
						"D:\\Java Data\\Workspaces\\NishaWorkspace\\ShoppingCartApplication\\src\\com\\shopping\\cart\\Product.json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray plist = (JSONArray) jsonObject.get("products");
		for (Object o : plist) {
			JSONObject jsonLineItem = (JSONObject) o;
			String pid = (String) jsonLineItem.get("pid");
			if (pid.equals(prodId)) {
				System.out.println(" ****************** ");
				System.out.println("Product Details :");
				System.out.println(" ****************** ");
				System.out.println("Product Id: " + pid);
				String pname = (String) jsonLineItem.get("pname");
				System.out.println("Product Name : " + pname);
				Long qty = (Long) jsonLineItem.get("qty");
				System.out.println("Quantity :" + qty);
				double price = (double) jsonLineItem.get("price");
				System.out.println("Price Per Item :" + price);
				String category = (String) jsonLineItem.get("category");
				System.out.println("Category :" + category);
				double priceRevised;
				if (category.equals("A")) {
					priceRevised = (price * 10 / 100) + price;
				} else if (category.equals("B")) {
					priceRevised = (price * 20 / 100) + price;
				} else {
					priceRevised = price;
				}
				Product p = new Product(pid, pname, qty, priceRevised, category);
				if (map.containsKey(pid)) {
					Product p1 = (Product) map.get(pid);
					p1.setPrice(p1.getPrice() + p.getPrice());
					p1.setQty(p1.getQty() + p.getQty());
					// return true;
					System.out.println("Revised Price :" + p1.getPrice());
					System.out.println("Revised Qty :" + p1.getQty());
				} else {
					map.put(pid, p);
				}
				// return false;
				break;
			}

		}

	}// addProduct

	/* User defined method to remove product to cart */
	public boolean removeProduct(String pid) throws ProductNotFoundException {
		if (map.containsKey(pid)) {
			map.remove(pid);
			return true;
		} else
			throw new ProductNotFoundException("Product with ID " + pid
					+ " is not Found.");
	}

	/* User defined method to get cart details from cart */
	public Collection getCartDetails() {
		return map.values();
	}

	/* User defined method to get product from cart */
	public Product getProductFromCart(String pid)
			throws ProductNotFoundException {
		if (map.containsKey(pid)) {
			return (Product) map.get(pid);
		} else {
			throw new ProductNotFoundException("Product with ID " + pid
					+ " is not Found.");
		}
	}

	/* User defined method to get product count */
	public int productCount() {
		return map.size();
	}

	/* User defined method to get cart price */
	public double getCartPrice() {
		double price = 0.0d;
		Iterator iterator = getCartDetails().iterator();
		while (iterator.hasNext()) {
			price += ((Product) iterator.next()).getPrice();
		}
		return price;
	}
}