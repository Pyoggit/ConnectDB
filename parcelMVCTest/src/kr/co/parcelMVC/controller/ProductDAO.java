package kr.co.parcelMVC.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.parcelMVC.model.ProductVO;



public class ProductDAO {

    public static final String PRODUCT_SELECT = "SELECT * FROM PRODUCT";
    public static final String PRODUCT_INSERT = "INSERT INTO PRODUCT (CODE, NAME, PRICE, REMAIN) VALUES (?, ?, ?, ?)";
    public static final String PRODUCT_UPDATE = "UPDATE PRODUCT SET NAME = ?, PRICE = ?, REMAIN = ? WHERE CODE = ?";
    public static final String PRODUCT_DELETE = "DELETE FROM PRODUCT WHERE CODE = ?";

    // 출력 확인
    public ArrayList<ProductVO> productSelect() throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<ProductVO> productList = new ArrayList<ProductVO>();

        con = DBUtility.dbCon();
        stmt = con.createStatement();
        rs = stmt.executeQuery(PRODUCT_SELECT);

        if (rs.next()) {
            do {
                String code = rs.getString("CODE");
                String name = rs.getString("NAME");
                int price = rs.getInt("PRICE");
                int remain = rs.getInt("REMAIN");
                ProductVO pvo = new ProductVO(code, name, price, remain);
                productList.add(pvo);
            } while (rs.next());
        } else {
            productList = null;
        }
        DBUtility.dbClose(con, stmt, rs);
        return productList;
    }

    // 입력 확인
    public boolean productInsert(ProductVO pvo) throws SQLException {
        boolean successFlag = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        con = DBUtility.dbCon();

        pstmt = con.prepareStatement(PRODUCT_INSERT);
        pstmt.setString(1, pvo.getCode());
        pstmt.setString(2, pvo.getName());
        pstmt.setInt(3, pvo.getPrice());
        pstmt.setInt(4, pvo.getRemain());

        int result = pstmt.executeUpdate();

        DBUtility.dbClose(con, pstmt);
        successFlag = (result != 0) ? true : false;
        return successFlag;
    }

    // 수정
    public boolean productUpdate(ProductVO pvo) throws SQLException {
        boolean successFlag = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        con = DBUtility.dbCon();
        pstmt = con.prepareStatement(PRODUCT_UPDATE);
        pstmt.setString(1, pvo.getName());
        pstmt.setInt(2, pvo.getPrice());
        pstmt.setInt(3, pvo.getRemain());
        pstmt.setString(4, pvo.getCode());

        int result = pstmt.executeUpdate();

        successFlag = (result != 0) ? true : false;

        DBUtility.dbClose(con, pstmt);
        return successFlag;
    }

    // 삭제 확인
    public boolean productDelete(ProductVO pvo) throws SQLException {
        boolean successFlag = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        con = DBUtility.dbCon();
        pstmt = con.prepareStatement(PRODUCT_DELETE);
        pstmt.setString(1, pvo.getCode());
        int result = pstmt.executeUpdate();
        successFlag = (result != 0) ? true : false;
        DBUtility.dbClose(con, pstmt);
        return successFlag;
    }
}