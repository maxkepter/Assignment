public class Main {
    public static void main(String[] args) {

        Store store = new Store();

        Product product1 = new Product(1, "Laptop", 1000, 5);
        Product product2 = new DigitalProduct(2, "E-Book", 20, 50, 1.5); // Sản phẩm kỹ thuật số

        store.addProduct(product1);
        store.addProduct(product2);

        Customer customer1 = new Customer(1, "John Doe", "john@example.com");

        Order order1 = store.createOrder(customer1);
        order1.addProduct(product1, 2);
        order1.addProduct(product2, 1);

        Product product3 = new Product(3, "IPhone 16 ProMax", 2000, 15);
        Product product4 = new DigitalProduct(4, "PFC E-Book", 200, 50, 1.5);

        store.addProduct(product3);
        store.addProduct(product4);

        Order order2 = store.createOrder(customer1);
        order2.addProduct(product3, 10);
        order2.addProduct(product4, 2);

        // In ra danh sách đơn hàng
        System.out.println("All Orders:");
        for (Order order : store.getAllOrders()) {
            System.out.println(order.getOrderDetails());
        }
    }
}