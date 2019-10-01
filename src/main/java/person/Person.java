package person;

public class Person {
    public int creditScore;
    public String state;

    public Person(Integer creditScore, String state) {
        // credit score and state can not be null
        if (state == null || creditScore == null){
            System.err.println("State or credit score cannot be null");
            return;
        }
        this.creditScore = creditScore;
        this.state = state;
    }
}
