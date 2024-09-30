package D20240925;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {

    private static final String URL = "jdbc:mariadb://localhost:3306/mydb"; // 데이터베이스 URL
    private static final String USER = "root"; // 사용자명
    private static final String PASSWORD = "1234"; // 비밀번호

    // 데이터베이스 연결 메서드
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
