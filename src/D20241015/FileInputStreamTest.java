package D20241015;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) {
        int inputData = 0;
        FileInputStream file;

        try {
            file = new FileInputStream("C:/KSJ/WS/Java/dbCon/sample.txt");

            while ((inputData = file.read()) != -1) {
                System.out.print((char) inputData);
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
