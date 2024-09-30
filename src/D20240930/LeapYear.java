package D20240930;

import java.util.Scanner;

public class LeapYear {

//    4로 나누어 떨어짐
//    100으로 나누어 떨어지면 아님
//    400으로 나누어 떨어진다.

    public static void main(String[] args) {

        System.out.println("년도를 입력하세요");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        boolean result = isLeap(year);
        System.out.println(result ? "윤년 입니다." : "윤년이 아닙니다.");

    }

    public static boolean isLeap(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }
}
