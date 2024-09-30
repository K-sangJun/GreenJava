package D20240927;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] menu = {"내용넣기", "사전사용", "저장된 내용 조회"};
        Map<String, String> dictionarys = new HashMap<String, String>();
        boolean flag = true;
        String title = "";
        for (int i = 0; i < menu.length; i++) {
            title += i + ": " + menu[i] + ",";
        }
        while (flag) {
            System.out.println(title);
            int menuNum = sc.nextInt();
            System.out.println("================================================================================================================");
            switch (menuNum) {
                case 0:
                    System.out.println("단어를 입력하세요");
                    String key = sc.next();
                    System.out.println("뜻을 입력하세요");
                    String value = sc.next();
                    dictionarys.put(key, value);
                    break;
                case 1:
                    System.out.println("검색할 단어를 입력하세요");
                    String key2 = sc.next();
                    System.out.println(dictionarys.get(key2));
                    break;
                case 2:
                    for (Map.Entry<String, String> entry : dictionarys.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;
                default:
                    flag = false;
                    break;
            }
            System.out.println("================================================================================================================");
        }

    }

}
