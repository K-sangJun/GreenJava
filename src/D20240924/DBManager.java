package D20240924;

import java.sql.*;

public class DBManager {

    private static final String DRIVERNAME = "org.mariadb.jdbc.Driver";
    private static final String URL = "jdbc:mariadb://localhost:3306/mydb";
    private static final String UID = "root";
    private static final String UPW = "1234";

    private Connection conn;

    public DBManager() {
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

        String qry = buildSelectQuery(table, columns, where);

        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(qry);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String buildSelectQuery(String table, String[] columns, String[] where) {
        StringBuilder qry = new StringBuilder("SELECT ");
        qry.append(String.join(", ", columns))
                .append(" FROM ")
                .append(table);

        if (where.length > 0) {
            qry.append(" WHERE ").append(String.join(" AND ", where));
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
