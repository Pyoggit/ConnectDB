package bookTest2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class BooksMain {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		boolean exitFlag = false;
		while (!exitFlag) {
			// 사용자로부터 출력, 입력, 수정, 삭제 요청
			printMenu();
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case BookMenu.PRINT:
				booksPrint();
				break;

			case BookMenu.INSERT:
				booksInsert();
				break;

			case BookMenu.UPDATE:
				booksUpdate();
				break;

			case BookMenu.DELETE:
				booksDelete();
				break;

			case BookMenu.SALARY_UP:
				employeeSalaryUp();
				break;

			case BookMenu.EXIT:
				exitFlag = true;
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + num);
			}
			System.out.println("The end");
		}

	}

	// 연봉인상 10%
	private static void employeeSalaryUp() throws SQLException {
		// Conection
		Connection con = null;
		CallableStatement cstmt = null;
		// 1 Load, 2. connect
		con = DBConnection.dbCon();
		System.out.print("인상될 ID 입력: >>");
		int id = Integer.parseInt(sc.nextLine());
		
		System.out.print("인상금액(10%: 1.1)입력: >>");
		int price = Integer.parseInt(sc.nextLine());
		
		// 3. cstmt
		cstmt = con.prepareCall("{call BOOKS_PROCEDURE(?, ? )}");
		cstmt.setInt(1, id);
		cstmt.setDouble(2, price);
		
		int result = cstmt.executeUpdate();
		// 4. 내용 체크
		System.out.println((result != 0) ? "책값 인상 성공" : "책값 인상 실패");
		// 5. sql 객체 반납
		DBConnection.dbClose(con, cstmt);

	}

	// 출력
	public static void booksPrint() throws SQLException {
		// Conection
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Books> booksList = new ArrayList<Books>();

		// 1 Load, 2. connect
		con = DBConnection.dbCon();
		// 3. statement
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT * FROM BOOKS");
		// 테이블 가져오기
		while (rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String publisher = rs.getString("PUBLISHER");
			String year = rs.getString("YEAR");
			int price = rs.getInt("PRICE");
			Books books = new Books(id, title, publisher, year, price);
			booksList.add(books);
		}
		// 출력하기
		booksListPrint(booksList);
		// sql 객체 반납
		DBConnection.dbClose(con, stmt, rs);
	}

	// 삭제
	private static void booksDelete() throws SQLException {
		// Conection
		Connection con = null;
		PreparedStatement pstmt = null;

		// 1 Load, 2. connect
		con = DBConnection.dbCon();
		// 3. statement
		System.out.print("삭제할번호>>");
		int no = Integer.parseInt(sc.nextLine());
		pstmt = con.prepareStatement("DELETE FROM BOOKS WHERE ID = ?");
		pstmt.setInt(1, no);
		int result = pstmt.executeUpdate();
		// 4. 내용 체크
		System.out.println((result != 0) ? "삭제성공" : "삭제실패");
		// 5. sql 객체 반납
		DBConnection.dbClose(con, pstmt);

	}

	// 수정
	private static void booksUpdate() throws SQLException {
		// Conection
		Connection con = null;
		PreparedStatement pstmt = null;

		// 1 Load, 2. connect
		con = DBConnection.dbCon();
		// 3. statement
		// 수정데이터 입력
		Books books = new Books(3, "Head First JavaScript", "khg", "2024", 59000);
		pstmt = con.prepareStatement("UPDATE BOOKS SET TITLE = ?, PUBLISHER = ?, YEAR = ?, PRICE = ? WHERE ID = ? ");
		pstmt.setString(1, books.getTitle());
		pstmt.setString(2, books.getPublisher());
		pstmt.setString(3, books.getYear());
		pstmt.setInt(4, books.getPrice());
		pstmt.setInt(5, books.getId());
		int result = pstmt.executeUpdate();
		// 4. 내용 체크
		System.out.println((result != 0) ? "수정성공" : "수정실패");
		// 5. sql 객체 반납
		DBConnection.dbClose(con, pstmt);
	}

	// 입력
	private static void booksInsert() throws SQLException {
		// Conection
		Connection con = null;
		PreparedStatement pstmt = null;

		// 1 Load, 2. connect
		con = DBConnection.dbCon();
		// 3. statement
		Books books = new Books(0, "Head First Java", "jjj", "2017", 73000);
		pstmt = con.prepareStatement("INSERT INTO books VALUES(BOOKS_ID_SEQ.nextval,?,?,?,?)");
		pstmt.setString(1, books.getTitle());
		pstmt.setString(2, books.getPublisher());
		pstmt.setString(3, books.getYear());
		pstmt.setInt(4, books.getPrice());
		int result = pstmt.executeUpdate();
		// 4. 내용 체크
		System.out.println((result != 0) ? "입력성공" : "입력실패");
		// 5. sql 객체 반납
		DBConnection.dbClose(con, pstmt);

	}

	private static void printMenu() {
		System.out.println("Books Menu(1.출력, 2.입력, 3.수정, 4.삭제, 5.책값 인상, 6.종료)");
		System.out.print(">>");
	}

	private static void printEmployeeMenu() {
		System.out.println("Books Menu");
		System.out.print(">>");
	}

	private static void booksListPrint(ArrayList<Books> booksList) {
		for (Books books : booksList) {
			System.out.println(books.toString());
		}
	}

}
