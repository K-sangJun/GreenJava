package D20240930;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndStringTest {

    public static void main(String[] args) {

//        날짜 형식 지정하기
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        문자열 날짜데이터로 변경하기
        try {
            Date date = sdf.parse("2024-08-21 22:32:12");
            System.out.println(date);

//            날짜를 문자열로 변경하기
            String str = sdf.format(date);
            System.out.println(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
