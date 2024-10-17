package D20241010;

class Outer1{
    private int num = 0;

    class Member{
        void add(int n){
            num += n;
        }
        int get(){
            return num;
        }
    }
}

public class MemberInnerEx {

    public static void main(String[] args) {
        Outer1 o1 = new Outer1();
        Outer1 o2 = new Outer1();

        Outer1.Member o1M1 = o1.new Member();
        Outer1.Member o2M2 = o2.new Member();

        o1M1.add(10);
        System.out.println(o1M1.get());

        o2M2.add(5);
        System.out.println(o2M2.get());

    }

}
