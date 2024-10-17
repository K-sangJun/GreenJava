package D20241010;

public class Outer { //외클
    private static int num = 0;

    static class Nested1 { //내클
        void add(int n){
            num += n;
        }
    }

    static class Nested2 {
        int get(){
            return num;
        }
    }

    public static void main(String[] args) {

        Outer.Nested1 n1 = new Outer.Nested1();
        n1.add(5);

        Outer.Nested2 n2 = new Outer.Nested2();
        System.out.println(n2.get());

    }

}
