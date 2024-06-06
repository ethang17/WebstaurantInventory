import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StoreInventoryTest {
	public static final String PRODUCT1_ID = "PR-1";
	public static final String PRODUCT2_ID = "PR-2";
	StoreInventory inventory;
	Product product1;
	Product product2;

	@BeforeEach
	void setUp() {
		inventory = new StoreInventory();
		product1 = new Product("BALL", PRODUCT1_ID, 4.99, 2);
		product2 = new Product("JUMPROPE", PRODUCT2_ID, 6.99, 6);
	}

	@Test
	void store_inventory_created_empty() {
		int numberProducts = inventory.getProducts().size();
		assertEquals(0, numberProducts);
	}

//Add a new product.
	@Test
	void product_can_be_added_to_inventory() {
		inventory.addProduct(product1);
		int numberProducts = inventory.getProducts().size();
		assertEquals(1, numberProducts);
	}

	@Test
	void multiple_products_can_be_added_to_inventory() {
		inventory.addProduct(product1);
		inventory.addProduct(product2);
		int numberProducts = inventory.getProducts().size();
		assertEquals(2, numberProducts);
	}

//Remove a product.
	@Test
	void product_can_be_removed_from_inventory() {

		inventory.addProduct(product1);
		inventory.addProduct(product2);
		inventory.removeProduct(PRODUCT2_ID);
		int numberProducts = inventory.getProducts().size();
		assertEquals(1, numberProducts);
	}

	@Test
	void multiple_products_can_be_removed_from_inventory() {
		inventory.addProduct(product1);
		inventory.addProduct(product2);
		inventory.removeProduct(PRODUCT1_ID);
		inventory.removeProduct(PRODUCT2_ID);
		int numberProducts = inventory.getProducts().size();
		assertEquals(0, numberProducts);
	}

//Update the quantity of a product.

	@Test
	void quantity_can_be_set_to_zero_for_a_product() {
		inventory.addProduct(product1);
		inventory.updateQuantity(PRODUCT1_ID, 0);
		assertEquals(0, product1.getQuantity());
	}

	@Test
	void quantity_can_be_set_above_0_for_a_product() {
		inventory.addProduct(product1);
		inventory.updateQuantity(PRODUCT1_ID, 5);
		assertEquals(5, product1.getQuantity());
	}

	@Test
	void quantity_cannot_be_set_under_0_for_a_product() {
		inventory.addProduct(product1);
		int initialQ = product1.getQuantity();
		inventory.updateQuantity(PRODUCT1_ID, -5);
		assertEquals(initialQ, product1.getQuantity());
	}

//View the current inventory.

	@Test
	void inventory_of_one_item_is_size_one() {
		inventory.addProduct(product1);
		int outSize = inventory.listInventory().size();
		assertEquals(1, outSize);
	}

	@Test
	void inventory_of_two_item_is_size_two() {
		inventory.addProduct(product1);
		inventory.addProduct(product2);
		int outSize = inventory.listInventory().size();
		assertEquals(2, outSize);
	}

	@Test
	void inventory_of_no_item_is_size_zero() {
		int outSize = inventory.listInventory().size();
		assertEquals(0, outSize);
	}

//Calculate the total value of the inventory

	@Test
	void calculate_value_of_one_account_correct() {
		inventory.addProduct(product1);
		assertEquals(2 * 4.99, inventory.getTotalValue());
	}

	@Test
	void calculate_value_of_multiple_accounts_correct() {
		inventory.addProduct(product1);
		inventory.addProduct(product2);
		assertEquals(2 * 4.99 + 6.99 * 6, inventory.getTotalValue());
	}

}
