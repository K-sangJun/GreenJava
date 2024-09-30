package D20240930.Board.VIEW;

import D20240930.Board.DAO.CodeinfoDAO;
import D20240930.Board.DAO.UserDAO;
import D20240930.Board.DTO.CodeinfoDTO;
import D20240930.Board.DTO.UserDTO;
import D20240930.Board.VIEW.Admin.BoardAdminView;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginView {

    private static final String[] menuList = {"로그인", "회원가입"};
    private static final Scanner sc = new Scanner(System.in);

    private static final UserDAO UserDAO = new UserDAO();

    public void start() {

        boolean flag = true;
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
                chkLogin();
                break;
            case "1":
                register();
                break;

            default:
                result = false;
                break;
        }

        return result;
    }

    private void chkLogin(){

        String[] coulms = {"아이디", "비밀번호"};
        UserDTO userDTO = new UserDTO();
        for (int i = 0; i < coulms.length; i++) {
            String msg = "로그인 할 " + coulms[i] + "을(를) 입력하세요.";
            switch (i) {
                case 0:
                    userDTO.setId(ViewUtill.scan(msg));
                    break;
                case 1:
                    userDTO.setPw(ViewUtill.scan(msg));
                    break;
                default:
                    break;
            }
        }

        UserDTO usdto = UserDAO.chkLogin(userDTO);
        switch (usdto.getUserGbn()){
            case "10":
                System.out.println("사용자쪽");
                break;
            case "20":
                BoardAdminView boardAdminView = new BoardAdminView();
                boardAdminView.start(usdto);
                break;
            case null, default:
                ViewUtill.errMsg("존재하지 않는 아이디 이거나, 일치하지 않는 비밀번호 입니다.");
                break;
        }
    }

    private void register(){

        String[] coulms = {"아이디", "비밀번호", "권한", "이름"};
        UserDTO userDTO = new UserDTO();
        for (int i = 0; i < coulms.length; i++) {
            String msg = "회원가입 할 " + coulms[i] + "을(를) 입력하세요.";
            switch (i) {
                case 0:
                    userDTO.setId(ViewUtill.scan(msg));
                    break;
                case 1:
                    userDTO.setPw(ViewUtill.scan(msg));
                    break;
                case 2:
                    userDTO.setUserGbn(ViewUtill.setGbnCd("user_gbn"));
                    break;
                case 3:
                    userDTO.setName(ViewUtill.scan(msg));
                    break;
                default:
                    break;
            }
        }

        if(UserDAO.register(userDTO) == -1){
            ViewUtill.errMsg("회원가입에 실패 하였습니다.");
        }else{
            ViewUtill.sucMsg("회원가입 하였습니다.");
        }
    }





}
