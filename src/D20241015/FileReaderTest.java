package D20241015;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

    public static void main(String[] args) {

        FileReader file;

        int inputData = 0;

        try {
            file = new FileReader("C:/KSJ/WS/Java/dbCon/sample2.txt");

            while ((inputData = file.read()) != -1){
                System.out.print((char)inputData);
            }
            file.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
