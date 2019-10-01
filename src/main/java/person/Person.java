package person;

public class Person {
    public int creditScore;
    public String state;

    public Person(Integer creditScore, String state) {
        // state can not be null
        if (state == null || creditScore == null){
            System.err.println("State or credit score cannot be null");
           // System.exit(0);
            return;
        }
        this.creditScore = creditScore;
        this.state = state;
    }
}
