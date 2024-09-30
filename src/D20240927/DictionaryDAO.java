package D20240927;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DictionaryDAO {

    Connection conn;

    public DictionaryDAO() {
        conn = DBCon.getConnection();
    }

    public void insert(DictionaryDTO dicDTO) {

        String qry = "INSERT INTO dictionary (word, mean) VALUES (?, ?) ";
        try {
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, dicDTO.getWord());
            pstmt.setString(2, dicDTO.getMean());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            DBCon.sqlEx(e);
        }
    }

    public ArrayList<DictionaryDTO> select(DictionaryDTO dicDTO) {

        ResultSet rs;
        String qry = "SELECT * FROM dictionary WHERE word LIKE CONCAT('%', ?, '%') AND mean LIKE CONCAT('%', ?, '%')";
        ArrayList<DictionaryDTO> result = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, dicDTO.getMean());
            pstmt.setString(2, dicDTO.getMean());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                DictionaryDTO dto = new DictionaryDTO();
                dto.setWord(rs.getString("word"));
                dto.setMean(rs.getString("mean"));
                result.add(dto);
            }
        } catch (SQLException e) {
            DBCon.sqlEx(e);
        }

        return result;
    }

    public ArrayList<DictionaryDTO> exam_select(int cnt) {

        ArrayList<DictionaryDTO> result = new ArrayList<>();

        try {
            String qry = "SELECT * FROM dictionary ORDER BY RAND() LIMIT ?";
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setInt(1, cnt);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DictionaryDTO dto = new DictionaryDTO();
                dto.setWord(rs.getString("word"));
                dto.setMean(rs.getString("mean"));
                result.add(dto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public void exam_insert(String dtm, String name, String word, String rightYN) {

        try {
            String qry = "INSERT INTO dictionary_history (dtm, name, word, rightYN) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, dtm);
            pstmt.setString(2, name);
            pstmt.setString(3, word);
            pstmt.setString(4, rightYN);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Map<String, String>> exam_history(String name, String dtm) {

        ArrayList<Map<String, String>> list = new ArrayList<>();

        try {
            String qry = "SELECT COUNT(a.word) AS total, SUM(IF(rightYN != 'Y',1,0)) AS lose, a.name " +
                         "FROM dictionary_history a " +
                         "WHERE a.`name` LIKE CONCAT('%', ?, '%') " +
                         "AND dtm LIKE CONCAT('%', ?,'%') " +
                         "GROUP BY a.`name`, a.dtm;";
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, name);
            pstmt.setString(2, dtm);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Map<String, String> result = new HashMap<>();
                result.put("total", rs.getString("total"));
                result.put("lose", rs.getString("lose"));
                result.put("name", rs.getString("name"));
                list.add(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }


}
