package D20241015;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("C:/KSJ/WS/Java/dbCon/aaa.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);

//            알파벳 문자들을 파일에 저장하기
            int alphaStart = 'a';
            for(int i = 0; i < 26; i++) {
                bos.write((char) alphaStart + i);
            }


            bos.flush();
            fos.close();
            bos.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
