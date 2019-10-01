package person;

public class Person {
    public int creditScore;
    public String state;

    public Person(int creditScore, String state) {
        if (state==null){
            System.err.println("State cannot be null");
            System.exit(0);
        }
        if (creditScore < 300 || creditScore > 850){
            System.err.println("Credit score cannot be less than 300 or greater then 850");
            System.exit(0);
        }
        this.creditScore = creditScore;
        this.state = state;
    }
}
