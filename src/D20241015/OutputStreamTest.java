package D20241015;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OutputStreamTest {
    public static void main(String[] args) {
        InputStream in = System.in;
        OutputStream out = System.out;

        System.out.print("데이터를 입력하세요 >> ");

        try {
            int input = in.read();
            System.out.println("실제 입력된 데이터 : " + input);

            System.out.print("출력 데이터 : ");
            out.write((char) input);

            in.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
