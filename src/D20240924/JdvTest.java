package D20240924;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdvTest {

	
	public static void main(String[] args){
		
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/mydb";
		String uid = "root";
		String upw = "1234";
//		1. 접속 담당
		Connection conn = null;
//		2. 쿼리 담당
		Statement stmt = null;
//		3. 조회 결과 담당
		ResultSet rs = null;

		try {
//			1. JDBC 드라이버 로드(생략가능 - 자바6이상)
			Class.forName(driverName);

//			2. 데이터베이스 연결
			conn = DriverManager.getConnection(url, uid, upw);

			if (conn != null) {
				System.out.println("데이터베이스 연결 되었습니다.");
			}

//			3. SQL 쿼리 작성 및 실행
			String query = "SELECT * FROM student";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			rs.next();

			String name = rs.getString("name");
			String schoolYear = rs.getString("schoolYear");

//			System.out.println(name);
//			System.out.println(schoolYear);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    }
}