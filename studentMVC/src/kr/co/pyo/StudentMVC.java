package kr.co.pyo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import kr.co.pyo.controller.StudentRegisterManager;
import kr.co.pyo.view.StudentCURD;
import kr.co.pyo.view.StudentMenu;

public class StudentMVC {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		boolean exitFlag = false;
		while (!exitFlag) {
			StudentMenu.printMenu();
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case StudentCURD.PRINT: {
				StudentRegisterManager.totalSelectManager();
				break;
			}
			case StudentCURD.INSERT: {
				StudentRegisterManager.insertManager();
				break;
			}
			case StudentCURD.UPDATE: {
				StudentRegisterManager.updateManager();
				break;
			}
			case StudentCURD.DELETE: {
				StudentRegisterManager.deleteManager();
				break;
			}
			case StudentCURD.SORT: {
				StudentRegisterManager.sortManager();
				break;
			}
			case StudentCURD.EXIT: {
				exitFlag = true;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + num);
			}
			System.out.println("The end");
		}

	}

}