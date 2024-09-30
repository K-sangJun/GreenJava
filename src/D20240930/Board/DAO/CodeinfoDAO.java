package D20240930.Board.DAO;

import D20240930.Board.DBCon;
import D20240930.Board.DTO.CodeinfoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CodeinfoDAO {

    Connection conn = DBCon.getConnection();

    public ArrayList<CodeinfoDTO> codeinfos(String up_cd) {

        ArrayList<CodeinfoDTO> list = new ArrayList<>();

        try {
            ResultSet rs;
            String qry = "SELECT * FROM codeinfo WHERE up_cd = ?";
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, up_cd);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                CodeinfoDTO dto = new CodeinfoDTO();
                dto.setCd(rs.getString("cd"));
                dto.setUpCd(rs.getString("up_cd"));
                dto.setCdNm(rs.getString("cd_nm"));
                dto.setCdDtl(rs.getString("cd_dtl"));
                dto.setCdSet1(rs.getString("cd_set1"));
                dto.setCdSet2(rs.getString("cd_set2"));
                dto.setCdSet3(rs.getString("cd_set3"));
                list.add(dto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

}
