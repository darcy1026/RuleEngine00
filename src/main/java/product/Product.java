package product;

public class Product {

    public String name;
    public double interest_rate;
    public boolean disqualified;

    public Product(String name, double interest_rate) {
        if(name == null){
            System.err.println("Product name cannot be null!!!");
            System.exit(0);
        }
        if (interest_rate <= 0){
            System.err.println("Interest rate cannot be less than or equal to 0");
            System.exit(0);
        }
        this.name = name;
        this.interest_rate = interest_rate;
    }
}

