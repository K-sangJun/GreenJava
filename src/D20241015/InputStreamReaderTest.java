package D20241015;

import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
//    한글 1글자를 읽어들이는 프로그램.
    public static void main(String[] args) {

//        키보드를 입력 스트림 객체에 할당하고 그객체를 인수로 입력 스트립 리더 객체를 생성한다.
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);

        int inputData = 0;
        System.out.print("데이터를 입력하세요 : ");

        try {
//            InputStreamReader가 제공하는 read() 메소드는 2바이트를 읽어 정수 코드 값을 반환한다.
            inputData = isr.read();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("실제 입력된 데이터 : " + inputData);
        System.out.println("실제 입력된 데이터 : " + (char)inputData);

    }
}
