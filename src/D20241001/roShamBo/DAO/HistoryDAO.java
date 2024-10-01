package D20241001.roShamBo.DAO;

import D20241001.roShamBo.DBCon;
import D20241001.roShamBo.DTO.HistoryDTO;
import D20241001.roShamBo.DTO.RoShamBoResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HistoryDAO {

    Connection conn = DBCon.getConnection();

    public int insertHistory(HistoryDTO historyDTO) {

        try {
            String qry = """
                        INSERT INTO history(
                            id, 
                            result, 
                            roshambo, 
                            `point`
                        )VALUES (
                            ?, 
                            ?, 
                            ?, 
                            ?
                        );
                    """;

            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, historyDTO.getId());
            pstmt.setInt(2, historyDTO.getResult());
            pstmt.setInt(3, historyDTO.getRoshambo());
            pstmt.setInt(4, historyDTO.getPoint());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            DBCon.sqlEx(e);
            throw new RuntimeException(e);
        }

    }

    public RoShamBoResult selectHistory(HistoryDTO historyDTO) {

        ResultSet rs = null;
        RoShamBoResult roShamBoResult = new RoShamBoResult();

        try {
            String qry =
                    """
                        SELECT *,
                               rWin / total * 100 AS rPer,
                               sWin / total * 100 AS sPer,
                               bWin / total * 100 AS bPer
                        FROM( SELECT a.id,
                                     a.`name`,
                                     SUM(b.`point`) AS point,
                                     SUM(IF(b.result = 0 AND b.roshambo = 0, 1, 0)) AS rWin,
                                     SUM(IF(b.result = 0 AND b.roshambo = 1, 1, 0)) AS sWin,
                                     SUM(IF(b.result = 0 AND b.roshambo = 2, 1, 0)) AS bWin,
                                     SUM(1) AS total
                              FROM `user` a
                              LEFT JOIN `history` b ON a.id = b.id
                              WHERE a.id = ? ) temp;
                    """;

            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, historyDTO.getId());

            rs = pstmt.executeQuery();
            while (rs.next()) {
                roShamBoResult.setId(rs.getString("id"));
                roShamBoResult.setName(rs.getString("name"));
                roShamBoResult.setPoint(rs.getInt("point"));
                roShamBoResult.setrWin(rs.getInt("rWin"));
                roShamBoResult.setsWin(rs.getInt("sWin"));
                roShamBoResult.setbWin(rs.getInt("bWin"));
                roShamBoResult.setrPer(rs.getInt("rPer"));
                roShamBoResult.setsPer(rs.getInt("sPer"));
                roShamBoResult.setbPer(rs.getInt("bPer"));
            }

            return roShamBoResult;

        } catch (SQLException e) {
            DBCon.sqlEx(e);
            throw new RuntimeException(e);
        }
    }

    public ArrayList<HistoryDTO> selectAllHistory(HistoryDTO historyDTO) {

        ResultSet rs = null;
        ArrayList<HistoryDTO> historyDTOs = new ArrayList<>();

        try {
            String qry =
                    """
                        SELECT *
                        FROM `history`
                        WHERE `id` = ?
                        ORDER BY id, roshambo, result;
                    """;

            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, historyDTO.getId());

            rs = pstmt.executeQuery();
            while (rs.next()) {
                HistoryDTO dto = new HistoryDTO();
                dto.setNo(rs.getInt("no"));
                dto.setId(rs.getString("id"));
                dto.setRoshambo(rs.getInt("roshambo"));
                dto.setPoint(rs.getInt("point"));
                dto.setResult(rs.getInt("result"));
                historyDTOs.add(dto);
            }

            return historyDTOs;

        } catch (SQLException e) {
            DBCon.sqlEx(e);
            throw new RuntimeException(e);
        }
    }

}
