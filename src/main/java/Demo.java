public class Demo {
	public static void main(String[] args) {
		System.out.print("This is the demo for the Webstaurant Technical Task\n");
		System.out.print("I can make a Store Inventory and make Products to go in it.\n");
		StoreInventory inventory = new StoreInventory();
		Product ball = new Product("BALL", "PR-1", 5.99, 12);

		System.out.print("The inventory before adding the ball:\n");
		inventory.listInventory();

		System.out.print("The inventory after adding the ball:\n");
		inventory.addProduct(ball);
		inventory.listInventory();

		System.out.print("I can add multiple more products:\n");
		Product jumprope = new Product("JUMPROPE", "PR-2", 4.99, 6);
		Product chalk = new Product("CHALK", "PR-3", 1.99, 20);
		inventory.addProduct(jumprope);
		inventory.addProduct(chalk);
		inventory.listInventory();

		System.out.print("I can also remove products:\n");
		inventory.removeProduct("PR-2");
		inventory.listInventory();

		System.out.print("I can change the quantity of products:\n");
		inventory.updateQuantity("PR-1", 14);
		inventory.listInventory();

		System.out.print("Finally, I can give the total value of the inventory:\n");
		inventory.getTotalValue();
	}
}
