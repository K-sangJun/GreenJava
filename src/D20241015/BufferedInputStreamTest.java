package D20241015;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamTest {

    public static void main(String[] args) {
        int inputData = 0;
        try {
            FileInputStream fis = new FileInputStream("C:/KSJ/WS/Java/dbCon/sample.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);

            while((inputData = bis.read()) != -1) {
                System.out.print((char)inputData);
            }

            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
