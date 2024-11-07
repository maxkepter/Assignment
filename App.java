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
        while (isDupId(p, id)) {
            System.err.println("Id bi trung vui long nhap lai");
            id = checkInputInt();
        }
        return id;
    }

    private static boolean isDupId(List<Product> p, int id) {
        for (Product p1 : p) {
            if (p1.getProductId() == id) {
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
        String cusName;
        String cusEmail;
        int bquantity;
        List<Order> orders = new ArrayList<>();
        List<Product> khoHang = new ArrayList<>();
        while (true) {
            System.out.println("1. Tao moi don hang");
            System.out.println("2. In danh sach don hang");
            System.out.println("3. Quan ly kho hang");
            System.out.println("4.Thoát");
            System.out.print("Nhap lua chon cua ban: ");
            choice = checkInputInt();
            switch (choice) {
                case 1:
                    List<Product> products = new ArrayList<>();
                    boolean exitCase1_1 = false;
                    while (!exitCase1_1) {
                        System.out.println("Ban muon them san phan nhu nao");
                        System.out.println("1. Them thu cong");
                        System.out.println("2. Lay san pham tu trong kho");
                        int choiceCase1_1 = checkInputInt();
                        switch (choiceCase1_1) {
                            case 1:
                                while (true) {
                                    System.out.println("Nhap id san pham");
                                    productId = checkInputInt();
                                    while (isDupId(khoHang, productId) || isDupId(products, productId)) {
                                        System.out.println("ID san pham nay bi trung, vui long nhap lai");
                                        productId = checkInputInt();
                                    }
                                    System.out.println("Nhap ten san pham");
                                    name = sc.nextLine();
                                    System.out.println("Nhap gia san pham");
                                    price = checkInputDouble();
                                    System.out.println("Nhap so luong san pham");
                                    quantity = checkInputInt();
                                    Product p = new Product(productId, name, price, quantity);
                                    products.add(p);
                                    store.addProduct(p);
                                    System.out.println("Ban co muon cap nhat thong tin nua khong");
                                    System.out.println("1. Co");
                                    System.out.println("2. Khong");
                                    int exit1 = checkInputInt();
                                    if (exit1 == 2) {
                                        break;
                                    }
                                }
                                exitCase1_1 = true;
                                break;
                            case 2:
                                if (khoHang.isEmpty()) {
                                    System.out.println("Trong kho khong co do, vui long thu cach khac");

                                } else {
                                    while (true) {
                                        System.out.println("Nhap id san pham trong kho");
                                        int id = checkInputInt();
                                        int index = idToIndex(id, khoHang);
                                        while (!isDupId(khoHang, id)) {
                                            System.out.println("Khong ton tai san pham co ID nay,vui long nhap lai");
                                            id = checkInputInt();
                                        }
                                        products.add(khoHang.get(index));
                                        store.addProduct(khoHang.get(index));
                                        System.out.println("Ban co muon cap nhat thong tin nua khong");
                                        System.out.println("1. Co");
                                        System.out.println("2. Khong");
                                        int exit1 = checkInputInt();
                                        if (exit1 == 2) {
                                            exitCase1_1 = true;
                                            break;
                                        }
                                    }
                                }

                                break;
                        }
                    }

                    // Tao order moi
                    System.out.println("Vui long dien thong tin khach hang");
                    System.out.print("ID khach hang: ");
                    cusId = checkInputInt();
                    System.out.print("Ten khach hang: ");
                    cusName = sc.nextLine();
                    System.out.print("Email khach hang: ");
                    cusEmail = sc.nextLine();
                    System.out.print("Nhap id don hang: ");
                    orderId = checkInputInt();
                    Customer c = new Customer(cusId, cusName, cusEmail);

                    Order ord = store.createOrder(c);

                    for (Product prt : store.getProducts()) {
                        System.out.println(prt);
                    }

                    // Adding products to order
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
                    System.out.println("Danh sach don hang:");
                    for (Order o : store.getAllOrders()) {
                        System.out.println(o);
                    }
                    break;
                case 3:
                    System.out.println("1. Them do vao kho");
                    System.out.println("2. Cap nhat do");
                    System.out.println("3. Xem thong tin do trong kho");
                    System.out.println("4.Thoát");
                    System.out.print("Nhap lua chon cua ban: ");
                    int choice1 = checkInputInt();
                    boolean exit = false;
                    while (!exit) {
                        switch (choice1) {
                            case 1:
                                while (true) {
                                    System.out.println("Vui long nhap thong tin san pham");
                                    System.out.print("Nhap id san pham: ");
                                    productId = checkInputIdInt(khoHang);
                                    System.out.print("Nhap ten san pham: ");
                                    name = sc.nextLine();
                                    System.out.print("Nhap gia san pham: ");
                                    price = checkInputDouble();
                                    System.out.print("Nhap so luong san pham: ");
                                    quantity = checkInputInt();
                                    Product p = new Product(productId, name, price, quantity);
                                    khoHang.add(p);
                                    System.out.println("Da them san pham vao trong kho");
                                    System.out.println("Ban co muon them san pham khong");
                                    System.out.println("1. Co");
                                    System.out.println("2. Khong");
                                    int exit1 = checkInputInt();
                                    if (exit1 == 2) {
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                while (true) {
                                    String newName;
                                    double newPrice;
                                    int newQuantity;
                                    System.out.println("Vui long nhap ID san pham can cap nhat");
                                    int id = checkInputInt();
                                    int index = idToIndex(id, khoHang);
                                    while (!isDupId(khoHang, id)) {
                                        System.out.println("Khong ton tai san pham co ID nay,vui long nhap lai");
                                        id = checkInputInt();
                                    }
                                    System.out.println("Ban muon cap nhat thong tin gi");
                                    System.out.println("1. Cap nhat toan bo");
                                    System.out.println("2. Cap nhat ten san pham");
                                    System.out.println("3. Cap nhat gia san pham");
                                    System.out.println("4. Cap nhat so luong san pham");
                                    int choice2 = checkInputInt();
                                    switch (choice2) {
                                        case 1:

                                            System.out.println("Nhap ten moi");
                                            newName = sc.nextLine();
                                            System.out.println("Nhap gia moi");
                                            newPrice = checkInputDouble();
                                            System.out.println("Nhap so luong moi");
                                            newQuantity = checkInputInt();
                                            khoHang.get(index).setName(newName);
                                            khoHang.get(index).setPrice(newPrice);
                                            khoHang.get(index).setQuantity(newQuantity);
                                            break;
                                        case 2:
                                            System.out.println("Nhap ten moi");
                                            newName = sc.nextLine();
                                            khoHang.get(index).setName(newName);
                                            break;
                                        case 3:
                                            System.out.println("Nhap gia moi");
                                            newPrice = checkInputDouble();
                                            khoHang.get(index).setPrice(newPrice);
                                            break;
                                        case 4:
                                            System.out.println("Nhap so luong moi");
                                            newQuantity = checkInputInt();
                                            khoHang.get(index).setQuantity(newQuantity);
                                            break;
                                        default:
                                            throw new AssertionError();
                                    }
                                    System.out.println("Ban co muon cap nhat thong tin nua khong");
                                    System.out.println("1. Co");
                                    System.out.println("2. Khong");
                                    int exit1 = checkInputInt();
                                    if (exit1 == 2) {
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                for (int i = 0; i < khoHang.size(); i++) {
                                    khoHang.get(i).getInfo();
                                }
                                break;
                            default:
                                exit = true;
                        }
                    }
                default:
                    return;

            }
        }
    }
}