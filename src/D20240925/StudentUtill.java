package D20240925;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentUtill {

    private static final String[] COLUMS = {"이름", "학년", "반", "번호", "국어점수", "영어점수", "수학점수"};
    private static final Scanner sc = new Scanner(System.in);
    private static StudentDAO stuDAO = null;

    public StudentUtill(){
        stuDAO = new StudentDAO();
    }



    public String showMenu(){


        String[] menus = {"학생조회", "학생등록", "학생수정", "학생삭제"};
        String msg = "";

        for(int i = 0; i < menus.length; i++){
            msg = msg + (i) + ": " + menus[i] + ", ";
        }

        return scan(msg);
    }

    public void menuAct(String menu){

        switch(menu){
            case "0":
                selectStu();
                break;
            case "1":
                insertStu();
                break;


            default:

                break;
        }

    }

    public void insertStu(){

        Student std = new Student();
//        "이름", "학년", "반", "번호", "국어점수", "영어점수", "수학점수"
        for (int i = 0; i < COLUMS.length; i++){

            String value = scan(COLUMS[i] + "를 입력해 주세요");
            int intValue;

            switch (i){
                case 0:
                    std.setName(value);
                    break;
                case 1:
                    intValue = Integer.parseInt(value);
                    std.setSchoolYear(intValue);
                    break;
                case 2:
                    intValue = Integer.parseInt(value);
                    std.setClazz(intValue);
                    break;
                case 3:
                    intValue = Integer.parseInt(value);
                    std.setSno(intValue);
                    break;
                case 4:
                    intValue = Integer.parseInt(value);
                    std.setKorScore(intValue);
                    break;
                case 5:
                    intValue = Integer.parseInt(value);
                    std.setEngScore(intValue);
                    break;
                case 6:
                    intValue = Integer.parseInt(value);
                    std.setMathScore(intValue);
                    break;

                default:
                    break;

            }
        }

        int result = stuDAO.regist(std);
        if (result < 1){
            errMsg("저장에 실패하였습니다.");
        }else{
            sucMsg("저장되었습니다");
        }
    }

    public void selectStu(){
        int value = Integer.parseInt(scan("전체 조회시 -1, 아니면 번호를 입력해 주세요"));
        ArrayList<Student> students = stuDAO.select(value);

        System.out.println("----------------------------------------------------------------------------------------------------------");
        for (Student student : students){
            System.out.println(student.toString());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
    }

    private String scan(String msg){

        System.out.print(msg + " >> ");
        String text = sc.next();

        return text;
    }

    private void errMsg(String msg){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!" + msg + "!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    private void sucMsg(String msg){
        System.out.println("★★★★★★★★★★★★★★★★★★★" + msg + "★★★★★★★★★★★★★★★★★★★");
    }

}
