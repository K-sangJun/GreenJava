package D20241015;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderTest {
    public static void main(String[] args) {

        String inputData = null;

        try {
            FileReader fr = new FileReader("C:/KSJ/WS/Java/dbCon/sample.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((inputData = br.readLine()) != null){
                System.out.println(inputData);
            }

            br.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
