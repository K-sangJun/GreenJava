package D20241007;

import java.util.Scanner;

public class MainObject {

    // 메인 메소드 (테스트용)
    public static void main(String[] args) {
        InfiniteArrayObject<Object> infArr = new InfiniteArrayObject();
        Scanner sc = new Scanner(System.in);
        int choice, index;
        Object value;

        while (true) {
            System.out.println("메뉴를 선택하세요:");
            System.out.println(" 1. 추가 (add)");
            System.out.println(" 2. 삭제 (remove)");
            System.out.println(" 3. 조회 (get)");
            System.out.println(" 4. 전체조회 (getAll)");
            System.out.println(" 5. 수정 (update)");
            System.out.println(" 6. 배열 출력 (print)");
            System.out.println(" 7. 종료 (exit)");
            System.out.print("선택: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // 추가
                    System.out.print("추가할 값을 입력하세요 (정수 또는 문자열): ");
                    if (sc.hasNextInt()) {
                        value = sc.nextInt();
                    } else {
                        value = sc.next();
                    }
                    infArr.add(value);
                    System.out.println(value + "가 배열에 추가되었습니다.");
                    break;

                case 2: // 삭제
                    System.out.print("삭제할 인덱스를 입력하세요: ");
                    index = sc.nextInt();
                    try {
                        infArr.remove(index);
                        System.out.println(index + "번째 인덱스가 삭제되었습니다.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("잘못된 인덱스입니다.");
                    }
                    break;

                case 3: // 조회
                    System.out.print("조회할 인덱스를 입력하세요: ");
                    index = sc.nextInt();
                    try {
                        System.out.println("인덱스 " + index + "의 값: " + infArr.get(index));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("잘못된 인덱스입니다.");
                    }
                    break;

                case 4: // 전체조회
                    Object[] arrays = infArr.getAll();
                    for (int i = 0; i < infArr.size(); i++) {
                        System.out.println("배열[" + i + "] = " + arrays[i]);
                    }
                    break;

                case 5: // 수정
                    System.out.print("수정할 인덱스를 입력하세요: ");
                    index = sc.nextInt();
                    System.out.print("새로운 값을 입력하세요 (정수 또는 문자열): ");
                    if (sc.hasNextInt()) {
                        value = sc.nextInt();
                    } else {
                        value = sc.next();
                    }
                    try {
                        infArr.set(index, value);
                        System.out.println("인덱스 " + index + "가 " + value + "(으)로 수정되었습니다.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("잘못된 인덱스입니다.");
                    }
                    break;

                case 6: // 배열 출력
                    System.out.println("현재 배열: ");
                    infArr.print();
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
