package D20240930;

import java.util.Scanner;

import static D20240930.Date.formatDate;
import static D20240930.Date.isLeapYear;

public class DateMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("일을 입력하세요: ");
        int day = scanner.nextInt();

        System.out.print("월을 입력하세요: ");
        int month = scanner.nextInt();

        System.out.print("년도를 입력하세요: ");
        int year = scanner.nextInt();

        try {
            boolean isLeap = isLeapYear(year);
            String defaultFormattedDate = formatDate(day, month, year);
            String customFormattedDate = formatDate(day, month, year, "DD/MM/YYYY");

            System.out.println("윤년 여부: " + (isLeap ? "윤년입니다." : "윤년이 아닙니다."));
            System.out.println("기본 포맷 날짜: " + defaultFormattedDate);
            System.out.println("커스텀 포맷 날짜: " + customFormattedDate);
        } catch (IllegalArgumentException e) {
            System.err.println("오류: " + e.getMessage());
        }
    }
}
