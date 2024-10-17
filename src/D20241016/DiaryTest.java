package D20241016;

import java.util.ArrayList;

public class DiaryTest {
    public static void main(String[] args) {
        DiaryManager dm = new DiaryManager();
        Diary diary = new Diary("테스트입니다.2");
        dm.regist(diary);
//
//        ArrayList<String> files = dm.getList();
//        for (String file : files) {
//            System.out.println(file);
//        }

        String dairy = dm.get("20243016103055.txt");
        System.out.println(dairy);
    }
}
