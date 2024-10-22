package D20241017;

public class TwoParamAndReturnTest {
    public static void main(String[] args) {

        Calculate2 c;

        c = (a, b) -> a + b;
        System.out.println(c.calc(4, 5));

        c = (a, b) -> {
            return a - b;
        };
        System.out.println(c.calc(4, 5));

        c = (a, b) -> a * b;
        System.out.println(c.calc(4, 5));

        c = (a, b) -> a / b;
        System.out.println(c.calc(4, 5));

        c = (a, b) -> a % b;
        System.out.println(c.calc(4, 5));

    }
}
