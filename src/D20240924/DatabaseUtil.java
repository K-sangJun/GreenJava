package D20240924;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseUtil {

    // SQL 쿼리 실행 메서드
    private static int executeUpdate(String sql, Object... params) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            setParameters(pstmt, params);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // SQL 쿼리 선택 메서드
    private static ResultSet executeQuery(String sql, Object... params) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            setParameters(pstmt, params);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // PreparedStatement에 파라미터 설정
    private static void setParameters(PreparedStatement pstmt, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pstmt.setObject(i + 1, params[i]);
        }
    }

    // 데이터 삽입 메서드
    public static void insertData(String table, Map<String, Object> data) {
        StringBuilder sql = new StringBuilder("INSERT INTO " + table + " (");
        StringBuilder placeholders = new StringBuilder(" VALUES (");

        data.keySet().forEach(column -> {
            sql.append(column).append(", ");
            placeholders.append("?, ");
        });

        sql.setLength(sql.length() - 2); // 마지막 ", " 제거
        placeholders.setLength(placeholders.length() - 2); // 마지막 ", " 제거
        sql.append(")").append(placeholders).append(")");

        executeUpdate(sql.toString(), data.values().toArray());
    }

    // 데이터 삭제 메서드
    public static void deleteData(String table, Map<String, Object> conditions) {
        StringBuilder sql = new StringBuilder("DELETE FROM " + table + " WHERE 1=1");

        conditions.forEach((column, value) -> {
            sql.append(" AND ").append(column).append(" = ?");
        });

        executeUpdate(sql.toString(), conditions.values().toArray());
    }

    // 데이터 업데이트 메서드
    public static void updateData(String table, Map<String, Object> data, Map<String, Object> conditions) {
        StringBuilder sql = new StringBuilder("UPDATE " + table + " SET");

        data.forEach((column, value) -> {
            sql.append(" ").append(column).append(" = ?,");
        });

        sql.setLength(sql.length() - 1); // 마지막 "," 제거
        sql.append(" WHERE 1=1");

        conditions.forEach((column, value) -> {
            sql.append(" AND ").append(column).append(" = ?");
        });

        Object[] params = new Object[data.size() + conditions.size()];
        int index = 0;
        for (Object value : data.values()) {
            params[index++] = value;
        }
        for (Object value : conditions.values()) {
            params[index++] = value;
        }

        executeUpdate(sql.toString(), params);
    }

    // 데이터 선택 메서드
    public static void selectData(String table, Map<String, Object> conditions) {
        StringBuilder sql = new StringBuilder("SELECT * FROM " + table + " WHERE 1=1");

        if (conditions != null) {
            conditions.forEach((column, value) -> {
                sql.append(" AND ").append(column).append(" = ?");
            });
        }

        try (ResultSet rs = executeQuery(sql.toString(), conditions != null ? conditions.values().toArray() : new Object[0])) {
            if (rs != null) {
                while (rs.next()) {
                    StringBuilder result = new StringBuilder("Row: ");
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        result.append(rs.getMetaData().getColumnName(i)).append(": ").append(rs.getObject(i)).append(", ");
                    }
                    System.out.println(result.toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
