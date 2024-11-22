package kr.co.pyo;

import java.sql.SQLException;
import java.util.Scanner;

import kr.co.pyo.controller.StudentRegisterManager;
import kr.co.pyo.view.StudentCURD;
import kr.co.pyo.view.StudentMenu;

public class StudentMVC {
	public static Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) throws SQLException {
		boolean exitFlag = false;
		StudentRegisterManager srm = new StudentRegisterManager();
		
		while (!exitFlag) {
			StudentMenu.printMenu();
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case StudentCURD.PRINT: {
				srm.selectManager();
				break;
			}
			case StudentCURD.INSERT: {
				srm.insertManager();
				break;
			}
			case StudentCURD.UPDATE: {
				srm.updateManager();
				break;
			}
			case StudentCURD.DELETE: {
				srm.deleteManager();
				break;
			}
			case StudentCURD.SORT: {
				srm.sortManager();
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