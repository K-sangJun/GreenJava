package D20241017;

public class LambdaTest4 {
    public static void showString(Printable p, String s) {
        p.print(s);
    };

    public static void main(String[] args) {
        showString((s) -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(s);
            }
        } ,"람다 표현식으로 매개변수를 표현해 보자.");
    }
}
