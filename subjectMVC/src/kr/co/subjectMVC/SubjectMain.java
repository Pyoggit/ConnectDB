package kr.co.subjectMVC;

import java.sql.SQLException;
import java.util.Scanner;

import kr.co.subjectMVC.controller.LessonRegisterManager;
import kr.co.subjectMVC.controller.StudentRegisterManager;
import kr.co.subjectMVC.controller.SubjectRegisterManager;
import kr.co.subjectMVC.controller.TraineeRegisterManager;
import kr.co.subjectMVC.view.LESSON_CHOICE;
import kr.co.subjectMVC.view.MENU_CHOICE;
import kr.co.subjectMVC.view.MenuViewer;
import kr.co.subjectMVC.view.STUDENT_CHOICE;
import kr.co.subjectMVC.view.SUBJECT_CHOICE;
import kr.co.subjectMVC.view.TRAINEE_CHOICE;

public class SubjectMain {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int no;
		boolean exitFlag = false;
		while (!exitFlag) {
			try {
				MenuViewer.mainMenuView();
				no = Integer.parseInt(sc.nextLine());

				switch (no) {
				case MENU_CHOICE.SUBJECT:
					subjectMenu();
					break;
				case MENU_CHOICE.STUDENT:
					studentMenu();
					break;
				case MENU_CHOICE.LESSON:
					lessonMenu();
					break;
				case MENU_CHOICE.TRAINEE:
					traineeMenu();
					break;
				case MENU_CHOICE.EXIT:
					System.out.println("프로그램을 종료합니다.");
					exitFlag = true;
					break;
				default:
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
			}
		} // end of line
	}

	// 수강 신청 메뉴
	private static void traineeMenu() {
		int no;
		TraineeRegisterManager trm = new TraineeRegisterManager();

		// StudentRegisterManager studnetManager = new StudentRegisterManager();
		MenuViewer.traineeMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case TRAINEE_CHOICE.INSERT:
			System.out.println("");
			// srm.insertManager();
			break;
		case TRAINEE_CHOICE.UPDATE:
			System.out.println("");
//            studnetManager.studnetUpdate();
			break;
		case TRAINEE_CHOICE.LIST:
			System.out.println("");
//            studnetManager.studnetTotalList();
			break;
		case TRAINEE_CHOICE.DELETE:
			System.out.println("");
//            studnetManager.studnetTotalList();
			break;
		case TRAINEE_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}

	}

	// 과목 정보 메뉴
	private static void lessonMenu() {
		int no;
		LessonRegisterManager lrm = new LessonRegisterManager();

		// StudentRegisterManager studnetManager = new StudentRegisterManager();
		MenuViewer.lessonMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case LESSON_CHOICE.INSERT:
			System.out.println("");
			// srm.insertManager();
			break;
		case LESSON_CHOICE.UPDATE:
			System.out.println("");
//            studnetManager.studnetUpdate();
			break;
		case LESSON_CHOICE.LIST:
			System.out.println("");
//            studnetManager.studnetTotalList();
			break;
		case LESSON_CHOICE.DELETE:
			System.out.println("");
//            studnetManager.studnetTotalList();
			break;
		case LESSON_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}

	}

	// 학생 정보 메뉴
	private static void studentMenu() throws SQLException {
		int no;
		StudentRegisterManager strm = new StudentRegisterManager();

		// StudentRegisterManager studnetManager = new StudentRegisterManager();
		MenuViewer.studentMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case STUDENT_CHOICE.INSERT:
			System.out.println("");
			strm.insertManager();
			break;
		case STUDENT_CHOICE.UPDATE:
			System.out.println("");
//            studnetManager.studnetUpdate();
			break;
		case STUDENT_CHOICE.LIST:
			System.out.println("");
			strm.selectManager();
			break;
		case STUDENT_CHOICE.DELETE:
			System.out.println("");
//            studnetManager.studnetTotalList();
			break;
		case STUDENT_CHOICE.LIST_ALL:
			System.out.println("");
            strm.selectAllManager();
			break;
		case STUDENT_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}

	}

	// 학과 정보 메뉴
	private static void subjectMenu() throws SQLException {
		int no;
		SubjectRegisterManager srm = new SubjectRegisterManager();

		// StudentRegisterManager studnetManager = new StudentRegisterManager();
		MenuViewer.subjectMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case SUBJECT_CHOICE.LIST:
			System.out.println("");
            srm.selectManager();
			break;
		case SUBJECT_CHOICE.INSERT:
			System.out.println("");
			srm.insertManager();
			break;
		case SUBJECT_CHOICE.UPDATE:
			System.out.println("");
			srm.updateManager();
			break;
		case SUBJECT_CHOICE.DELETE:
			System.out.println("");
            srm.deleteManager();
			break;
		case SUBJECT_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}

	}

}