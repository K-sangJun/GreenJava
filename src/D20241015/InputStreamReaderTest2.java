package D20241015;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderTest2 {
    public static void main(String[] args) {
//        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(System.in);

        int inputData = 0;
//        10개의 문자를 보관 할 수 있는 객체를 생성한다.
        char[] arr = new char[10];

        System.out.print("데이터를 입력하세요 : ");

        try {
//            배열의 크기만큼 배열에 문자를 읽어 들인 후 ... 읽어들인 문자의 개수를 반환한다.
            inputData = isr.read(arr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < inputData; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println(inputData - 1);
    }
}
