public class OrderProduct {
    private int productId;
    private String productName;
    private double productPrice;
    private int quantity;
    private double fileSize = -1;

    public OrderProduct(int productId, String productName, double productPrice, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public OrderProduct(int productId, String productName, double productPrice, int quantity, double fileSize) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.fileSize = fileSize;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getFileSize() {
        return fileSize;
    }

    public int getProductId() {
        return productId;
    }

    public String getInfo() {
        return "ProductID: " + this.productId + ", Name: " + this.productName + ", Price: " + this.productPrice
                + ", Quantity: "
                + this.quantity;
    }

}
