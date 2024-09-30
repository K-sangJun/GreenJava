package D20240930;

public class Date {

    // 윤년 체크 메서드
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // 날짜 유효성 체크 메서드
    public static void validateDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("존재하지 않는 월: " + month);
        }

        int daysInMonth;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                daysInMonth = 31;
                break;
            case 4: case 6: case 9: case 11:
                daysInMonth = 30;
                break;
            case 2:
                daysInMonth = isLeapYear(year) ? 29 : 28;
                break;
            default:
                throw new IllegalArgumentException("존재하지 않는 월: " + month);
        }

        if (day < 1 || day > daysInMonth) {
            throw new IllegalArgumentException("Invalid day: " + day);
        }
    }

    // 기본 날짜 포맷 메서드 (YYYY-MM-DD)
    public static String formatDate(int day, int month, int year) {
        validateDate(day, month, year); // 날짜 유효성 체크
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    // 원하는 형식으로 날짜 포맷
    public static String formatDate(int day, int month, int year, String format) {
        validateDate(day, month, year); // 날짜 유효성 체크
        return format.replace("YYYY", String.valueOf(year))
                .replace("MM", String.format("%02d", month))
                .replace("DD", String.format("%02d", day));
    }

}
