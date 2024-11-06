import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products = new ArrayList<>();
    private double totalAmount;
    File f = new File("\"C:\\Users\\Admin\\OneDrive\\Desktop\\Assignment\\Assignment\\Order.txt\"");

    public Order(
            int orderId, Customer customer) {
        this.customer = customer;
        this.orderId = orderId;
    }

    public void addProduct(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("Not enough quantity in stock.");
        } else {
            products.add(product);
            product.updateQuantity(quantity);
        }

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

        return detail;
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f, true))) { 
            writer.write(getOrderDetails());
            writer.write("\n---------------------------\n"); 
            System.out.println("Thong tin don hang da duoc luu vao file: " + f.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Co loi khi ghi thong tin: " + e.getMessage());
        }
    }
}
