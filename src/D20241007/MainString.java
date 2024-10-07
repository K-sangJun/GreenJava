package D20241007;

import java.util.Scanner;

public class MainString {

    // 메인 메소드 (테스트용)
    public static void main(String[] args) {
        InfiniteArrayString infArrString = new InfiniteArrayString();
        Scanner sc = new Scanner(System.in);
        int choice, index;
        String value;

        while (true) {
            System.out.println("메뉴를 선택하세요:");
            System.out.print(" 1. 추가 (add)");
            System.out.print(" 2. 삭제 (remove)");
            System.out.print(" 3. 조회 (get)");
            System.out.print(" 4. 전체조회 (getAll)");
            System.out.print(" 5. 수정 (update)");
            System.out.print(" 6. 배열 출력 (print)");
            System.out.println(" 7. 종료 (exit)");
            System.out.print("선택: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // 추가
                    System.out.print("추가할 값을 입력하세요: ");
                    value = sc.next();
                    infArrString.add(value);
                    System.out.println(value + "가 배열에 추가되었습니다.");
                    break;
                case 2: // 삭제
                    System.out.print("삭제할 인덱스를 입력하세요: ");
                    index = sc.nextInt();
                    try {
                        infArrString.remove(index);
                        System.out.println(index + "번째 인덱스가 삭제되었습니다.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("잘못된 인덱스입니다.");
                    }
                    break;
                case 3: // 조회
                    System.out.print("조회할 인덱스를 입력하세요: ");
                    index = sc.nextInt();
                    try {
                        System.out.println("인덱스 " + index + "의 값: " + infArrString.get(index));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("잘못된 인덱스입니다.");
                    }
                    break;
                case 4: // 전체조회
                    try {
                        String[] arrays = infArrString.getAll();
                        for (int i = 0; i < arrays.length; i++) {
                            System.out.println("int[" + i + "]" + " = " + arrays[i]);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("잘못된 인덱스입니다.");
                    }
                    break;
                case 5: // 수정
                    System.out.print("수정할 인덱스를 입력하세요: ");
                    index = sc.nextInt();
                    System.out.print("새로운 값을 입력하세요: ");
                    value = sc.next();
                    try {
                        infArrString.set(index, value);
                        System.out.println("인덱스 " + index + "가 " + value + "(으)로 수정되었습니다.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("잘못된 인덱스입니다.");
                    }
                    break;
                case 6: // 배열 출력
                    System.out.println("현재 배열: ");
                    infArrString.print();
                    break;
                case 7: // 종료
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택하세요.");
            }
        }
    }
}