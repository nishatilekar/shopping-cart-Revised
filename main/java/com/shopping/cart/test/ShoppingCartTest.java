package main.java.com.shopping.cart.test;

import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import main.java.com.shopping.cart.Order;

/**
 * @author Nisha Tilekar Test cases for Service class Order.java
 */

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartTest {
	
	// @Mock annotation is used to create the mock object to be injected
	@Mock
	Order orderService;

	@Test
	public void testGetCartPrice() {
		// add the behavior of getCartPrice service to get price
		when(orderService.getCartPrice()).thenReturn(30.00);
	}

	@Test
	public void testGetProductCount() {
		// add the behavior of getCartPrice service to get price
		when(orderService.productCount()).thenReturn(4);

	}

}
