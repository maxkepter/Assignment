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
                System.out.print("Vui long nhap lai: ");
            }
        }
    }

    private static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Vui long nhap lai: ");
            }
        }
    }

    private static int idToIndex(int id, List<Product> p) {
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getProductId() == id) {
                return i;
            }
        }
        return -1;
    }

    private static int checkInputIdInt(List<Product> p) {
        int id;
        id = checkInputInt();
        while (isDupIdProduct(p, id)) {
            System.err.println("Id bi trung vui long nhap lai");
            id = checkInputInt();
        }
        return id;
    }

    private static boolean isDupIdProduct(List<Product> p, int id) {
        if (p.isEmpty()) {
            return false;
        }
        for (Product p1 : p) {
            if (p1.getProductId() == id) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDupIdCus(List<Customer> c, int id) {
        if (c.isEmpty()) {
            return false;
        }
        for (Customer c1 : c) {
            if (c1.getCustomerId() == id) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDupIdOrder(List<Order> o, int id) {
        if (o.isEmpty()) {
            return false;
        }
        for (Order o1 : o) {
            if (o1.getOrderId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Store store = new Store();
        int choice;
        int soSanPham;
        int orderId;
        int productId;
        String name;
        double price;
        int quantity;
        int cusId;
        double fileSize;
        String cusName;
        String cusEmail;
        int bquantity;
        List<Order> orders = new ArrayList<>();
        List<Customer> cs = new ArrayList<>();
        while (true) {
            System.out.println("Quan ly cua ban hang ");
            System.out.println("-------------------------------");
            System.out.println("Ban muon lam gi");
            System.out.println("1. Tao moi don hang");
            System.out.println("2. In danh sach don hang");
            System.out.println("3. Thoat");
            System.out.println("-------------------------------");
            choice = checkInputInt();
            switch (choice) {
                case 1:
                    // Them san pham
                    List<Product> products = new ArrayList<>();
                    System.out.println("-------------------------------");

                    while (true) {
                        Product p = null;
                        System.out.println("Vui long nhap thong tin san pham");
                        System.out.println("Chon loai san pham");
                        System.out.println("1. San pham thuong");
                        System.out.println("2. San pham dien tu");
                        int typeProduct = checkInputIdInt(products);
                        while (typeProduct != 1 && typeProduct != 2) {
                            System.out.println("Lua chon khong hop le vui long nhap lai");
                            typeProduct = checkInputInt();
                        }
                        System.out.print("Nhap id san pham: ");
                        productId = checkInputInt();
                        while (isDupIdProduct(store.getProducts(), productId)) {
                            System.out.println("ID san pham bi trung vui long nhap lai");
                            productId = checkInputInt();
                        }
                        System.out.print("Nhap ten san pham: ");
                        name = sc.nextLine();
                        System.out.print("Nhap gia san pham: ");
                        price = checkInputDouble();
                        System.out.print("Nhap so luong san pham: ");
                        quantity = checkInputInt();
                        if (typeProduct == 2) {
                            System.out.println("Nhap dung luong san pham");
                            fileSize = checkInputDouble();
                            p = new DigitalProduct(productId, name, price, quantity, fileSize);
                        } else {
                            p = new Product(productId, name, price, quantity);
                        }
                        products.add(p);
                        store.addProduct(p);
                        System.out.println("San pham da duoc them");
                        System.out.println("-------------------------------");
                        System.out.println("Ban co muon them san pham nua khong(1.Co/2.Khong)");
                        int choiceCase1_1 = checkInputInt();
                        if (choiceCase1_1 == 2) {
                            break;
                        }
                    }
                    // Tao order moi
                    System.out.println("Vui long dien thong tin khach hang");
                    System.out.print("ID khach hang: ");
                    cusId = checkInputInt();
                    while (isDupIdCus(cs, cusId)) {
                        System.out.println("ID khach hang bi trung vui long nhap lai");
                        cusId = checkInputInt();
                    }
                    System.out.print("Ten khach hang: ");
                    cusName = sc.nextLine();
                    System.out.print("Email khach hang: ");
                    cusEmail = sc.nextLine();
                    Customer c = new Customer(cusId, cusName, cusEmail);
                    cs.add(c);
                    System.out.println("-------------------------------");
                    System.out.print("Nhap id don hang: ");
                    orderId = checkInputInt();
                    while (isDupIdOrder(orders, orderId)) {
                        System.out.println("ID don hang bi trung vui long nhap lai");
                        orderId = checkInputInt();
                    }
                    Order ord = store.createOrder(c);
                    orders.add(ord);
                    // for (Product prt : store.getProducts()) {
                    // System.out.println(prt);
                    // }

                    // Adding products to order
                    System.out.println("-------------------------------");
                    for (Product p : products) {
                        System.out.println(p.getInfo());
                        System.out.print("Nhap so luong muon mua cho san pham: ");
                        bquantity = checkInputInt();
                        ord.addProduct(p, bquantity);
                    }
                    System.out.println("Don hang da duoc tao.");
                    break;
                case 2:
                    // Print all orders
                    if (store.getAllOrders().isEmpty()) {
                        System.out.println("Khong co don hang");
                    } else {
                        System.out.println("All order");
                        for (Order o : store.getAllOrders()) {
                            System.out.println(o.getOrderDetails());
                        }
                    }
                    break;
                default:
                    System.exit(0);

            }
        }
    }
}