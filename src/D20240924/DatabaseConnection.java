package D20240924;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DRIVERNAME = "org.mariadb.jdbc.Driver";
    private static final String URL = "jdbc:mariadb://localhost:3306/mydb";
    private static final String UID = "root";
    private static final String UPW = "1234";

    // 데이터베이스 연결 메서드
    public static Connection getConnection() throws SQLException {

        Connection conn = null;

        try {
            Class.forName(DRIVERNAME);
            conn = DriverManager.getConnection(URL, UID, UPW);
            if (conn != null) {
                System.out.println("데이터베이스 연결 되었습니다.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
