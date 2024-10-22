package D20241017;

public class LambdaTest2 {
    public static void main(String[] args) {
        Printable prn = new Printable() {

            @Override
            public void print(String s) {
                System.out.println(s);
            }
        };

        prn.print("Hello");
    }
}
