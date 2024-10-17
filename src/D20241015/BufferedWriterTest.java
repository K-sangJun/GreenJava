package D20241015;

import java.io.*;
import java.util.StringTokenizer;

public class BufferedWriterTest {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("C:/KSJ/WS/Java/dbCon/aaa.txt");
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter("C:/KSJ/WS/Java/dbCon/bbb.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            int count = 1;
            String line = br.readLine();

            while (line != null) {
//                읽은라인을 공백을 기준으로 토큰으로 구분하는 객체를 생성한다.
                StringTokenizer st = new StringTokenizer(line, " ");

                while (st.hasMoreTokens()) {
//                    읽은 라인 내에 '자바' 라는 단어가 있으면 출력 버퍼에 기록하고
//                    버퍼의 내용을 파일에 기억한다.
                    if (st.nextToken().equals("자바")){
                        bw.write(line);
                        bw.flush();
                        bw.newLine();
                        break;
                    }
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
