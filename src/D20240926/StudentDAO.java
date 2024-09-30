package D20240926;

import D20240925.Student;

import java.sql.*;

public class StudentDAO {

    Connection conn;

    public StudentDAO() {
        conn = DBCon.getConnection();
    }

    public Result insertStudent(StudentDTO student) {

        CallableStatement cstmt = null;
        ResultSet rs = null;
        Result result = new Result();

        try {
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            String qry = "CALL usp_stdtbl_i1(?, ?, ?, ?)";
            cstmt = conn.prepareCall(qry);
            cstmt.setString(1, student.getStdName());
            cstmt.setString(2, student.getAddr());

            // 출력 매개변수 등록
            cstmt.registerOutParameter(3, java.sql.Types.INTEGER);
            cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);

            // 프로시저 실행
            cstmt.execute();  // execute()로 프로시저 실행

            // 출력 매개변수 값 가져오기
            result.setResult(cstmt.getInt(3));
            result.setMessage(cstmt.getString(4));

            // 결과 처리
//            System.out.println("Result Code: " + outResult);
//            System.out.println("Message: " + outMessage);

            // 조회 결과가 있을 경우 ResultSet을 얻기 위해 새로 실행
            rs = cstmt.getMoreResults() ? cstmt.getResultSet() : null;

            // ResultSet 처리
            if (rs != null) {
                while (rs.next()) {
//                    System.out.println(rs.getString(1));
//                    System.out.println(rs.getString(2));
                }
            }

            if (result.getResult() == -1) {
                conn.rollback();
            }else{
                conn.commit();
            }

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
                throw new RuntimeException(e2);
            }
            throw new RuntimeException(e);
        }


        return result;
    }
}
