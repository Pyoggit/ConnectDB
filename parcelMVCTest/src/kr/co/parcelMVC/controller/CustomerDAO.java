package kr.co.parcelMVC.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.parcelMVC.model.CustomerVO;

public class CustomerDAO {

    private static final String CUSTOMER_SELECT = "SELECT * FROM CUSTOMER";
    private static final String CUSTOMER_INSERT = "INSERT INTO CUSTOMER (CODE, ID, PWD, NAME, ADDRESS, PHONE, CDATE) VALUES (CUSTOMER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";
    private static final String CUSTOMER_ID_CHECK = "SELECT COUNT(*) AS COUNT  FROM CUSTOMER WHERE ID = ?";
    private static final String CUSTOMER_UPDATE = "UPDATE CUSTOMER SET PWD = ?, NAME = ?, ADDRESS = ?, PHONE = ? WHERE ID = ?";
    private static final String CUSTOMER_DELETE = "DELETE FROM CUSTOMER WHERE ID = ?";

    // 출력
    public static ArrayList<CustomerVO> customerSelect() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<CustomerVO> customerList = new ArrayList<CustomerVO>();

        con = DBUtility.dbCon();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(CUSTOMER_SELECT);

            if (rs.next()) {
                do {
                    String code = rs.getString("CODE");
                    String id = rs.getString("ID");
                    String pwd = rs.getString("PWD");
                    String name = rs.getString("NAME");
                    String address = rs.getString("ADDRESS");
                    String phone = rs.getString("PHONE");
                    Date cdate = rs.getDate("CDATE");

                    CustomerVO cust = new CustomerVO(code, id, pwd, name, address, phone, cdate);
                    customerList.add(cust);
                } while (rs.next());
            } else {
                customerList = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtility.dbClose(con, stmt, rs);
        }

        return customerList;
    }

    // 입력
    public static boolean studentInsert(CustomerVO cvo) {
        boolean successFlag = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        // 1 Load, 2. connect
        con = DBUtility.dbCon();

        try {
            pstmt = con.prepareStatement(CUSTOMER_INSERT);
            pstmt.setString(1, cvo.getId());
            pstmt.setString(2, cvo.getPwd());
            pstmt.setString(3, cvo.getName());
            pstmt.setString(4, cvo.getAddress());
            pstmt.setString(5, cvo.getPhone());

            int result = pstmt.executeUpdate();
            successFlag = (result != 0) ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtility.dbClose(con, pstmt);
        }
        return successFlag;
    }

    // 중복 아이디 체크
    public boolean customerIdCheck(CustomerVO cvo) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;

        try {
            con = DBUtility.dbCon();
            pstmt = con.prepareStatement(CUSTOMER_ID_CHECK);
            pstmt.setString(1, cvo.getId());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt("COUNT");
            } else {
                count = 0;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            DBUtility.dbClose(con, pstmt, rs);
        }
        return (count != 0) ? (true) : (false);

    }

    // 수정
    public boolean updateCustomer(CustomerVO cvo) {
        boolean successFlag = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        con = DBUtility.dbCon();

        try {
            pstmt = con.prepareStatement(CUSTOMER_UPDATE);
            pstmt.setString(1, cvo.getPwd());
            pstmt.setString(2, cvo.getName());
            pstmt.setString(3, cvo.getAddress());
            pstmt.setString(4, cvo.getPhone());
            pstmt.setString(5, cvo.getId());

            int result = pstmt.executeUpdate();
            successFlag = (result != 0) ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtility.dbClose(con, pstmt);
        }
        return successFlag;
    }

    // 삭제
    public boolean deleteCustomer(String id) {
        boolean successFlag = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        con = DBUtility.dbCon();

        try {
            pstmt = con.prepareStatement(CUSTOMER_DELETE);
            pstmt.setString(1, id);

            int result = pstmt.executeUpdate();
            successFlag = (result != 0) ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtility.dbClose(con, pstmt);
        }
        return successFlag;
    }
}
