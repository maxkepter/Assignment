import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                while (result < 0) {
                    System.out.println("Vui long nhap lai");
                    result = Integer.parseInt(sc.nextLine());
                }
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
                while (result < 0) {
                    System.out.println("Vui long nhap lai");
                    result = Double.parseDouble(sc.nextLine());
                }
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
        // Menu lua chon
        int mainChoice;
        int subChoice;
        // Product Data Field
        int productId;
        String name;
        double price;
        int quantity;
        double fileSize;
        // Customer Data Field
        int cusId;
        String cusName;
        String cusEmail;
        // Order Data Field
        int bquantity;
        int orderId;
        // Array List
        List<Product> products = new ArrayList<>();
        List<Customer> cs = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        while (true) {
            System.out.println("Quan ly cua ban hang ");
            System.out.println("-------------------------------");
            System.out.println("Ban muon lam gi");
            System.out.println("1. Tao moi don hang");
            System.out.println("2. In danh sach don hang");
            System.out.println("3. Cap nhat thong tin san pham");
            System.out.println("4. Thoat");
            System.out.println("-------------------------------");
            mainChoice = checkInputInt();
            switch (mainChoice) {
                case 1:
                    // Them san pham
                    System.out.println("-------------------------------");
                    while (true) {
                        System.out.println("1. Them san pham");
                        System.out.println("2. Tao order");
                        System.out.println("3. Thoat");
                        subChoice = checkInputInt();
                        if (subChoice == 1) {
                            System.out.println("-------------------------------");
                            while (true) {
                                Product p = null;
                                // Nhap loai san pham
                                System.out.println("Vui long nhap thong tin san pham");
                                System.out.println("Chon loai san pham");
                                System.out.println("1. San pham thuong");
                                System.out.println("2. San pham dien tu");
                                // Kiem tra dau vao loai san pham
                                int typeProduct = checkInputInt();
                                while (typeProduct != 1 && typeProduct != 2) {
                                    System.out.println("Lua chon khong hop le vui long nhap lai");
                                    typeProduct = checkInputInt();
                                }
                                // Nhap thong tin san pham
                                System.out.print("Nhap id san pham: ");
                                productId = checkInputInt();
                                // Check ID san pham
                                while (isDupIdProduct(store.getProducts(), productId)) {
                                    System.out.println("ID san pham bi trung vui long nhap lai");
                                    productId = checkInputInt();
                                }
                                // Thong tin
                                System.out.print("Nhap ten san pham: ");
                                name = sc.nextLine();
                                System.out.print("Nhap gia san pham: ");
                                price = checkInputDouble();
                                System.out.print("Nhap so luong san pham: ");
                                quantity = checkInputInt();
                                // Data field san pham loai 2
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
                                // Them san pham nua hoac khong
                                System.out.println("Ban co muon them san pham nua khong(1.Co/2.Khong)");
                                int choiceCase1_1 = checkInputInt();
                                if (choiceCase1_1 == 2) {
                                    break;
                                }
                            }
                        } // subChoice 1 end

                        // subChoice 2 start
                        else if (subChoice == 2) {
                            // Tao order moi

                            // Dien thong tin khach hang
                            System.out.println("Vui long dien thong tin khach hang");
                            System.out.print("ID khach hang: ");
                            cusId = checkInputInt();
                            // Kiem tra Id khach hang
                            while (isDupIdCus(cs, cusId)) {
                                System.out.println("ID khach hang bi trung vui long nhap lai");
                                cusId = checkInputInt();
                            }
                            // Nhap thong tin
                            System.out.print("Ten khach hang: ");
                            cusName = sc.nextLine();
                            System.out.print("Email khach hang: ");
                            cusEmail = sc.nextLine();
                            Customer c = new Customer(cusId, cusName, cusEmail);
                            cs.add(c);
                            System.out.println("-------------------------------");
                            // Them don hang
                            System.out.print("Nhap id don hang: ");
                            orderId = checkInputInt();
                            while (isDupIdOrder(orders, orderId)) {
                                System.out.println("ID don hang bi trung vui long nhap lai");
                                orderId = checkInputInt();
                            }
                            Order ord = store.createOrder(c);
                            orders.add(ord);
                            // Mua san pham
                            System.out.println("-------------------------------");
                            for (Product p : products) {
                                System.out.println(p.getInfo());
                                System.out.print("Nhap so luong muon mua cho san pham: ");
                                bquantity = checkInputInt();
                                if (bquantity > 0) {
                                    ord.addProduct(p, bquantity);
                                }

                            }
                            ord.saveOrderToFile();
                            System.out.println("Don hang da duoc tao.");
                        } // subChoice 2 end

                        // subChoice 3 start
                        else if (subChoice == 3) {
                            break; // Quay lai Menu
                        } // subChoice 3 end

                        // else start
                        else {
                            System.out.println("Lua chon khong hop le. Vui long nhap lai.");
                        } // else end

                    }
                    break;

                case 2:
                    // In don hang

                    if (store.getAllOrders().isEmpty()) {
                        System.out.println("Khong co don hang");
                    } else {
                        System.out.println("Tat ca don hang");
                        for (Order o : store.getAllOrders()) {
                            System.out.println(o.getOrderDetails());
                        }
                    }
                    break;
                case 3:
                    if (products.isEmpty()) {
                        System.out.println("Khong co san pham");
                    } else {
                        System.out.print("Nhap ID san pham can cap nhat: ");
                        int updateProductId = checkInputInt();
                        int productIndex = idToIndex(updateProductId, products);
                        while (updateProductId == -1) {
                            System.out.println("San pham khong ton tai");
                            System.out.println("Nhap lai ID san pham");
                            updateProductId = checkInputInt();
                        }
                        Product productToUpdate = products.get(productIndex);
                        System.out.println("Cap nhat thong tin cho san pham: " + productToUpdate.getName());

                        System.out.print("Nhap ten moi (de trong neu khong muon thay doi): ");
                        String newName = sc.nextLine();
                        if (!newName.trim().isEmpty()) {
                            productToUpdate.setName(newName);
                        }

                        System.out.print("Nhap gia moi (nhap -1 neu khong thay doi): ");
                        double newPrice = checkInputDouble();
                        if (newPrice >= 0) {
                            productToUpdate.setPrice(newPrice);
                        }

                        System.out.print("Nhap so luong moi (nhap -1 neu khong thay doi): ");
                        int newQuantity = checkInputInt();
                        if (newQuantity >= 0) {
                            productToUpdate.setQuantity(newQuantity);
                        }

                        System.out.println("Thong tin san pham da duoc cap nhat.");
                    }

                    break;
                case 4:
                    System.out.println("Thoat chuong trinh.");
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }
        }
    }
}
