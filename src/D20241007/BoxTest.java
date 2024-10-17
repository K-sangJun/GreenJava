package D20241007;

public class BoxTest {
    public static void main(String[] args) {

        Box<String> box = new Box();
        box.setObj("aaa");

        String s = box.getObj();
        System.out.println(s);

    }
}
