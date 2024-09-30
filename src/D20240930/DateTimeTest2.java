package D20240930;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeTest2 {
    public static void main(String[] args) {
//        현재시각 구하기
        Date date1 = new Date();

        Calendar c = Calendar.getInstance();
        System.out.println("Calendet Instance : " + c);
        Date date2 = c.getTime();

        System.out.println(date1);
        System.out.println(date2);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        Calendar c2 = Calendar.getInstance();
        c2.set(2024,Calendar.AUGUST,26, 0, 0, 0);
        System.out.println(sdf.format(c2.getTime()));

    }
}
