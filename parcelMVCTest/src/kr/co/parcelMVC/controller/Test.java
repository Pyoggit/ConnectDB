package kr.co.parcelMVC.controller;

import java.sql.Connection;

/* MVC 패턴(Model View Controller)
 * Model: VO(Value Object)
 * 		VO: 데이터의 구조를 캡슐화하여 데이터를 관리하고 전달
 * 
 * View: 사용자에게 보여지는 UI 요소, 화면에 데이터를 표시하거나 사용자의 입력을 받음
 * 
 * Controller:DAO(Data Access Object),RegisterManager  
 * 		DAO: 데이터베이스와 상호작용하여 데이터를 처리하고 저장
 * 		RegisterManager: 사용자의 요청을 받아 비즈니스 로직을 처리하며, DAO를 호출하여 데이터 작업을 수행
 * 
 */

public class Test {
	public static void main(String[] args) {
		Connection con = DBUtility.dbCon();
		if (con != null) {
			System.out.println("데이타베이스 접속 성공");
		} else {
			System.out.println("데이타베이스 접속 실패");
		}
	}

}
