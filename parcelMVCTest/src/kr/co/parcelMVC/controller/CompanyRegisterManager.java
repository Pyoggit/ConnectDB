package kr.co.parcelMVC.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import kr.co.parcelMVC.model.CompanyVO;


public class CompanyRegisterManager {

    public static Scanner sc = new Scanner(System.in);

    // 출력 확인
    public static void selectManager() throws SQLException {
        ArrayList<CompanyVO> companyList = new ArrayList<CompanyVO>();
        CompanyDAO companyDAO = new CompanyDAO();
        companyList = companyDAO.companySelect();
        if (companyList == null) {
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        printCompanyList(companyList);
    }

    // 입력 확인
    public static void insertManager() throws SQLException {
        CompanyDAO cd = new CompanyDAO();

        String code; // 회사 코드
        String name; // 회사명
        int price; // 가격

        System.out.println("업체 정보 입력: 회사코드(배송업체명, 배송비)");
        System.out.print("회사코드: ");
        code = sc.nextLine();
        System.out.print("배송업체명: ");
        name = sc.nextLine();
        System.out.print("배송비: ");
        price = Integer.parseInt(sc.nextLine());

        CompanyVO cvo = new CompanyVO(code, name, price);
        boolean successFlag = cd.companyInsert(cvo);
        if (!successFlag) {
            System.out.println("입력처리 실패");
            return;
        }

        System.out.println();
        System.out.println("배송업체 전체 리스트");
        ArrayList<CompanyVO> companyList = cd.companySelect();
        if (companyList == null) {
            System.out.println("업체 정보가 없습니다");
            return;
        }

        printCompanyList(companyList);
    }

    // 수정
    public static void updateManager() throws SQLException {
        CompanyDAO cd = new CompanyDAO();
        ArrayList<CompanyVO> companyList = cd.companySelect();
        if (companyList == null) {
            System.out.println("데이터가 존재하지 않습니다.");
        }
        printCompanyList(companyList);
        System.out.print("수정할 배송업체의 코드를 입력하세요: ");
        String code = (sc.nextLine()).trim();
        System.out.print("수정할 배송업체 이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("수정할 가격을 입력하세요: ");
        int price = Integer.parseInt(sc.nextLine());

        CompanyVO cvo = new CompanyVO(code, name, price);

        boolean successFlag = cd.companyUpdate(cvo);

        if (successFlag) {
            System.out.println("수정처리 성공");
        } else {
            System.out.println("수정처리 실패");
        }
    }

    // 삭제 확인
    public static void deleteManager() throws SQLException {
        CompanyDAO cd = new CompanyDAO();

        System.out.print("삭제할 배송업체의 코드를 입력하세요: ");
        String code = (sc.nextLine()).trim();
        CompanyVO cvo = new CompanyVO();
        cvo.setCode(code);
        boolean successFlag = cd.companyDelete(cvo);
        if (successFlag) {
            System.out.println("삭제처리 성공");
        } else {
            System.out.println("삭제처리 실패");
        }
    }

    // 전체 회사 리스트를 출력
    public static void printCompanyList(ArrayList<CompanyVO> companyList) {
        System.out.println("=====================================================================================");
        System.out.println(" 배송업체 정보");
        System.out.println("=====================================================================================");
        for (CompanyVO cv : companyList) {
            System.out.println(cv.toString());
        }
        System.out.println("=====================================================================================");
    }
}
