package D20240925;

import java.sql.SQLException;

public class QuizMain {

    public static void main(String[] args) throws SQLException {

        QuizUtill quiz = new QuizUtill();


        while (true){
            String menu = quiz.showMenu();
            quiz.menuAct(menu);
        }

    }

}
