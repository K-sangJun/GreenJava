package D20241017;

public class LambdaTest3 {
    public static void main(String[] args) {
        Printable prn = (String s) -> System.out.println(s);

        prn.print("이거라구..");
    }
}
