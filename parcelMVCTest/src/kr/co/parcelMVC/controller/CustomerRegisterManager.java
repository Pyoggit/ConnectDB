package kr.co.parcelMVC.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import kr.co.parcelMVC.model.CustomerVO;

public class CustomerRegisterManager {
    public static Scanner sc = new Scanner(System.in);

    // 고객정보출력
    public void selectManager() {
        CustomerDAO custdao = new CustomerDAO();
        ArrayList<CustomerVO> customerList = new ArrayList<CustomerVO>();

        customerList = custdao.customerSelect();
        if (customerList == null) {
            System.out.println("회원정보가 존재하지 않습니다");
            return;
        }
        printCustomerList(customerList);
    }

    // 고객정보입력
    public void insertManager() throws SQLException {
        CustomerDAO customerDao = new CustomerDAO();
        // StudentDAO studentDao = new StudentDAO();
        ArrayList<CustomerVO> customerList = null;

        CustomerVO cvo = new CustomerVO();
        System.out.println("회원 정보 입력");
        String id = null;
        do {
            System.out.print("아이디(8자 이상 12자 이내) : ");
            id = sc.nextLine();
            cvo.setId(id);
            boolean idCheck = customerDao.customerIdCheck(cvo);
            if (idCheck == false) {
                System.out.println("사용 가능한 아이디입니다!");
                break;
            }
            System.out.println("중복된 아이디입니다. 다시 입력하세요");
        } while (true);

        System.out.print("비밀번호(12자 이내) : ");
        String pwd = sc.nextLine();
        
        System.out.print("이름 : ");
        String name = sc.nextLine();

        System.out.print("주소 : ");
        String address = sc.nextLine();

        System.out.print("전화번호(ex)010-1234-1234) : ");
        String phone = sc.nextLine();
        
        CustomerVO customerVO = new CustomerVO(id, pwd, name, address, phone, null);
        boolean successFlag = customerDao.studentInsert(customerVO);

        if (successFlag == false) {
            System.out.println("입력처리 실패");
            return;
        }

        System.out.println();
        System.out.println("등록 회원 정보");
        customerList = customerDao.customerSelect(); // 삽입 후 데이터 조회
        if (customerList == null) {
            System.out.println("회원정보가 존재하지 않습니다");
            return;
        }
        printCustomerList(customerList);
    }

    // 고객정보수정
    public void updateManager() throws SQLException {
        CustomerDAO customerDao = new CustomerDAO();
        System.out.print("수정할 회원의 아이디를 입력하세요: ");
        String id = sc.nextLine();

        System.out.print("새 비밀번호(12자 이내): ");
        String pwd = sc.nextLine();

        System.out.print("새 이름: ");
        String name = sc.nextLine();

        System.out.print("새 주소: ");
        String address = sc.nextLine();

        System.out.print("새 전화번호(ex)010-1234-1234): ");
        String phone = sc.nextLine();

        CustomerVO customerVO = new CustomerVO(id, pwd, name, address, phone, null);
        boolean successFlag = customerDao.updateCustomer(customerVO);

        if (successFlag) {
            System.out.println("수정처리 성공");
        } else {
            System.out.println("수정처리 실패");
        }
    }

    // 고객정보삭제
    public void deleteManager() throws SQLException {
        CustomerDAO customerDao = new CustomerDAO();
        System.out.print("삭제할 회원의 아이디를 입력하세요: ");
        String id = sc.nextLine();

        boolean successFlag = customerDao.deleteCustomer(id);

        if (successFlag) {
            System.out.println("삭제처리 성공");
        } else {
            System.out.println("삭제처리 실패");
        }
    }

    // 전체 고객 리스트 출력
    public void printCustomerList(ArrayList<CustomerVO> customerList) {
        System.out.println("===================================================================================================================");
        System.out.println("                                   -전체 고객 리스트-                                    ");
        System.out.println("===================================================================================================================");
        for (CustomerVO cv : customerList) {
            System.out.println(cv.toString());
        }
        System.out.println("===================================================================================================================");
    }
}
