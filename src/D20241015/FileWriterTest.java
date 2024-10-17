package D20241015;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {

        try {
            FileReader fr = new FileReader("C:/KSJ/WS/Java/dbCon/sample2.txt");
            FileWriter fw = new FileWriter("C:/KSJ/WS/Java/dbCon/sample3.txt", true);

            int input = 0;
            while ((input = fr.read()) != -1) {
                fw.write(input);
            }

            fr.close();
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
