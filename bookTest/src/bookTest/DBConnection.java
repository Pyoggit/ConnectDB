package bookTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {
	public static Connection dbCon() {

		Connection con = null;

		// 1. jdbc driver load 2. connection
		try {
			//OracleDriver 클래스를 찾아서 메모리에 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//오라클서버(DB 서버)에 접속 요청을 진행한다.
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/xe", "hr", "hr");
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return con;
	}

	public static void dbClose(Connection con, Statement stmt, ResultSet rs) {
		if (con != null) {
			try {
				con.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (stmt != null) {
			try {
				stmt.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (rs != null) {
			try {
				rs.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}

	}
	public static void dbClose(Connection con, Statement stmt) {
		if (con != null) {
			try {
				con.close();
				
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
				
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		
	}

}
