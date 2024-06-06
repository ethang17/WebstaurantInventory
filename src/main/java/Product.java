public class Product {

	private final String name;
	private final String id;
	private final double price;
	private int quantity;

	public Product(String name, String id, double price, int quantity) {
		this.name = name;
		this.id = id;
		this.price = price;
		this.quantity = quantity;
	}

	public void updateQuantity(int newQuantity) {
		quantity = newQuantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getProductValue() {
		return price * (double) quantity;
	}
}
