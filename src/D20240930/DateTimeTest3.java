package D20240930;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeTest3 {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDate now2 = LocalDate.now();
        System.out.println(now2);

        LocalTime now3 = LocalTime.now();
        System.out.println(now3);

        System.out.println(now.getYear());
        System.out.println(now.getMonth());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getNano());

        LocalDateTime birthday = LocalDateTime.now();
        System.out.println(birthday);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String str1 = birthday.format(dtf);
        System.out.println(str1);

        String str2 = dtf.format(birthday);

        System.out.println(str2);

        Date sqlDate = new Date(System.currentTimeMillis());
        System.out.println(sqlDate);

        Time sqlTime = new Time(System.currentTimeMillis());
        System.out.println(sqlTime);

        Timestamp sqlTimestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(sqlTimestamp);


    }
}
