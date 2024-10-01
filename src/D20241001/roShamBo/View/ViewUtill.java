package D20241001.roShamBo.View;

import D20240930.Board.DAO.CodeinfoDAO;
import D20240930.Board.DTO.CodeinfoDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewUtill {

    public static Scanner sc = new Scanner(System.in);

    public static String makeString(String[] type) {
        String text = "";
        for (int i = 0; i < type.length; i++) {
            text += (i + ": " + type[i] + " ");
        }
        return text;
    }

    public static String scan(String msg) {
        String text = "";
        try {
            System.out.print(msg + " >> ");
            text = sc.nextLine();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return text;
    }

    public static ArrayList<CodeinfoDTO> codeinfoList(){
        ArrayList<CodeinfoDTO> list = new ArrayList<>();


        return list;
    }

    public static String setGbnCd(String up_cd) {
        CodeinfoDAO codeinfoDAO = new CodeinfoDAO();
        ArrayList<CodeinfoDTO> gbnList = codeinfoDAO.codeinfos(up_cd);

        if (gbnList.size() > 0) {
            ArrayList<String> cdList = new ArrayList<>();

            System.out.println("코드를 입력해 주세요");

            for (CodeinfoDTO gbn : gbnList) {
                System.out.println(gbn.toString());
                cdList.add(gbn.getCd());
            }

            while (true) {
                String value = ViewUtill.sc.nextLine();
                if (cdList.contains(value)) {
                    return value;
                } else {
                    System.out.println("유효하지 않은 코드입니다. 다시 입력해 주세요.");
                }
            }
        } else {
            return "코드가 존재하지 않습니다.";
        }
    }

    public static void errMsg(String msg) { System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! " + msg + " !!!!!!!!!!!!!!!!!!!!!!!!!!!"); }
    public static void sucMsg(String msg) { System.out.println("★★★★★★★★★★★★★★★★★★★ " + msg + " ★★★★★★★★★★★★★★★★★★★"); }
    public static void titleMsg(String msg) { System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " + msg + " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"); }


}
