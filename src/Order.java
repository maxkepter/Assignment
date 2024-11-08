import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<OrderProduct> orderProducts = new ArrayList<>();
    private double totalAmount;
    File Orderf = new File("C:\\Users\\Admin\\OneDrive\\Desktop\\Assignment\\New folder\\Assignment\\Order.txt");

    public Order(int orderId, Customer customer) {
        this.customer = customer;
        this.orderId = orderId;
    }

    public void addProduct(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("Khong co du so luong trong kho.");
        } else {
            // Thêm sản phẩm vào đơn hàng với thông tin tại thời điểm đơn hàng được tạo
            if (product.isDigital() != -1) {
                orderProducts
                        .add(new OrderProduct(product.getProductId(), product.getName(), product.getPrice(), quantity,
                                product.isDigital()));
                product.updateQuantity(quantity);
            } else {
                orderProducts
                        .add(new OrderProduct(product.getProductId(), product.getName(), product.getPrice(), quantity));
                product.updateQuantity(quantity);
            }

        }
    }

    public double calculateTotal() {
        totalAmount = 0;
        for (OrderProduct orderProduct : orderProducts) {
            totalAmount += orderProduct.getProductPrice() * orderProduct.getQuantity();
        }
        return totalAmount;
    }

    public String getOrderDetails() {
        String detail = "Order ID: " + Integer.toString(orderId) + ", " + customer.getInfo();
        for (OrderProduct orderProduct : orderProducts) {
            detail += "\nProductID: " + orderProduct.getProductId() + ", Name: " + orderProduct.getProductName()
                    + ", Price: " + orderProduct.getProductPrice() +
                    ", Quantity: " + orderProduct.getQuantity();
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
