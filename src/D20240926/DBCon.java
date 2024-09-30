package D20240926;

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
                conn.setAutoCommit(false);
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
