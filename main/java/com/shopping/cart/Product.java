package main.java.com.shopping.cart;

/**
 * @author Nisha Tilekar 
 * Product model class with getters and setters.
 */
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 4441986025423271169L;
	public String pid;
	public String pname;
	public Long qty;
	public double price;
	public String category;

	public Product() {
	}

	public Product(String pid, String pname, Long qty, double price,
			String category) {
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.category = category;
	}

	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * @param pid
	 *            the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname
	 *            the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * @return the qty
	 */
	public Long getQty() {
		return qty;
	}

	/**
	 * @param qty
	 *            the qty to set
	 */
	public void setQty(Long qty) {
		this.qty = qty;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}