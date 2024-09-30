package D20240925;

import D20240924.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {

    //함수 저장, 삭제, 수정 등..
//    DatabaseConnection DB = new DatabaseConnection();
    Connection conn;

    public StudentDAO() {
        try {
            conn = DBCon.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int regist(Student student) { // 저장
        int result = -1;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String qry = "INSERT INTO student(name, schoolYear, class, sno, korScore, engScore, mathScore)" +
                "VALUES(?, ?, ?, ?, ?, ?, ?);";

        try {
            pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getSchoolYear());
            pstmt.setInt(3, student.getClazz());
            pstmt.setInt(4, student.getSno());
            pstmt.setInt(5, student.getKorScore());
            pstmt.setInt(6, student.getEngScore());
            pstmt.setInt(7, student.getMathScore());

            result = pstmt.executeUpdate();
        } catch (Exception e) {
            result = -1;
        }

        return result;
    }

    public ArrayList<Student> select(int no) { // 저장

        ArrayList<Student> students = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String qry = "SELECT * FROM student";
        qry = no > -1 ? qry + " WHERE no = ?" : qry;

        try {
            pstmt = conn.prepareStatement(qry);
            if (no > -1) {
                pstmt.setInt(1, no);
            }

            rs = pstmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setNo(rs.getInt("no"));
                student.setName(rs.getString("name"));
                student.setSchoolYear(rs.getInt("schoolYear"));
                student.setClazz(rs.getInt("class"));
                student.setSno(rs.getInt("sno"));
                student.setKorScore(rs.getInt("korScore"));
                student.setEngScore(rs.getInt("engScore"));
                student.setMathScore(rs.getInt("mathScore"));

                students.add(student);
            }
        } catch (Exception e) {
            return students;
        }

        return students;
    }


}
