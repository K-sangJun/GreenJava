package D20241017;

public class OneParamNoReturnTest {
    public static void main(String[] args) {
        Printable p;

        p = (String s) -> {
            System.out.println(s);
        };

        p.print("람다 표현 일");

        p = (String s) -> System.out.println(s);
        p.print("람다 표현 둘");
        
        p = (s) -> System.out.println(s);
        p.print("람다 표현 셋");
        
        p = s -> System.out.println(s);
        p.print("람다 표현 사");

        p = System.out::println;
        p.print("람다 황승 현");
    }
}
