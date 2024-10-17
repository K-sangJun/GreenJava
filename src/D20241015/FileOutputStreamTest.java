package D20241015;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C:/KSJ/WS/Java/dbCon/sample2.txt");
            FileOutputStream fos = new FileOutputStream("C:/KSJ/WS/Java/dbCon/sample3.txt");

            int input = 0;
            while ((input = fis.read()) != -1){
                fos.write(input);
            }

            fos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
