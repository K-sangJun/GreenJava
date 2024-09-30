package D20240925;

import java.sql.SQLException;

public class StudentMain {

    public static void main(String[] args) throws SQLException {

        StudentUtill stu = new StudentUtill();


        while (true){
            String menu = stu.showMenu();
            stu.menuAct(menu);
        }

    }

}
