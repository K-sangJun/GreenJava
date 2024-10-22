package D20241017;

public class InerfaceTest {
    public static void main(String[] args) {
        String msg = Addable.MSG;
        System.out.println(msg);

        int num = Addable.addInt(1, 2);
        System.out.println(num);

        MyClass mc = new MyClass();
        String str = mc.addStr("한우성", " 일까요?");
        System.out.println(str);

//        double dou = mc.addDouble(1, 2);
//        System.out.println(dou);
    }
}
