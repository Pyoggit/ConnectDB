package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDB {

	public static void main(String[] args) {
		//객체참조변수 선언
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Employees> employeesList = new ArrayList<Employees>();
		//1. jdbc driver load
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 드라이버 적재 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("1. 드라이버 적재 실패" + e.toString());
		}
		
		//2. connection
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/xe", "hr", "hr");
			System.out.println("2. 오라클 접속 성공");
		} catch (SQLException e) {
			System.out.println("2. 오라클 접속 실패" + e.toString());
		}
		
		//3. statement( query : C,U,R,D)
		try {
			stmt = con.createStatement();
			
			System.out.println("3. Statement 객체생성성공");
		} catch (SQLException e) {
			System.out.println("3. Statement 객체생성실패" + e.toString());
		}
		
		//4. result set
		try {
			rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
			System.out.println("4. result set 객체생성성공");
		} catch (SQLException e) {
			System.out.println("4. result set 객체생성실패" + e.toString());
		}
		
		//5. 데이터저장진행
		try {
			while(rs.next()) {
				int employeeID = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				int salary = rs.getInt("SALARY");
				//System.out.println(employeeID + "\t" + firstName + "\t" + salary);
				Employees employees = new Employees(employeeID, firstName, salary);
				employeesList.add(employees);
			}
		} catch (SQLException e) {
			System.out.println("5. result set 출력실패");
		}
		//데이터 출력
		employeesListPrint(employeesList);
		
		
		//6. close
		if(con != null) {
			try {
				con.close();
				System.out.println("5. con close 성공");
			} catch (SQLException e) {
				System.out.println("5. con close 실패" + e.toString());
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
				System.out.println("6. stmt close 성공");
			} catch (SQLException e) {
				System.out.println("6. stmt close 실패" + e.toString());
			}
		}
		if(rs != null) {
			try {
				rs.close();
				System.out.println("6. rs close 성공");
			} catch (SQLException e) {
				System.out.println("6. rs close 실패" + e.toString());
			}
		}

	}

	private static void employeesListPrint(ArrayList<Employees> employeesList) {
		for(Employees E : employeesList) {
			System.out.println(E.toString());
		}
	}

}

