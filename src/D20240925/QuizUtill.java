package D20240925;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizUtill {

    private static final String[] COLUMS = {"문제", "정답"};
    private static final Scanner sc = new Scanner(System.in);
    private static QuizDAO quizDAO = null;

    public QuizUtill(){
        quizDAO = new QuizDAO();
    }

    public String showMenu(){

        String[] menus = {"문제조회", "문제등록", "문제풀기", "이력조회"};
        String msg = "";

        for(int i = 0; i < menus.length; i++){
            msg = msg + (i) + ": " + menus[i] + ", ";
        }

        return scan(msg);
    }

    public void menuAct(String menu){

        switch(menu){
            case "0":
                selectQuiz();
                break;
            case "1":
                insertQuiz();
                break;


            default:

                break;
        }

    }

    public void insertQuiz(){
//        "문제", "정답"

        Quiz quiz = new Quiz();

        for (int i = 0; i < COLUMS.length; i++){

            String value = scan(COLUMS[i] + "를 입력해 주세요");

            switch (i){
                case 0:
                    quiz.setQuestion(value);
                    break;
                case 1:
                    quiz.setAnswer(value);
                    break;
                default:
                    break;

            }
        }

        int result = quizDAO.insertQuiz(quiz);
        if (result < 1){
            errMsg("저장에 실패하였습니다.");
        }else{
            sucMsg("저장되었습니다");
        }
    }

    public void selectQuiz(){

        ArrayList<Quiz> quizs = quizDAO.selectQuiz();

        System.out.println("----------------------------------------------------------------------------------------------------------");
        for (Quiz quiz : quizs){
            System.out.println(quiz.toString());
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
