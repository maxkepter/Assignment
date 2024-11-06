import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Order createOrder(Customer customer) {
        Order order = new Order(orders.size() + 1, customer);
        orders.add(order);
        order.saveToFile();
        return order;
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public List<Product> getProducts() {
        return products;
    }
}