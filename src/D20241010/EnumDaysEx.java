package D20241010;

// enum Days(월화....)
// 스위치 케이스로 요일말하기

enum Days{
    MON,TUE,WED,THU,FRI,SAT,SUN;
}

public class EnumDaysEx {
    public static void main(String[] args) {

        Days day = Days.MON;
        switch (day) {
            case MON:
                System.out.println("월요일");
                break;
            case TUE:
                System.out.println("화요일");
                break;
            case WED:
                System.out.println("수요일");
                break;
            case THU:
                System.out.println("목요일");
                break;
            case FRI:
                System.out.println("금요일");
                break;
            case SAT:
                System.out.println("토요일");
                break;
            case SUN:
                System.out.println("일요일");
                break;
            default:
                System.out.println("존재하지 않는 요일입니다.");
                break;
        }

    }
}
