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
    private List<Integer> productQuan = new ArrayList<>();
    private double totalAmount;
    File Orderf = new File("C:\\Users\\Admin\\OneDrive\\Desktop\\Assignment\\Assignment\\Order.txt");

    public Order(int orderId, Customer customer) {
        this.customer = customer;
        this.orderId = orderId;
    }

    public void addProduct(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("Khong co du so luong trong kho.");
        } else {
            products.add(product);
            product.updateQuantity(quantity);
            productQuan.add(quantity);
            saveOrderToFile();
        }

    }

    public double calculateTotal() {
        for (int i = 0; i < products.size(); i++) {
            totalAmount += products.get(i).getPrice() * productQuan.get(i);
        }
        return totalAmount;
    }

    public String getOrderDetails() {
        String detail = "Order ID: " + Integer.toString(orderId) + ", " + customer.getInfo();
        for (int i = 0; i < products.size(); i++) {
            detail += "\n";
            detail += " - " + products.get(i).getOrderInfo() + ", Quantity: " + productQuan.get(i);
        }
        detail += String.format("\nTotal Amount: %.2f", calculateTotal());

        return detail;
    }

    public void saveOrderToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Orderf, true))) {
            writer.write(getOrderDetails());
            writer.write("\n---------------------------\n");
            System.out.println("Thong tin don hang da duoc luu vao file: " + Orderf.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Co loi khi ghi thong tin: " + e.getMessage());
        }
    }

    public int getOrderId() {
        return orderId;
    }

}