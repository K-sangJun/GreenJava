package D20241010;

public class Customer {

    enum Gender {
        MALE, FEMALE
    }

    String name;
    Gender gen;

    public Customer(String n, String g) {
        name = n;
        if (g.equals("man")) {
            gen = Gender.MALE;
        } else {
            gen = Gender.FEMALE;
        }
    }

    @Override
    public String toString() {
        String msg = "Thank you, ";
        msg += this.gen == Gender.MALE ? "Mr. " : "Mrs. ";
        msg += name;

        return msg;
    }
}