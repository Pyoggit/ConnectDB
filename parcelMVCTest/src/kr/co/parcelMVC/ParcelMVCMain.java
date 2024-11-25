package kr.co.parcelMVC;

import java.util.Scanner;

import kr.co.parcelMVC.controller.CustomerRegisterManager;
import kr.co.parcelMVC.controller.ProductRegisterManager;
import kr.co.parcelMVC.view.MENU_CHOICE;
import kr.co.parcelMVC.view.MenuViewer;
import kr.co.parcelMVC.view.PRODUCT_CHOICE;

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
	
	//고객 정보 메뉴
	private static void customerMenu() {
		int no;
		CustomerRegisterManager crm = new CustomerRegisterManager();

		MenuViewer.customerMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case PRODUCT_CHOICE.LIST:
			System.out.println("");
//            studnetManager.studnetTotalList();
			break;
		case PRODUCT_CHOICE.INSERT:
			System.out.println("");
			// srm.insertManager();
			break;
		case PRODUCT_CHOICE.UPDATE:
			System.out.println("");
//            studnetManager.studnetUpdate();
			break;
		case PRODUCT_CHOICE.DELETE:
			System.out.println("");
//            studnetManager.studnetTotalList();
			break;
		case PRODUCT_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}		
	}
	
	//상품 정보 메뉴
	private static void productMenu() {
		int no;
		ProductRegisterManager crm = new ProductRegisterManager();

		MenuViewer.productMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case PRODUCT_CHOICE.LIST:
			System.out.println("");
//            studnetManager.studnetTotalList();
			break;
		case PRODUCT_CHOICE.INSERT:
			System.out.println("");
			// srm.insertManager();
			break;
		case PRODUCT_CHOICE.UPDATE:
			System.out.println("");
//            studnetManager.studnetUpdate();
			break;
		case PRODUCT_CHOICE.DELETE:
			System.out.println("");
//            studnetManager.studnetTotalList();
			break;
		case PRODUCT_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}	
		
	}

	//회사 정보 메뉴
	private static void companyMenu() {
		// TODO Auto-generated method stub
		
	}

	//주문 정보 메뉴
	private static void buyMenu() {
		// TODO Auto-generated method stub
		
	}

}
