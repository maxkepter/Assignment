public class Product {
  private int productId;
  private String name;
  private double price;
  private int quantity;

  public Product(int productId, String name, double price, int quantity) {
    this.productId = productId;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public String getInfo() {
    return "ProductID: " + this.productId + ", Name: " + this.name + ", Price: " + this.price + ", Quantity: "
        + this.quantity;
  }

  public void updateQuantity(int quantity) {
    this.quantity -= quantity;
  }

}