package D20241017;

public interface Addable {
    String MSG = "hello";

    String addStr(String a, String b);

    static int addInt(int n1, int n2) {
        return n1 + n2;
    }

    default double addDouble(double n1, double n2) {
        return n1 + n2;
    }

}
