import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {
	Product ball;

	@BeforeEach
	void setUp() {
		ball = new Product("BALL", "PR-1", 4.99, 2);

	}

	// Quantity
	@Test
	void product_quantity_can_reduce_quantity() {
		ball.updateQuantity(0);
		assertEquals(0, ball.getQuantity());
	}

	@Test
	void product_quantity_can_increase_quantity() {
		ball.updateQuantity(4);
		assertEquals(4, ball.getQuantity());
	}

	// Value
	@Test
	void product_value_is_pricexquantity() {
		double value = ball.getProductValue();
		assertEquals(4.99 * 2, value);
	}

	@Test
	void product_value_changes_with_quantity() {
		double value1 = ball.getProductValue();
		ball.updateQuantity(5);
		double value2 = ball.getProductValue();
		assertTrue(value1 < value2);
	}
}
