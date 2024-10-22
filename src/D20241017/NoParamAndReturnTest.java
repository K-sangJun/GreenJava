package D20241017;

import java.util.Random;

interface Generator{
    int rand();
}

public class NoParamAndReturnTest {
    public static void main(String[] args) {
        Generator g;

        g = () -> {
            Random rand = new Random();
            return rand.nextInt(10);
        };

        System.out.println(g.rand());
    }
}
