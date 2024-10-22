package D20241017;

public class TwoParamNoReturnTest {
    public static void main(String[] args) {
        Calculate c;

        c = (a, b) -> System.out.println(a + b);
        c.cal(4, 3);

        c = (a, b) -> System.out.println(a - b);
        c.cal(5, 3);

        c = (a, b) -> System.out.println(a * b);
        c.cal(6, 3);

        c = (a, b) -> System.out.println(a / b);
        c.cal(7, 3);

        c = (a, b) -> System.out.println(a % b);
        c.cal(8, 3);

    }
}
