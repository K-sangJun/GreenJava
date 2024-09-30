package D20240930.Board.DAO;

import D20240930.Board.DBCon;
import D20240930.Board.DTO.BoardDTO;
import D20240930.Board.DTO.CommentDTO;
import D20240930.Board.DTO.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
    Connection conn = DBCon.getConnection();

    public int insertBoard(BoardDTO board) {

        try {
            String qry =    "INSERT INTO board" +
                            "(b_gbn, title, detail, inst_id, inst_dt, updt_id, updt_dt)" +
                            "VALUES (?, ?, ?, ?, NOW(), ?, NOW())";
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, board.getBGbn());
            pstmt.setString(2, board.getTitle());
            pstmt.setString(3, board.getDetail());
            pstmt.setString(4, board.getInstId());
            pstmt.setString(5, board.getUpdtId());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            DBCon.sqlEx(e);
            throw new RuntimeException(e);
        }

    }

    public ArrayList<BoardDTO> selectAllBoard() {

        ArrayList<BoardDTO> boards = new ArrayList<>();

        try {
            String qry =    "SELECT a.*, b.cd_nm AS b_gbn_nm " +
                            "FROM board a " +
                            "LEFT JOIN codeinfo b ON a.b_gbn = b.cd AND b.up_cd = 'b_gbn' " +
                            "WHERE a.b_gbn = '10'";

            PreparedStatement pstmt = conn.prepareStatement(qry);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardDTO board = new BoardDTO();
                board.setBNo(rs.getInt("b_no"));
                board.setBGbn(rs.getString("b_gbn"));
                board.setbGbn_nm(rs.getString("b_gbn_nm"));
                board.setTitle(rs.getString("title"));
                board.setDetail(rs.getString("detail"));
                board.setInstId(rs.getString("inst_id"));
                board.setInstDt(rs.getTimestamp("inst_dt"));
                board.setUpdtId(rs.getString("updt_id"));
                board.setUpdtDt(rs.getTimestamp("updt_dt"));
                boards.add(board);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return boards;
    }

    public BoardDTO readBoard(int bNo) {

        BoardDTO board = new BoardDTO();

        try {
            String qry =    "SELECT a.*, b.cd_nm AS b_gbn_nm " +
                            "FROM board a " +
                            "LEFT JOIN codeinfo b ON a.b_gbn = b.cd AND b.up_cd = 'b_gbn' " +
                            "WHERE a.b_gbn = '10'" +
                            "AND a.b_no = ?";
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setInt(1, bNo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                board.setBNo(rs.getInt("b_no"));
                board.setBGbn(rs.getString("b_gbn"));
                board.setbGbn_nm(rs.getString("b_gbn_nm"));
                board.setTitle(rs.getString("title"));
                board.setDetail(rs.getString("detail"));
                board.setInstId(rs.getString("inst_id"));
                board.setInstDt(rs.getTimestamp("inst_dt"));
                board.setUpdtId(rs.getString("updt_id"));
                board.setUpdtDt(rs.getTimestamp("updt_dt"));
            }

            ArrayList<CommentDTO> commentDTOS = new ArrayList<>();
            String qry2 =   "SELECT *" +
                            "FROM `comment` a " +
                            "WHERE a.b_no = ? ";
            pstmt = conn.prepareStatement(qry2);
            pstmt.setInt(1, bNo);
            ResultSet rs2 = pstmt.executeQuery();
            while (rs2.next()) {
                CommentDTO commentDTO = new CommentDTO();
                commentDTO.setBNo(rs2.getInt("b_no"));
                commentDTO.setCNo(rs2.getInt("c_no"));
                commentDTO.setCDetail(rs2.getString("c_detail"));
                commentDTO.setDelYn(rs2.getString("del_yn"));
                commentDTO.setInstId(rs2.getString("inst_id"));
                commentDTO.setInstDt(rs2.getTimestamp("inst_dt"));
                commentDTO.setUpdtId(rs2.getString("updt_id"));
                commentDTO.setUpdtDt(rs2.getTimestamp("updt_dt"));
                commentDTOS.add(commentDTO);
            }
            board.setComments(commentDTOS);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return board;
    }

    public int updateBoard(BoardDTO board) {

        try {
            String qry =    "UPDATE board" +
                            "SET b_gbn = ?," +
                            "    title = ?," +
                            "    detail = ?," +
                            "    updt_id = ?," +
                            "    updt_dt = NOW()" +
                            "WHERE b_no = ?";
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, board.getBGbn());
            pstmt.setString(2, board.getTitle());
            pstmt.setString(3, board.getDetail());
            pstmt.setString(4, board.getUpdtId());
            pstmt.setInt(5, board.getBNo());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            DBCon.sqlEx(e);
            throw new RuntimeException(e);
        }

    }

    public int deleteBoard(BoardDTO board) {

        try {
            String qry =    "DELETE FROM board" +
                            "WHERE b_no = ?";
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setInt(1, board.getBNo());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            DBCon.sqlEx(e);
            throw new RuntimeException(e);
        }

    }


}
