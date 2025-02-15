package bookTest2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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

			case BookMenu.SALARY_UP_PROC:
				employeeSalaryUpProc();
				break;

			case BookMenu.SALARY_UP_FUNC:
				employeeSalaryUpFunc();
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

	private static void employeeSalaryUpFunc() throws SQLException {
		// Conection
		Connection con = null;
		CallableStatement cstmt = null;

		// 1 Load, 2. connect
		con = DBConnection.dbCon();
		
		System.out.print("조회 ID 입력: >>");
		int id = Integer.parseInt(sc.nextLine());

		// 3. cstmt
		cstmt = con.prepareCall("{ ? = call BOOKS_FUNCTION(?)}");
		cstmt.registerOutParameter(1, Types.VARCHAR);
		cstmt.setInt(2, id);
		// 출력될 데이터값으로 3번을 바인딩시킨다.

		int result = cstmt.executeUpdate();
		String message = cstmt.getString(1);
		System.out.println(message);
		
		// 4. 내용 체크
		System.out.println((result != 0) ? "조회 성공" : "조회 실패");
		
		// 5. sql 객체 반납
		DBConnection.dbClose(con, cstmt);
	}

	// 책값 인상
	private static void employeeSalaryUpProc() throws SQLException {
		// Conection
		Connection con = null;
		CallableStatement cstmt = null;

		// 1 Load, 2. connect
		con = DBConnection.dbCon();
		System.out.print("인상할 ID 입력: >>");
		int id = Integer.parseInt(sc.nextLine());

		System.out.print("인상금액입력: >>");
		int price = Integer.parseInt(sc.nextLine());

		// 3. cstmt
		cstmt = con.prepareCall("{call BOOKS_PROCEDURE(?, ?, ?)}");
		cstmt.setInt(1, id);
		cstmt.setInt(2, price);
		// 출력될 데이터값으로 3번을 바인딩시킨다.
		cstmt.registerOutParameter(3, Types.VARCHAR);

		int result = cstmt.executeUpdate();
		String message = cstmt.getString(3);
		System.out.println(message);
		
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
		
		//트랜잭션 시작
		con.setAutoCommit(false);
		
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
		if(result != 0) {
			con.commit();
		}else {
			con.rollback();
		}
		
		// 5. sql 객체 반납
		DBConnection.dbClose(con, pstmt);

	}

	private static void printMenu() {
		System.out.println("Books Menu(1.출력, 2.입력, 3.수정, 4.삭제, 5.책값 인상, 6.책값 조회, 7.종료)");
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
