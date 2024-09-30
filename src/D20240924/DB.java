package D20240924;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
    public static void main(String[] args) throws SQLException {
        DBManager2 dm = new DBManager2();

//        String qry = "INSERT tbl_student(sname, score)VALUES('홍길동1', 90);";

//        DBMessage insert = dm.doInsert(qry);

        String[] column = {"schoolYear"};
        String[] where = {"1"};

        ResultSet rs = dm.doSelect("student", column, where);

        while (rs.next()) {
            System.out.println(rs.getString(2));
        }
    }
}
