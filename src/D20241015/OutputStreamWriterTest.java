package D20241015;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OutputStreamWriterTest {
    public static void main(String[] args) {
//        10개의 문자를 기억할 수 있는 배열을 선언한다.
        char[] arr = new char[10];

//        키보드를 입력 스트립 리더 객체에 할당하고, 콘솔을 출력 스트림 리더 객체에 할당한다.
        InputStreamReader isr = new InputStreamReader(System.in);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);

        System.out.print("데이터를 입력하세요 >> ");

        try {
            int input = isr.read(arr);
            System.out.println(input);
            System.out.print("실제 입력된 글자 : ");
//            배열 내의 10개 문자를 출력한다.
            osw.write(arr);
            isr.close();
            osw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
