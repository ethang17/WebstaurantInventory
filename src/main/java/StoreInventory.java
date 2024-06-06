import java.util.ArrayList;

public class StoreInventory {
	private ArrayList<Product> products = new ArrayList();

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void addProduct(Product newProduct) {
		products.add(newProduct);
	}

	private Product getProduct(String ID) {
		Product foundProduct = null;
		for (Product product : products) {
			if (product.getID().equals(ID)) {
				foundProduct = product;
				break;
			}
		}
		return foundProduct;
	}

	public void removeProduct(String productID) {
		Product productToRemove = getProduct(productID);
		if (productToRemove != null) {
			products.remove(productToRemove);
		} else {
			System.out.print("Product " + productID + " not found in inventory\n");
		}
	}

	public void updateQuantity(String ID, int newQuantity) {
		if (newQuantity >= 0) {
			Product product = getProduct(ID);
			product.updateQuantity(newQuantity);
		} else {
			System.out.print("Product " + ID + " was not set to " + newQuantity + "\n");
		}
	}

	public ArrayList<String> listInventory() {
		ArrayList<String> inventory = new ArrayList();
		System.out.print("-------------------------\nInventory:\n");
		System.out.printf("%1$10s %2$10s %3$5s %4$9s\n", "NAME", "ID", "QTY", "PRICE");
		for (Product product : products) {
			String productinfo = String.format("%1$10s %2$10s %3$5d %4$7.2f\n", product.getName(), product.getID(),
					product.getQuantity(), product.getPrice());
			System.out.print(productinfo);
			inventory.add(productinfo);
		}
		System.out.print("-------------------------\n");
		return inventory;
	}

	public double getTotalValue() {
		double totalValue = 0;
		for (Product product : products) {
			totalValue += product.getProductValue();
		}
		System.out.printf("Total Value of Inventory: $%6.2f\n", totalValue);
		return totalValue;
	}
}
