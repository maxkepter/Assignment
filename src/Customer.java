public class Customer {
    private int customerId;
    private String name;
    private String email;

    public Customer(int customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public String getInfo() {
        return "CustomerId: " + this.customerId + ", Name: " + this.name + ", Email: " + this.email;

    }
}