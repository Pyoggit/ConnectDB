package kr.co.parcelMVC.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import kr.co.parcelMVC.model.BuyVO;


public class BuyRegisterManager {

    public static Scanner sc = new Scanner(System.in);

    // 출력 확인
    public static void selectManager() throws SQLException {
        ArrayList<BuyVO> buyList = new ArrayList<BuyVO>();
        BuyDAO buyDAO = new BuyDAO();
        buyList = buyDAO.buySelect();
        if (buyList == null) {
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        printBuyList(buyList);
    }

    // 입력 확인
    public static void insertManager() throws SQLException {
        BuyDAO bd = new BuyDAO();

        String code; // 주문 코드
        String custCode; // 회원 코드
        String proCode; // 상품 코드
        String copCode; // 업체 코드
        int amount; // 주문 수량
        int total; // 총 금액

        System.out.println("주문 정보 입력: 주문코드, 회원코드, 상품코드, 업체코드, 주문수량, 총금액");
        System.out.print("주문코드: ");
        code = sc.nextLine();
        System.out.print("회원코드: ");
        custCode = sc.nextLine();
        System.out.print("상품코드: ");
        proCode = sc.nextLine();
        System.out.print("업체코드: ");
        copCode = sc.nextLine();
        System.out.print("주문수량: ");
        amount = Integer.parseInt(sc.nextLine());
        System.out.print("총금액: ");
        total = Integer.parseInt(sc.nextLine());

        BuyVO bvo = new BuyVO(code, custCode, proCode, copCode, amount, total);
        boolean successFlag = bd.buyInsert(bvo);
        if (!successFlag) {
            System.out.println("입력처리 실패");
            return;
        }

        System.out.println();
        System.out.println("주문 전체 리스트");
        ArrayList<BuyVO> buyList = bd.buySelect();
        if (buyList == null) {
            System.out.println("주문 정보가 없습니다");
            return;
        }

        printBuyList(buyList);
    }

    // 수정
    public static void updateManager() throws SQLException {
        BuyDAO bd = new BuyDAO();
        ArrayList<BuyVO> buyList = bd.buySelect();
        if (buyList == null) {
            System.out.println("데이터가 존재하지 않습니다.");
        }
        printBuyList(buyList);
        System.out.print("수정할 주문의 코드를 입력하세요: ");
        String code = (sc.nextLine()).trim();
        System.out.print("수정할 회원 코드를 입력하세요: ");
        String custCode = sc.nextLine();
        System.out.print("수정할 상품 코드를 입력하세요: ");
        String proCode = sc.nextLine();
        System.out.print("수정할 업체 코드를 입력하세요: ");
        String copCode = sc.nextLine();
        System.out.print("수정할 주문 수량을 입력하세요: ");
        int amount = Integer.parseInt(sc.nextLine());
        System.out.print("수정할 총 금액을 입력하세요: ");
        int total = Integer.parseInt(sc.nextLine());

        BuyVO bvo = new BuyVO(code, custCode, proCode, copCode, amount, total);

        boolean successFlag = bd.buyUpdate(bvo);

        if (successFlag) {
            System.out.println("수정처리 성공");
        } else {
            System.out.println("수정처리 실패");
        }
    }

    // 삭제 확인
    public static void deleteManager() throws SQLException {
        BuyDAO bd = new BuyDAO();

        System.out.print("삭제할 주문 코드를 입력하세요: ");
        String code = (sc.nextLine()).trim();
        BuyVO bvo = new BuyVO();
        bvo.setCode(code);
        boolean successFlag = bd.buyDelete(bvo);
        if (successFlag) {
            System.out.println("삭제처리 성공");
        } else {
            System.out.println("삭제처리 실패");
        }
    }

    // 주문, 고객, 상품, 업체 정보를 포함한 주문 조회
    public static void selectDetailManager() throws SQLException {
        BuyDAO bd = new BuyDAO();
        ArrayList<BuyVO> buyList = bd.buySelectDetail();
        if (buyList == null) {
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        printBuyList(buyList);
    }

    // 전체 주문 리스트를 출력
    public static void printBuyList(ArrayList<BuyVO> buyList) {
        System.out.println("=====================================================================================");
        System.out.println("주문 정보");
        System.out.println("=====================================================================================");
        for (BuyVO bv : buyList) {
            System.out.println(bv.toString());
        }
        System.out.println("=====================================================================================");
    }
}