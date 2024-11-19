package bookTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class BooksMain {
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
				booksPrint();
				break;
			}
			case INSERT: {
				booksInsert();
				break;
			}
			case UPDATE: {
				booksUpdate();
				break;
			}
			case DELETE: {
				booksDelete();
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
		Statement stmt = null;

		// 1 Load, 2. connect
		con = DBConnection.dbCon();
		// 3. statement
		System.out.println("삭제할번호>>");
		int no = Integer.parseInt(sc.nextLine());
		stmt = con.createStatement();
		int result = stmt.executeUpdate("DELETE FROM BOOKS WHERE ID = " + no);
		// 4. 내용 체크
		System.out.println((result != 0) ? "삭제성공" : "삭제실패");
		// 5. sql 객체 반납
		DBConnection.dbClose(con, stmt);

	}

	// 수정
	private static void booksUpdate() throws SQLException {
		// Conection
		Connection con = null;
		Statement stmt = null;

		// 1 Load, 2. connect
		con = DBConnection.dbCon();
		// 3. statement
		//수정데이터 입력
		Books books = new Books(3, "Head First JavaScript", "khg", "2024", 50000);
		stmt = con.createStatement();
		int result = stmt.executeUpdate("UPDATE BOOKS SET TITLE = "
				+ "'" +books.getTitle()+"', PUBLISHER = '"+books.getPublisher()+"', YEAR = '"+books.getYear()+"', PRICE = "+books.getPrice()+" WHERE ID = "+books.getId()+"");
		// 4. 내용 체크
		System.out.println((result != 0) ? "수정성공" : "수정실패");
		// 5. sql 객체 반납
		DBConnection.dbClose(con, stmt);
	}

	// 입력
	private static void booksInsert() throws SQLException {
		// Conection
		Connection con = null;
		Statement stmt = null;

		// 1 Load, 2. connect
		con = DBConnection.dbCon();
		// 3. statement
		Books books = new Books(0, "Head First Java", "jjj", "2017", 73000);
		String publisher = "jjj";
		stmt = con.createStatement();
		int result = stmt.executeUpdate("INSERT INTO books VALUES" + "(BOOKS_ID_SEQ.nextval, '" + books.getTitle()
				+ "' , '" + books.getPublisher() + "','" + books.getYear() + "','" + books.getPrice() + "')");
		// 4. 내용 체크
		System.out.println((result != 0) ? "입력성공" : "입력실패");
		// 5. sql 객체 반납
		DBConnection.dbClose(con, stmt);

	}

	private static void printMenu() {
		System.out.println("Books Menu(1. select, 2. insert, 3. update, 4. delete, 5. close)");
		System.out.println(">>");
	}

	private static void booksListPrint(ArrayList<Books> booksList) {
		for (Books books : booksList) {
			System.out.println(books.toString());
		}
	}

}
