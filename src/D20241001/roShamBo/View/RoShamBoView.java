package D20241001.roShamBo.View;

import D20241001.roShamBo.DAO.HistoryDAO;
import D20241001.roShamBo.DTO.HistoryDTO;
import D20241001.roShamBo.DTO.RoShamBoResult;
import D20241001.roShamBo.DTO.UserDTO;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RoShamBoView {

    private static final String[] menuList = {"가위바위보 시작", "통계조회", "전체이력조회"};
    private static final String[] roshambos = {"가위", "바위", "보"};
    private static final String[] result = {"승리", "패배", "무승부"};
    private static final int[] point = {10, -10, 0};
    private static final Random rand = new Random();
    private static final Scanner sc = new Scanner(System.in);
    private static UserDTO loginInfo = new UserDTO();
    private static HistoryDAO historyDAO = new HistoryDAO();

    public void start(UserDTO user) {

        boolean flag = true;
        loginInfo = user;
        
        while (flag) {
            String menuChoice = getMenuNum();
            flag = menuAct(menuChoice);
        }
    }

    private String getMenuNum() {
        String text = ViewUtill.makeString(menuList);

        return ViewUtill.scan(text);
    }

    private boolean menuAct(String menuChoice) {

        boolean result = true;
        if (Integer.parseInt(menuChoice) < menuList.length) ViewUtill.titleMsg(menuList[Integer.parseInt(menuChoice)]);


        switch (menuChoice) {
            case "0":
                doRoShamBo();
                break;
            case "1":
                showResult();
                break;
            case "2":
                showAllResult();
                break;
            default:
                result = false;
                break;
        }

        return result;
    }

    private void showAllResult() {

        HistoryDTO dto = new HistoryDTO();
        dto.setId(loginInfo.getId());

        ArrayList<HistoryDTO> results = historyDAO.selectAllHistory(dto);

        for (HistoryDTO res : results) {
            System.out.print("이름: " + loginInfo.getName() + ",\t");
            System.out.print("가위바위보: " + roshambos[res.getRoshambo()] + ",\t");
            System.out.print("결과: " + result[res.getResult()] + "\t");
            System.out.println("");
        }
        showResult();
    }

    private void showResult() {

        HistoryDTO dto = new HistoryDTO();
        dto.setId(loginInfo.getId());

        RoShamBoResult roShamBoResult = historyDAO.selectHistory(dto);
        System.out.println(roShamBoResult.toString());
    }

    private void doRoShamBo(){

        int user = userRoShamBo();
        int computer = randRoshambo();

        int roShamBoResult = resultRoshambo(user, computer);

        ViewUtill.sucMsg(result[roShamBoResult] + " 하였습니다.");
        HistoryDTO dto = new HistoryDTO();
        dto.setId(loginInfo.getId());
        dto.setResult(roShamBoResult);
        dto.setRoshambo(user);
        dto.setPoint(point[roShamBoResult]);

        historyDAO.insertHistory(dto);

    }

    private int userRoShamBo() {
        String text = ViewUtill.makeString(roshambos);

        while (true){
            int cnt = Integer.parseInt(ViewUtill.scan(text));
            if (cnt == 0 || cnt == 1 || cnt == 2)
                return cnt;{
            }
        }
    }

    private int randRoshambo(){
        return rand.nextInt(roshambos.length);
    }

    private int resultRoshambo(int user, int computer){
        int result;

        if (user == computer) {
            result = 2;
        }else{
            result = user % 3 == computer ? 1 : 0;
        }
        return result;
    }

}
