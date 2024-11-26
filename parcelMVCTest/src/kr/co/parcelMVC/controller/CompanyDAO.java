package kr.co.parcelMVC.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.parcelMVC.model.CompanyVO;

public class CompanyDAO {

    public static final String COMPANY_SELECT = "SELECT * FROM COMPANY";
    public static final String COMPANY_INSERT = "INSERT INTO COMPANY (CODE, NAME, PRICE) VALUES (?, ?, ?)";
    public static final String COMPANY_UPDATE = "UPDATE COMPANY SET NAME = ?, PRICE = ? WHERE CODE = ?";
    public static final String COMPANY_DELETE = "DELETE FROM COMPANY WHERE CODE = ?";

    // 출력 확인
    public ArrayList<CompanyVO> companySelect() throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<CompanyVO> companyList = new ArrayList<CompanyVO>();

        con = DBUtility.dbCon();
        stmt = con.createStatement();
        rs = stmt.executeQuery(COMPANY_SELECT);

        if (rs.next()) {
            do {
                String code = rs.getString("CODE");
                String name = rs.getString("NAME");
                int price = rs.getInt("PRICE");
                CompanyVO cvo = new CompanyVO(code, name, price);
                companyList.add(cvo);
            } while (rs.next());
        } else {
            companyList = null;
        }
        DBUtility.dbClose(con, stmt, rs);
        return companyList;
    }

    // 입력 확인
    public boolean companyInsert(CompanyVO cvo) throws SQLException {
        boolean successFlag = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        con = DBUtility.dbCon();

        pstmt = con.prepareStatement(COMPANY_INSERT);
        pstmt.setString(1, cvo.getCode());
        pstmt.setString(2, cvo.getName());
        pstmt.setInt(3, cvo.getPrice());

        int result = pstmt.executeUpdate();

        DBUtility.dbClose(con, pstmt);
        successFlag = (result != 0) ? true : false;
        return successFlag;
    }

    // 수정
    public boolean companyUpdate(CompanyVO cvo) throws SQLException {
        boolean successFlag = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        con = DBUtility.dbCon();
        pstmt = con.prepareStatement(COMPANY_UPDATE);
        pstmt.setString(1, cvo.getName());
        pstmt.setInt(2, cvo.getPrice());
        pstmt.setString(3, cvo.getCode());

        int result = pstmt.executeUpdate();

        successFlag = (result != 0) ? true : false;

        DBUtility.dbClose(con, pstmt);
        return successFlag;
    }

    // 삭제 확인
    public boolean companyDelete(CompanyVO cvo) throws SQLException {
        boolean successFlag = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        con = DBUtility.dbCon();
        pstmt = con.prepareStatement(COMPANY_DELETE);
        pstmt.setString(1, cvo.getCode());
        int result = pstmt.executeUpdate();
        successFlag = (result != 0) ? true : false;
        DBUtility.dbClose(con, pstmt);
        return successFlag;
    }
}

