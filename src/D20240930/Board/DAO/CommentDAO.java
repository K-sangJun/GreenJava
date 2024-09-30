package D20240930.Board.DAO;

import D20240930.Board.DBCon;
import D20240930.Board.DTO.BoardDTO;
import D20240930.Board.DTO.CommentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentDAO {
    Connection conn = DBCon.getConnection();

    public int insertComment(CommentDTO comment) {

        try {
            String qry =    "INSERT INTO `comment`" +
                            "(b_no, c_detail, del_yn, inst_id, inst_dt, updt_id, updt_dt)" +
                            "VALUES (?, ?, 'N', ?, NOW(), ?, NOW())";
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setInt(1, comment.getBNo());
            pstmt.setString(2, comment.getCDetail());
            pstmt.setString(3, comment.getInstId());
            pstmt.setString(4, comment.getUpdtId());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            DBCon.sqlEx(e);
            throw new RuntimeException(e);
        }

    }
}
