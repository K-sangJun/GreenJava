package D20240924;

import java.sql.*;

public class DBManager2 {

    private static final String DRIVERNAME = "org.mariadb.jdbc.Driver";
    private static final String URL = "jdbc:mariadb://localhost:3306/mydb";
    private static final String UID = "root";
    private static final String UPW = "1234";

    private Connection conn;

    public DBManager2() {
        try {
            Class.forName(DRIVERNAME);
            conn = DriverManager.getConnection(URL, UID, UPW);
            if (conn != null) {
                System.out.println("데이터베이스 연결 되었습니다.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public DBMessage doUpdate(String qry) {
        return executeStatement(qry);
    }

    public DBMessage doInsert(String qry) {
        return executeStatement(qry);
    }

    public DBMessage doDelete(String qry) {
        return executeStatement(qry);
    }

    private DBMessage executeStatement(String qry) {
        DBMessage dbMessage = new DBMessage();
        try (Statement stmt = conn.createStatement()) {
            int result = stmt.executeUpdate(qry);
            dbMessage.result = result > 0;
        } catch (SQLException e) {
            dbMessage.result = false;
            dbMessage.message = e.getMessage();
        }
        return dbMessage;
    }

    public ResultSet doSelect(String table, String[] columns, String[] where) {

        String qry = buildSelectQuery(table, columns);
        System.out.println(qry);

        try {
            PreparedStatement pstmt = conn.prepareStatement(qry);
            for (int i = 0; i < where.length; i++) {
                pstmt.setString(i + 1, where[i]);
            }
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String buildSelectQuery(String table, String[] columns) {
        StringBuilder qry = new StringBuilder("SELECT *");
        qry.append(" FROM ")
                .append(table);

        for (int i = 0; i < columns.length; i++) {
            String key = i == 0 ? " WHERE " : " AND ";
            qry.append(key)
                    .append(columns[i])
                    .append(" = ?");
        }

        return qry.toString();
    }

    // Close the connection when done
    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
