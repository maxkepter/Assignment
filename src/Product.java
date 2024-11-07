import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Product {
  private int productId;
  private String name;
  private double price;
  private int quantity;
  File Productf = new File("E:\\PL\\Git\\Github\\Assignment\\Product.txt");


  public Product(int productId, String name, double price, int quantity) {
    this.productId = productId;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }
  //Lay thong tin product
  public String getInfo() {
    return "ProductID: " + this.productId + ", Name: " + this.name + ", Price: " + this.price + ", Quantity: "
        + this.quantity;
  }
  //Lay thong tin product cho order
  public String getOrderInfo() {
    return "ProductID: " + this.productId + ", Name: " + this.name + ", Price: " + this.price;
  }

  public void updateQuantity(int quantity) {
    this.quantity -= quantity;
  }

  public int getProductId() {
    return productId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void saveProductToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Productf, true))) {
            writer.write(getInfo());
            writer.write("\n---------------------------\n");
            System.out.println("Thong tin san da duoc luu vao file: " + Productf.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Co loi khi ghi thong tin: " + e.getMessage());
        }
    }

}