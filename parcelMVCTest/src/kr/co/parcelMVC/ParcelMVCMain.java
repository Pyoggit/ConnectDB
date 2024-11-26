package kr.co.parcelMVC;

import java.sql.SQLException;
import java.util.Scanner;

import kr.co.parcelMVC.controller.BuyRegisterManager;
import kr.co.parcelMVC.controller.CompanyRegisterManager;
import kr.co.parcelMVC.controller.CustomerRegisterManager;
import kr.co.parcelMVC.controller.ProductRegisterManager;
import kr.co.parcelMVC.view.BUY_CHOICE;
import kr.co.parcelMVC.view.MENU_CHOICE;
import kr.co.parcelMVC.view.MenuViewer;

public class ParcelMVCMain {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int no;
		boolean exitFlag = false;
		while (!exitFlag) {
			try {
				MenuViewer.mainMenuView();
				no = Integer.parseInt(sc.nextLine());
				switch (no) {
				case MENU_CHOICE.CUSTOMER:
					customerMenu();
					break;
				case MENU_CHOICE.PRODUCT:
					productMenu();
					break;
				case MENU_CHOICE.COMPANY:
					companyMenu();
					break;
				case MENU_CHOICE.BUY:
					buyMenu();
					break;
				case MENU_CHOICE.EXIT:
					System.out.println("프로그램을 종료합니다.");
					exitFlag = true;
					break;
				default:
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
			}
		} // end of line

	}

	// 고객 정보 메뉴
	private static void customerMenu() {
		int no;
		CustomerRegisterManager crm = new CustomerRegisterManager();

		MenuViewer.customerMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case BUY_CHOICE.LIST:
			System.out.println("");
			crm.selectManager();
			break;
		case BUY_CHOICE.INSERT:
			System.out.println("");
			try {
				crm.insertManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case BUY_CHOICE.UPDATE:
			System.out.println("");
			try {
				crm.updateManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case BUY_CHOICE.DELETE:
			System.out.println("");
			try {
				crm.deleteManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case BUY_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당되는 메뉴 번호만 입력하세요.");
		}
	}

	// 상품 정보 메뉴
	private static void productMenu() {
		int no;
		ProductRegisterManager prm = new ProductRegisterManager();

		MenuViewer.productMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case BUY_CHOICE.LIST:
			System.out.println("");
			try {
				prm.selectManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case BUY_CHOICE.INSERT:
			System.out.println("");
			try {
				prm.insertManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case BUY_CHOICE.UPDATE:
			System.out.println("");
			try {
				prm.updateManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case BUY_CHOICE.DELETE:
			System.out.println("");
			try {
				prm.deleteManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case BUY_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당되는 메뉴 번호만 입력하세요.");
		}

	}

	// 회사 정보 메뉴
	private static void companyMenu() {
		int no;
		CompanyRegisterManager corm = new CompanyRegisterManager();

		MenuViewer.companyMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case BUY_CHOICE.LIST:
			System.out.println("");
			try {
				corm.selectManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case BUY_CHOICE.INSERT:
			System.out.println("");
			try {
				corm.insertManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case BUY_CHOICE.UPDATE:
			System.out.println("");
			try {
				corm.updateManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case BUY_CHOICE.DELETE:
			System.out.println("");
			try {
				corm.deleteManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case BUY_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당되는 메뉴 번호만 입력하세요.");
		}

	}

	// 주문 정보 메뉴
	private static void buyMenu() {
		int no;
		BuyRegisterManager brm = new BuyRegisterManager();

		MenuViewer.buyMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case BUY_CHOICE.LIST:
			System.out.println("");
			try {
				brm.selectManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case BUY_CHOICE.INSERT:
			System.out.println("");
			try {
				brm.insertManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case BUY_CHOICE.UPDATE:
			System.out.println("");
			try {
				brm.updateManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case BUY_CHOICE.DELETE:
			System.out.println("");
			try {
				brm.deleteManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case BUY_CHOICE.LIST_ALL:
			System.out.println("");
			try {
				brm.selectDetailManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;	
		case BUY_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당되는 메뉴 번호만 입력하세요.");
		}

	}

}
