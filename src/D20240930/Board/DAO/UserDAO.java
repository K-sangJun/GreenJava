package D20240930.Board.DAO;

import D20240930.Board.DBCon;
import D20240930.Board.DTO.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    Connection conn = DBCon.getConnection();

    public int register(UserDTO user) {

        try {
            String qry =    "INSERT INTO user" +
                    "(id, pw, user_gbn, name, inst_id, inst_dt, updt_id, updt_dt)" +
                    "VALUES (?, ?, ?, ?, 'REGISTER', NOW(), 'REGISTER', NOW())";
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPw());
            pstmt.setString(3, user.getUserGbn());
            pstmt.setString(4, user.getName());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            DBCon.sqlEx(e);
            throw new RuntimeException(e);
        }

    }

    public UserDTO chkLogin(UserDTO user) {

        UserDTO result = new UserDTO();

        try {
            String qry = "SELECT * FROM user WHERE id = ? AND pw = ?";
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPw());
            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                result.setId(rs.getString("id"));
                result.setPw(rs.getString("pw"));
                result.setUserGbn(rs.getString("user_gbn"));
                result.setName(rs.getString("name"));
                result.setInstId(rs.getString("inst_id"));
                result.setInstDt(rs.getTimestamp("inst_dt"));
                result.setUpdtId(rs.getString("updt_id"));
                result.setUpdtDt(rs.getTimestamp("updt_dt"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

}
