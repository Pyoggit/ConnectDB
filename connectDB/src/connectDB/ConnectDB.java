package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDB {

    public static void main(String[] args) {
        // 객체참조변수 선언
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Employees> employeesList = new ArrayList<Employees>();

        // 1. jdbc driver load , 2. connection
        con = DBConnection.dbCon();

        try {
            // 3. statement 생성 및 쿼리 실행
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");

            // 4. 결과 처리
            while (rs.next()) {
                int employeeID = rs.getInt("EMPLOYEE_ID");
                String firstName = rs.getString("FIRST_NAME");
                int salary = rs.getInt("SALARY");
                Employees employees = new Employees(employeeID, firstName, salary);
                employeesList.add(employees);
            }

            // 데이터 출력
            employeesListPrint(employeesList);

        } catch (SQLException e) {
            System.out.println("데이터베이스 실행문 에러: " + e.toString());
        } finally {
            // 5. 자원 해제
            DBConnection.dbClose(con, stmt, rs);
        }
    }

    private static void employeesListPrint(ArrayList<Employees> employeesList) {
        for (Employees E : employeesList) {
            System.out.println(E.toString());
        }
    }
}
