package D20241016;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Diary {

    private LocalDateTime today;
    private String comment;

    public Diary(String comment) {
        this.today = LocalDateTime.now();
        this.comment = comment;
    }

    public LocalDateTime getToday() {
        return today;
    }

    public String getFileName() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String date = dtf.format(today);
        return date;
    }

    public void setToday(LocalDateTime today) {
        this.today = today;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
        String date = dtf.format(today);
        System.out.println(date + "\n\n" + comment);
        return date + "\n\n" + comment;
    }
}
