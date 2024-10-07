package D20241002;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionEx {
    public static void main(String[] args) {

        Connection conn = DBCon.getConnection();

        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {

            conn.setAutoCommit(false);

            String sql1 = "UPDATE accounts SEt balance = balance - ? WHERE account_id = ?";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setDouble(1, 500);
            pstmt1.setInt(2, 12345);
            int n = pstmt1.executeUpdate();

            if (n == 1) {
                throw new SQLException();
            }

            String sql2 = "UPDATE accounts SEt balance = balance + ? WHERE account_id = ?";
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setDouble(1, 500);
            pstmt2.setInt(2, 67890);
            pstmt2.executeUpdate();

            conn.commit();
            System.out.println("트랜잭션 마무~~~~리~~");

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("롤백 했다잉~~~~~");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt1 != null) pstmt1.close();
                if (pstmt2 != null) pstmt2.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
