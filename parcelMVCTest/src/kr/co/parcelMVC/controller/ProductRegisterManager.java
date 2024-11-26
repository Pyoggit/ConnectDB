package kr.co.parcelMVC.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import kr.co.parcelMVC.model.ProductVO;


public class ProductRegisterManager {

    public static Scanner sc = new Scanner(System.in);

    // 출력 확인
    public static void selectManager() throws SQLException {
        ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
        ProductDAO productDAO = new ProductDAO();
        productList = productDAO.productSelect();
        if (productList == null) {
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        printProductList(productList);
    }

    // 입력 확인
    public static void insertManager() throws SQLException {
        ProductDAO pd = new ProductDAO();

        String code; // 상품 코드
        String name; // 상품명
        int price; // 가격
        int remain; // 잔여수량

        System.out.println("상품 정보 입력: 상품코드(상품명, 가격, 잔여수량)");
        System.out.print("상품코드: ");
        code = sc.nextLine();
        System.out.print("상품명: ");
        name = sc.nextLine();
        System.out.print("가격: ");
        price = Integer.parseInt(sc.nextLine());
        System.out.print("잔여수량: ");
        remain = Integer.parseInt(sc.nextLine());

        ProductVO pvo = new ProductVO(code, name, price, remain);
        boolean successFlag = pd.productInsert(pvo);
        if (!successFlag) {
            System.out.println("입력처리 실패");
            return;
        }

        System.out.println();
        System.out.println("상품 전체 리스트");
        ArrayList<ProductVO> productList = pd.productSelect();
        if (productList == null) {
            System.out.println("상품 정보가 없습니다");
            return;
        }

        printProductList(productList);
    }

    // 수정
    public static void updateManager() throws SQLException {
        ProductDAO pd = new ProductDAO();
        ArrayList<ProductVO> productList = pd.productSelect();
        if (productList == null) {
            System.out.println("데이터가 존재하지 않습니다.");
        }
        printProductList(productList);
        System.out.print("수정할 상품의 코드를 입력하세요: ");
        String code = (sc.nextLine()).trim();
        System.out.print("수정할 상품 이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("수정할 가격을 입력하세요: ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.print("수정할 잔여수량을 입력하세요: ");
        int remain = Integer.parseInt(sc.nextLine());

        ProductVO pvo = new ProductVO(code, name, price, remain);

        boolean successFlag = pd.productUpdate(pvo);

        if (successFlag) {
            System.out.println("수정처리 성공");
        } else {
            System.out.println("수정처리 실패");
        }
    }

    // 삭제 확인
    public static void deleteManager() throws SQLException {
        ProductDAO pd = new ProductDAO();

        System.out.print("삭제할 상품 코드를 입력하세요: ");
        String code = (sc.nextLine()).trim();
        ProductVO pvo = new ProductVO();
        pvo.setCode(code);
        boolean successFlag = pd.productDelete(pvo);
        if (successFlag) {
            System.out.println("삭제처리 성공");
        } else {
            System.out.println("삭제처리 실패");
        }
    }

    // 전체 상품 리스트를 출력
    public static void printProductList(ArrayList<ProductVO> productList) {
        System.out.println("=====================================================================================");
        System.out.println("상품 정보");
        System.out.println("=====================================================================================");
        for (ProductVO pv : productList) {
            System.out.println(pv.toString());
        }
        System.out.println("=====================================================================================");
    }
}
