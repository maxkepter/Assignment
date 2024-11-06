import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap lai: ");
            }
        }
    }

    private static double checkInputDouble() {
        while (true) {
            try {
                double result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap lai: ");
            }
        }
    }

    public static void main(String[] args) {
        Store s = new Store();
        int choice;
        int soSanPham;
        int orderId;
        int productId;
        String name;
        double price;
        int quantity;
        int cusId;
        String cusName;
        String cusEmail;
        List<Product> products=new ArrayList<>();
        System.out.println("1. Tao moi don hang");
        System.out.println("2. In danh sach don hang");
        choice = Integer.parseInt(sc.nextLine());
        while (true) {
                    System.out.println("So san pham khach hang mua");
                    soSanPham=checkInputInt();
                    for(int i=0;i<soSanPham;i++){
                    System.out.println("Nhap id san pham");
                    productId = checkInputInt();
                    System.out.println("Nhap ten san pham");
                    name = sc.nextLine();
                    System.out.println("Nhap gia san pham");
                    price = checkInputDouble();
                    System.out.println("Nhap so luong san pham");
                    quantity = checkInputInt();
                    Product p=new Product(productId, name, price, quantity);
                    products.add(p);
                    }
                    
                    
                    System.out.println("Dien thong tin khach hang");
                    System.out.println("Dien thong ID khach hang");
                    cusId=checkInputInt();
                    System.out.println("Dien thong ten khach hang");
                    cusName=sc.nextLine();
                    System.out.println("Dien thong Email khach hang");
                    cusEmail=sc.nextLine();
                    System.out.println("Nhap id don hang");
                    orderId=checkInputInt();
                    Customer c=new Customer(cusId, cusName, cusEmail);
                    for (int i = 0; i < 10; i++) {
                        
                    }
                    Order o=new Order(orderId, c);
                    
                    break;
                case 2:

                    break;
                default:
                    throw new AssertionError();
         

    }
}
}