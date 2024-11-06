import java.util.ArrayList;
import java.util.List;

public class Store {
    List<Product> products = new ArrayList<>();
    List<Order> orders = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Order createOrder(Customer customer) {
        Order order = new Order(orders.size() + 1, customer);
        orders.add(order);
        return order;
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}