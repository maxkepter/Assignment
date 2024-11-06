import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products = new ArrayList<>();
    private double totalAmount;

    public Order(int orderId,Customer customer) {
        this.customer = customer;
        this.orderId = orderId;
    }

    public void addProduct(Product product, int quantity) {
        products.add(product);
        product.updateQuantity(quantity);

    }

    public double calculateTotal() {
        for (int i = 0; i < products.size(); i++) {
            totalAmount += products.get(i).getPrice();
        }
        return totalAmount;
    }

    public String getOrderDetails() {
        String detail = "Order ID: " + Integer.toString(orderId) + ", " + customer.getInfo();
        for (int i = 0; i < products.size(); i++) {
            detail += "\n";
            detail += " - " + products.get(i).getInfo();
        }
        return customer.getInfo();
    }
}
