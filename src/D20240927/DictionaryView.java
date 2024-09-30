package D20240927;

import D20240926.Result;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class DictionaryView {

    private static final String[] menuList = {"단어조회", "단어추가", "시험치기", "시험결과"};
    private static final Scanner sc = new Scanner(System.in);
    private static final DictionaryDAO dicDAO = new DictionaryDAO();

    public void start() {

        boolean flag = true;
        while (flag) {
            String menuChoice = getMenuNum();
            flag = menuAct(menuChoice);
        }
    }

    private String getMenuNum() {
        String text = makeString(menuList);

        return scan(text);
    }

    private boolean menuAct(String menuChoice) {

        boolean result = true;
        if (Integer.parseInt(menuChoice) < menuList.length) {
            titleMsg(menuList[Integer.parseInt(menuChoice)]);
        }

        switch (menuChoice) {
            case "0":
                select();
                break;
            case "1":
                insert();
                break;
            case "2":
                exam();
                break;
            case "3":
                history();
                break;
            default:
                result = false;
                break;
        }

        return result;
    }

    private void history(){
        String name = scan("검색할 이름을 입력해 주세요");
        show(dicDAO.exam_history(name, ""));
    }

    private void select(){
        DictionaryDTO dicDTO = setDictionary();
        ArrayList<DictionaryDTO> dicList = dicDAO.select(dicDTO);

        for (DictionaryDTO dic: dicList) {
            System.out.println(dic.toString());
        }
    }

    private void insert(){
        DictionaryDTO dic = setDictionary();
        dicDAO.insert(dic);
    }

    private void exam(){
        int cnt = Integer.parseInt(scan("시험칠 문제의 수를 입력하세요"));
        if (cnt > 0) {
            String name = scan("이름을 입력하세요");
            Date now = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dtm = formatter.format(now);

            ArrayList<DictionaryDTO> dicList = dicDAO.exam_select(cnt);
            for (DictionaryDTO dic : dicList) {
                String word = dic.getWord();
                String mean = dic.getMean();

                System.out.print(word + ": ");
                String value = sc.next();
                String rightYN = mean.equals(value) ? "Y" : "N";

                System.out.print((rightYN.equals("Y") ? " 정답입니다." : " 틀렸습니다.") + "\n");

                dicDAO.exam_insert(dtm, name, word, rightYN);
            }

            show(dicDAO.exam_history(name, dtm));
        }else{
            errMsg("문제수량은 0보다 커야합니다.");
        }
    }

    private void show(ArrayList<Map<String, String>> result){
        DecimalFormat df = new DecimalFormat("#.##");
        for (Map<String, String> map: result) {
            int total = Integer.parseInt(map.get("total"));
            int lose = Integer.parseInt(map.get("lose"));
            String name = map.get("name");
            int win = total - lose;
            float percentage = (float) win / total * 100;

            System.out.println("이름: " + name + ", 문제수: " + total + ", 승: " + win + ", 패: " + lose + " (" + df.format(percentage) + "%)");
        }
    }

    private DictionaryDTO setDictionary(){

        String[] columns = {"단어", "뜻"};
        DictionaryDTO dicDto = new DictionaryDTO();

        for (int i = 0; i < columns.length; i++) {
            String value = scan(columns[i] + "을(를) 입력해 주세요");

            switch (i){
                case 0:
                    dicDto.setWord(value);
                    break;
                case 1:
                    dicDto.setMean(value);
                    break;
                default:
                    i--;
                    break;
            }
        }

        return dicDto;
    }

    private String makeString(String[] type) {
        String text = "";
        for (int i = 0; i < type.length; i++) {
            text += (i + ": " + type[i] + " ");
        }
        return text;
    }

    private String scan(String msg) {
        String text = "";
        try {
            System.out.print(msg + " >> ");
            text = sc.nextLine();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return text;
    }

    private void errMsg(String msg) { System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! " + msg + " !!!!!!!!!!!!!!!!!!!!!!!!!!!"); }
    private void sucMsg(String msg) { System.out.println("★★★★★★★★★★★★★★★★★★★ " + msg + " ★★★★★★★★★★★★★★★★★★★"); }
    private void titleMsg(String msg) { System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " + msg + " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"); }
}


//공지사항을 제시하는 게시판이 필요
//공지사항은 담당자들만 올릴 수 있음
//        공지사항은 제목, 내용, 작성자로 구성
//담당자는 여러 공지사항을 올릴 수 있음
//사용자들은 공지사항을 보고 댓글달 수 있음
//댓글은 간단한 메시지만 작성가능, 제목 필요없음, 짧은 문장의 코멘트
//하나의 공지사항에는 여러명이 댓글을 달 수 있음
//공지사항 제목에는 해당 게시글에 몇개의 댓글이 있는지
// 알수있음담당자들은 각자 자신이 올린 게시글을 수정 또는 삭제가능