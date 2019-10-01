package product;

public class Product {
    public String name;
    public double interest_rate = 5.0;
    public boolean disqualified;

    public Product(String name, Double interest_rate) {
        // name and interest rate can not be null
        if (name == null || interest_rate == null) {
            System.err.println("Product name cannot be null!!!");
            System.exit(0);
        }
        this.name = name;
        this.interest_rate = interest_rate;
    }
}