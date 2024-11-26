package kr.co.parcelMVC.view;

public class MenuViewer {
	// 메인메뉴
	public static void mainMenuView() {
	    System.out.println("─────────────────────────────────────────────────────────────────────────────────────");
	    System.out.println("                              ─ 배송 관리 시스템 ─                                   ");
	    System.out.println("─────────────────────────────────────────────────────────────────────────────────────");
	    System.out.println("1. 고객정보 들어가기 │ 2. 상품 정보 들어가기 │ 3. 업체 정보 들어가기 │ 4. 주문 정보 들어가기 │ 5. 종료   ");
	    System.out.println("─────────────────────────────────────────────────────────────────────────────────────");
	    System.out.print("실행할 메뉴의 번호를 입력하세요.\n>> ");
	    
	}
	//고객정보 메뉴
	public static void customerMenuView() {
	    System.out.println("─────────────────────────────────────────────────────────────────────────────────────");
	    System.out.println("                              ─ 고객 정보 메뉴 ─                                   ");
	    System.out.println("─────────────────────────────────────────────────────────────────────────────────────");
	    System.out.println("1. 고객 정보 목록 │ 2. 고객 정보 입력 │ 3. 고객 정보 수정 │ 4. 고객 정보 삭제 │ 5. 메인 메뉴   ");
	    System.out.println("─────────────────────────────────────────────────────────────────────────────────────");
	    System.out.print("실행할 메뉴의 번호를 입력하세요.\n>> ");
	    
	}
	//상품정보 메뉴
	public static void productMenuView() {
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("                              ─ 상품 정보 메뉴 ─                                   ");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("1. 상품 정보 목록 │ 2. 상품 정보 입력 │ 3. 상품 정보 수정 │ 4. 상품 정보 삭제 │ 5. 메인 메뉴   ");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────");
		System.out.print("실행할 메뉴의 번호를 입력하세요.\n>> ");
		
	}
	//회사정보 메뉴
	public static void companyMenuView() {
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("                              ─ 배송업체 정보 메뉴 ─                                   ");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("1. 업체 정보 목록 │ 2. 업체 정보 입력 │ 3. 업체 정보 수정 │ 4. 업체 정보 삭제 │ 5. 메인 메뉴   ");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────");
		System.out.print("실행할 메뉴의 번호를 입력하세요.\n>> ");
		
	}
	//주문정보 메뉴
	public static void buyMenuView() {
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("                                           ─ 주문 정보 메뉴 ─                                   ");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("1. 주문 정보 목록 │ 2. 주문 정보 입력 │ 3. 주문 정보 수정 │ 4. 주문 정보 삭제 │ 5. 고객주문 정보 목록 │ 6. 메인 메뉴   ");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.print("실행할 메뉴의 번호를 입력하세요.\n>> ");
		
	}

}
