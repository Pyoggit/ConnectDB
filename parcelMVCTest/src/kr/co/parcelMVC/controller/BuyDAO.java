package kr.co.parcelMVC.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.parcelMVC.model.BuyVO;

public class BuyDAO {

    public static final String BUY_SELECT = "SELECT * FROM BUY";
    public static final String BUY_INSERT = "INSERT INTO BUY (CODE, CUST_CODE, PRO_CODE, COP_CODE, AMOUNT, TOTAL) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String BUY_UPDATE = "UPDATE BUY SET CUST_CODE = ?, PRO_CODE = ?, COP_CODE = ?, AMOUNT = ?, TOTAL = ? WHERE CODE = ?";
    public static final String BUY_DELETE = "DELETE FROM BUY WHERE CODE = ?";
    public static final String BUY_SELECT_ALL = "SELECT B.CODE AS ORDER_CODE, C.NAME AS CUSTOMER_NAME, P.NAME AS PRODUCT_NAME, CO.NAME AS COMPANY_NAME, B.AMOUNT, B.TOTAL " +
                                                    "FROM BUY B " +
                                                    "INNER JOIN CUSTOMER C ON B.CUST_CODE = C.CODE " +
                                                    "INNER JOIN PRODUCT P ON B.PRO_CODE = P.CODE " +
                                                    "INNER JOIN COMPANY CO ON B.COP_CODE = CO.CODE";

    // 출력 확인
    public ArrayList<BuyVO> buySelect() throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<BuyVO> buyList = new ArrayList<BuyVO>();

        con = DBUtility.dbCon();
        stmt = con.createStatement();
        rs = stmt.executeQuery(BUY_SELECT);

        if (rs.next()) {
            do {
                String code = rs.getString("CODE");
                String custCode = rs.getString("CUST_CODE");
                String proCode = rs.getString("PRO_CODE");
                String copCode = rs.getString("COP_CODE");
                int amount = rs.getInt("AMOUNT");
                int total = rs.getInt("TOTAL");
                BuyVO bvo = new BuyVO(code, custCode, proCode, copCode, amount, total);
                buyList.add(bvo);
            } while (rs.next());
        } else {
            buyList = null;
        }
        DBUtility.dbClose(con, stmt, rs);
        return buyList;
    }

    // 입력 확인
    public boolean buyInsert(BuyVO bvo) throws SQLException {
        boolean successFlag = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        con = DBUtility.dbCon();

        pstmt = con.prepareStatement(BUY_INSERT);
        pstmt.setString(1, bvo.getCode());
        pstmt.setString(2, bvo.getCust_code());
        pstmt.setString(3, bvo.getPro_code());
        pstmt.setString(4, bvo.getCop_code());
        pstmt.setInt(5, bvo.getAmount());
        pstmt.setInt(6, bvo.getTotal());

        int result = pstmt.executeUpdate();

        DBUtility.dbClose(con, pstmt);
        successFlag = (result != 0) ? true : false;
        return successFlag;
    }

    // 수정
    public boolean buyUpdate(BuyVO bvo) throws SQLException {
        boolean successFlag = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        con = DBUtility.dbCon();
        pstmt = con.prepareStatement(BUY_UPDATE);
        pstmt.setString(1, bvo.getCust_code());
        pstmt.setString(2, bvo.getPro_code());
        pstmt.setString(3, bvo.getCop_code());
        pstmt.setInt(4, bvo.getAmount());
        pstmt.setInt(5, bvo.getTotal());
        pstmt.setString(6, bvo.getCode());

        int result = pstmt.executeUpdate();

        successFlag = (result != 0) ? true : false;

        DBUtility.dbClose(con, pstmt);
        return successFlag;
    }

    // 삭제 확인
    public boolean buyDelete(BuyVO bvo) throws SQLException {
        boolean successFlag = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        con = DBUtility.dbCon();
        pstmt = con.prepareStatement(BUY_DELETE);
        pstmt.setString(1, bvo.getCode());
        int result = pstmt.executeUpdate();
        successFlag = (result != 0) ? true : false;
        DBUtility.dbClose(con, pstmt);
        return successFlag;
    }

    // 주문, 고객, 상품, 업체 정보를 포함한 주문 조회
    public ArrayList<BuyVO> buySelectDetail() throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<BuyVO> buyList = new ArrayList<BuyVO>();

        con = DBUtility.dbCon();
        stmt = con.createStatement();
        rs = stmt.executeQuery(BUY_SELECT_ALL);

        if (rs.next()) {
            do {
                String code = rs.getString("ORDER_CODE");
                String customerName = rs.getString("CUSTOMER_NAME");
                String productName = rs.getString("PRODUCT_NAME");
                String companyName = rs.getString("COMPANY_NAME");
                int amount = rs.getInt("AMOUNT");
                int total = rs.getInt("TOTAL");
                BuyVO bvo = new BuyVO(code, customerName, productName, companyName, amount, total);
                buyList.add(bvo);
            } while (rs.next());
        } else {
            buyList = null;
        }
        DBUtility.dbClose(con, stmt, rs);
        return buyList;
    }
}
