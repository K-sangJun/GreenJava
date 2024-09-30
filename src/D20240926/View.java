package D20240926;

import java.util.Scanner;

public class View {

    private static final String[] menuList = {"추가 (학생, 동아리)", "가입(동아리)", "조회(학생, 동아리)"};
    private static final Scanner sc = new Scanner(System.in);
    private static final StudentDAO stdDAO = new StudentDAO();

    public void start() {
        String menuChoice = getMenuNum();

        menuAct(menuChoice);

    }

    private String getMenuNum() {
        String text = makeString(menuList);

        return scan(text);
    }

    private void menuAct(String menuChoice) {

        switch (menuChoice) {
            case "0":
                insert();
                break;

            default:
                break;
        }


    }

    private void insert(){
        String type = insertType();
        Result rs = new Result();

        switch (type){
            case "0":
                StudentDTO stdDTO = setStudent();
                rs = stdDAO.insertStudent(stdDTO);
                break;
            case "1":
                System.out.println("동아리");
                break;
            default:
                break;
        }

        if (rs.getResult() == -1) errMsg(rs.getMessage());
        else sucMsg(rs.getMessage());

    }

    private StudentDTO setStudent(){

        String[] columns = {"이름", "지역"};
        StudentDTO stdDto = new StudentDTO();

        for (int i = 0; i < columns.length; i++) {
            String value = scan(columns[i] + "을(를) 입력해 주세요");

            switch (i){
                case 0:
                    stdDto.setStdName(value);
                    break;
                case 1:
                    stdDto.setAddr(value);
                    break;
                default:
                    break;
            }
        }


        return stdDto;

    }

    private String insertType(){
        String[] type = {"학생", "동아리"};
        String text = makeString(type);

        return scan(text);
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
}
