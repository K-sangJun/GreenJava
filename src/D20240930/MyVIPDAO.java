package D20240930;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyVIPDAO {

    Connection conn = DBCon.getConnection();

    public ArrayList<MyVIPDTO> select(){

        ArrayList<MyVIPDTO> arr = new ArrayList<>();

        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from myVIP");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MyVIPDTO dto = new MyVIPDTO();
                dto.setName(rs.getString("name"));
                dto.setBirth(rs.getDate("birth"));
                dto.setRegDate(rs.getTimestamp("regDate"));
                arr.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return arr;
    }

    public int insert(MyVIPDTO dto){

        try {

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO myvip (name, birth, regdate)VALUES (?, ?, NOW())");
            pstmt.setString(1, dto.getName());
            pstmt.setDate(2, dto.getBirth());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
