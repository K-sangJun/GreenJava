package D20241017;

interface HowLong{
    int len(String s);
}

public class OneParamAndReturnTest {
    public static void main(String[] args) {
        HowLong hl;

        hl = (s) -> {
            return s.length();
        };
        System.out.println(hl.len("I am so Happy"));

        hl = (s) -> s.length();
        System.out.println(hl.len("I am so Happy"));

        hl = String::length;
        System.out.println(hl.len("I am so Happy"));


    }
}
