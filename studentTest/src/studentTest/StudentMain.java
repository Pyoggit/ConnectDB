package studentTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {

	public static Scanner sc = new Scanner(System.in);
	public static final int PRINT = 1, INSERT = 2, UPDATE = 3, DELETE = 4, EXIT = 5;

	public static void main(String[] args) throws SQLException {
		boolean exitFlag = false;
		while (!exitFlag) {
			// 사용자로부터 출력, 입력, 수정, 삭제 요청
			printMenu();
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case PRINT: {
				stuPrint();
				break;
			}
			case INSERT: {
				stuInsert();
				break;
			}
			case UPDATE: {
				stuUpdate();
				break;
			}
			case DELETE: {
				stuDelete();
				break;
			}
			case EXIT: {
				exitFlag = true;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + num);
			}
			System.out.println("The end");
		}

	}

	// 출력
	private static void stuPrint() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Student> stuList = new ArrayList<Student>();

		con = DBConnection.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT * FROM STUDENT");

		while (rs.next()) {
			int stuNum = rs.getInt("STUNUM");
			String name = rs.getString("NAME");
			int kor = rs.getInt("KOR");
			int eng = rs.getInt("ENG");
			int mat = rs.getInt("MAT");

			Student stu = new Student(stuNum, name, kor, eng, mat);
			stuList.add(stu);
		}
		stuListPrint(stuList);
		DBConnection.dbClose(con, stmt, rs);
	}

	// 입력
	private static void stuInsert() throws SQLException {
		Connection con = null;
		Statement stmt = null;

		con = DBConnection.dbCon();
		System.out.print("학생 번호를 입력하세요: ");
		int stuNum = Integer.parseInt(sc.nextLine());
		System.out.print("학생 이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.print("국어 점수를 입력하세요: ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("영어 점수를 입력하세요: ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("수학 점수를 입력하세요: ");
		int mat = Integer.parseInt(sc.nextLine());

		stmt = con.createStatement();
		int result = stmt.executeUpdate(
				"INSERT INTO STUDENT VALUES (" + stuNum + ", '" + name + "', " + kor + ", " + eng + ", " + mat + ")");
		System.out.println((result != 0) ? "입력성공" : "입력실패");
		DBConnection.dbClose(con, stmt);
	}

	// 수정
	private static void stuUpdate() throws SQLException {
		Connection con = null;
		Statement stmt = null;

		con = DBConnection.dbCon();
		System.out.print("수정할 학생의 번호를 입력하세요: ");
		int stuNum = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.print("새로운 국어 점수를 입력하세요: ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 영어 점수를 입력하세요: ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 수학 점수를 입력하세요: ");
		int mat = Integer.parseInt(sc.nextLine());

		stmt = con.createStatement();
		int result = stmt.executeUpdate("UPDATE STUDENT SET NAME = '" + name + "', KOR = " + kor + ", ENG = " + eng
				+ ", MAT = " + mat + " WHERE STUNUM = " + stuNum);
		System.out.println((result != 0) ? "수정성공" : "수정실패");
		DBConnection.dbClose(con, stmt);
	}

	// 삭제
	private static void stuDelete() throws SQLException {
		Connection con = null;
		Statement stmt = null;

		con = DBConnection.dbCon();
		System.out.print("삭제할 학생 번호를 입력하세요: ");
		int stuNum = Integer.parseInt(sc.nextLine());
		stmt = con.createStatement();
		int result = stmt.executeUpdate("DELETE FROM STUDENT WHERE STUNUM = " + stuNum);
		System.out.println((result != 0) ? "삭제성공" : "삭제실패");
		DBConnection.dbClose(con, stmt);
	}

	private static void printMenu() {
		System.out.println("+++++++++++++++++++++");
		System.out.println("1.학생정보출력");
		System.out.println("2.학생정보입력");
		System.out.println("3.학생정보수정");
		System.out.println("4.학생정보삭제");
		System.out.println("5.종료");
		System.out.println("+++++++++++++++++++++");
		System.out.print(">>");
	}

	private static void stuListPrint(ArrayList<Student> stuList) {
		for (Student student : stuList) {
			System.out.println(student.toString());
		}
	}

}