package D20241017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TVFactoryTest {

    public static void main(String[] args) {

        String txt = "C:/KSJ/WS/Java/dbCon/src/D20241017/brand.txt";
        try {
            FileReader fr = new FileReader(txt);
            BufferedReader br = new BufferedReader(fr);

            String data = br.readLine();
            TV tv = TVFactory.CreateTV(data);

            if (tv != null) {
                tv.turnOn();
                tv.volumeUp();
                tv.volumeDown();
                tv.turnOff();
            } else {
                System.out.println("존재하지 않는 브랜드 입니다.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
