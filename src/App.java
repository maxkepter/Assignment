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
                    System.out.print("Vui long nhap lai: ");
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
                    System.out.print("Vui long nhap la: ");
                    result = Double.parseDouble(sc.nextLine());
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Vui long nhap lai: ");
            }
        }
    }

    private static int updateInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                while (result < -1) {
                    System.out.print("Vui long nhap lai: ");
                    result = Integer.parseInt(sc.nextLine());
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Vui long nhap lai: ");
            }
        }
    }

    private static double updateDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                while (result < -1) {
                    System.out.print("Vui long nhap la: ");
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
        // Menu Data Field
        int mainChoice;
        int subChoice;
        int selectedProductId;
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
            System.out.println("3. In danh sach san pham");
            System.out.println("4. Cap nhat thong tin san pham");
            System.out.println("5. Thoat");
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
                        // Nhap sub menu
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
                                    System.out.print("ID san pham bi trung vui long nhap lai: ");
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
                                    System.out.print("Nhap dung luong san pham: ");
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
                                System.out.print("ID khach hang bi trung vui long nhap lai: ");
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

                            // Hien thi san pham hien co
                            System.out.println("Danh sach san pham hien co:");
                            for (Product p : products) {
                                System.out.println(p.getInfo());
                            }

                            // Khach chon san pham va so luong
                            while (true) {
                                System.out.print("Nhap ID san pham muon mua (hoac nhap 0 de ket thuc): ");
                                selectedProductId = checkInputInt();
                                if (selectedProductId == 0) {
                                    break; // Thoat chon
                                }
                                // Chon san pham
                                Product selectedProduct = null;
                                for (Product p : products) {
                                    if (p.getProductId() == selectedProductId) {
                                        selectedProduct = p;
                                        break;
                                    }
                                }
                                if (selectedProduct == null) {
                                    System.out.println("ID san pham khong hop le. Vui long nhap lai.");
                                    continue;
                                }
                                // Chon so luong
                                System.out.print(
                                        "Nhap so luong muon mua cho san pham " + selectedProduct.getName() + ": ");
                                bquantity = checkInputInt();

                                if (bquantity > selectedProduct.getQuantity()) {
                                    System.out.println("So luong khong du. Chi con " + selectedProduct.getQuantity()
                                            + " san pham.");
                                    continue;
                                }
                                // Them san pham vao order
                                ord.addProduct(selectedProduct, bquantity);
                                System.out.println("San pham da duoc them vao don hang.");
                            }
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
                    // Print all orders
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
                    System.out.println("Danh sach san pham hien co:");
                    for (Product p : products) {
                        System.out.println(p.getInfo());
                    }
                    break;
                case 4:
                    // Kiem tra neu danh sach san pham trong
                    if (products.isEmpty()) {
                        System.out.println("Khong co san pham"); // Thong bao khong co san pham nao trong danh sach
                    } else {
                        // Yeu cau nguoi dung nhap ID san pham can cap nhat
                        System.out.print("Nhap ID san pham can cap nhat: ");
                        int updateProductId = checkInputInt();

                        // Tim vi tri cua san pham co ID can cap nhat trong danh sach
                        int productIndex = idToIndex(updateProductId, products);

                        // Neu ID khong ton tai, yeu cau nhap lai cho den khi ton tai
                        while (productIndex == -1) {
                            System.out.println("San pham khong ton tai");
                            System.out.println("Nhap lai ID san pham");
                            updateProductId = checkInputInt();
                            productIndex = idToIndex(updateProductId, products);
                        }

                        // Lay san pham can cap nhat bang ID tu danh sach
                        Product productToUpdate = products.get(productIndex);
                        System.out.println("Cap nhat thong tin cho san pham: " + productToUpdate.getName());

                        // Nhap ten moi cho san pham (de trong neu khong muon thay doi)
                        System.out.print("Nhap ten moi (de trong neu khong muon thay doi): ");
                        String newName = sc.nextLine();
                        if (!newName.trim().isEmpty()) {
                            productToUpdate.setName(newName);
                        }

                        // Nhap gia moi cho san pham (nhap -1 neu khong thay doi)
                        System.out.println("Gia hien tai: " + productToUpdate.getPrice());
                        System.out.print("Nhap gia moi (nhap -1 neu khong thay doi): ");
                        double newPrice = updateDouble();
                        if (newPrice >= 0) {
                            productToUpdate.setPrice(newPrice);
                        }

                        // Nhap so luong moi cho san pham (nhap -1 neu khong thay doi)
                        System.out.println("So luong hien tai: " + productToUpdate.getQuantity());
                        System.out.print("Nhap so luong moi (nhap -1 neu khong thay doi): ");
                        int newQuantity = updateInt();
                        if (newQuantity >= 0) {
                            productToUpdate.setQuantity(newQuantity);
                        }

                        // Thong bao cap nhat thanh cong thong tin san pham
                        System.out.println("Thong tin san pham da duoc cap nhat.");
                    }

                    break;
                case 5:
                    System.out.println("Thoat chuong trinh.");
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }
        }
    }
}
