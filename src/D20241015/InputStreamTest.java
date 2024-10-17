package D20241015;

import java.io.InputStream;

public class InputStreamTest {
//    InputStream 클래스를 사용하여 1개의 영문자(1바이트)를 읽어들이는 프로그램
    public static void main(String[] args) {
//        키보드를 입력 스트림 객체에 할당한다.
        InputStream is = System.in;

        int inputData = 0;
        System.out.print("데이터를 입력하세여 >> ");

        try{
            inputData = is.read();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("실제 입력된 데이터(정수) : " + inputData);
        System.out.println("실제 입력된 데이터(정수) : " + (char) inputData);
    }
}
