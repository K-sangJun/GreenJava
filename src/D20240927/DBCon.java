package D20240927;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {

    private static final String URL = "jdbc:mariadb://localhost:3306/mydb"; // 데이터베이스 URL
    private static final String USER = "root"; // 사용자명
    private static final String PASSWORD = "1234"; // 비밀번호
    private static Connection conn = null;

    // 데이터베이스 연결 메서드
    public static Connection getConnection(){
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
//                conn.setAutoCommit(false);
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sqlEx(SQLException e) {
        switch (e.getErrorCode()) {
            case 1062: // 중복 키 오류
                System.out.println("중복 데이터가 발견되었습니다: " + e.getMessage());
                break;
            case 1452: // NOT NULL 제약 조건 위반
                System.out.println("NOT NULL 제약 조건 위반: " + e.getMessage());
                break;
            case 1048: // NULL 값이 허용되지 않는 경우
                System.out.println("컬럼이 NULL일 수 없습니다: " + e.getMessage());
                break;
            case 1064: // SQL 문법 오류
                System.out.println("SQL 문법 오류: " + e.getMessage());
                break;
            case 1216: // 외래 키 제약 조건 위반
                System.out.println("외래 키 제약 조건 위반: " + e.getMessage());
                break;
            case 1217: // 외래 키 제약 조건 위반 (삭제)
                System.out.println("삭제할 수 없는 외래 키 제약 조건 위반: " + e.getMessage());
                break;
            case 2003: // 데이터베이스 연결 실패
                System.out.println("데이터베이스 연결 실패: " + e.getMessage());
                break;
            case 1045: // 사용자 인증 실패
                System.out.println("사용자 인증 실패: " + e.getMessage());
                break;
            case 1054: // 알 수 없는 컬럼
                System.out.println("알 수 없는 컬럼: " + e.getMessage());
                break;
            // 추가적인 오류 코드 처리 가능
            default:
                System.out.println("SQL 오류가 발생했습니다: " + e.getMessage());
                break;
        }
    }

}
