package D20240927;

import java.util.*;

public class MapTest {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

//        자료 입력하기
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        System.out.println(map);
        System.out.println(map.containsKey(2));

//        자료 얻기
        String data = map.get(1);
        System.out.println(data);

//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        System.out.println(map.containsKey(num) ? map.get(num) : "없다");
//        System.out.println(map.getOrDefault(num, "없다"));

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("사과", 3);
        map2.put("귤", 2);
        map2.put("바나나", 4);
        map2.put("바나나", 5);
        System.out.println(map2);
        System.out.println("삭제 전: " + map2);
        map2.remove("귤");
        System.out.println("삭제 후: " + map2);

        int result = map2.replace("사과", 100);
        System.out.println("변경 전값 : " + result);
        System.out.println("변경 후: " + map2);
        System.out.println(map2.get("사과"));

        Set<String> keys = map2.keySet();
        for (String key : keys) {
            System.out.println(key + ": " + map2.get(key));
        }

        for (int i = 0; i < keys.size(); i++) {
            System.out.println(map2.get(keys.toArray()[i]));
        }

        Set<Map.Entry<String, Integer>> enteySet = map2.entrySet();
        System.out.println(enteySet);

        Iterator<Map.Entry<String, Integer>> it = enteySet.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

//        학생 이름과 성적을 입력받는다.
//        칠수 : 90
//        팔수 : 80
//        구수 : 70

        System.out.println("===========================================================================================");
        int i = 0;
        Map<String, Integer> score = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (i < 3) {
            System.out.println("이름을 입력하세요");
            String name = sc.next();
            System.out.println("성적을 입력하세요");
            int age = sc.nextInt();

            score.put(name, age);
            i++;
        }

        System.out.println("팔수의 성적은" + score.get("팔수") + "점 입니다.");

        System.out.println("수정할 칠수의 성적을 입력하세요");
        int editInt = sc.nextInt();
        int orisocre = score.replace("칠수", editInt);
        System.out.println("칠수의 성적을 " + orisocre + "점에서 " + editInt + "점으로 수정했습니다.");

        for (Map.Entry<String, Integer> entry : score.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
