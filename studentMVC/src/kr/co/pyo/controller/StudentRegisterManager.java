package kr.co.pyo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import kr.co.pyo.StudentMVC;
import kr.co.pyo.model.StudentVO;

public class StudentRegisterManager {

	public static Scanner sc = new Scanner(System.in);

	// 출력
	public static void totalSelectManager() throws SQLException {
		ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();
		studentList = StudentDAO.totalSelect();
		printStudentList(studentList);
	}

	// 입력
	public static void insertManager() throws SQLException {

		System.out.print("학생 이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.print("국어 점수를 입력하세요: ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("영어 점수를 입력하세요: ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("수학 점수를 입력하세요: ");
		int mat = Integer.parseInt(sc.nextLine());

		StudentVO studentVO = new StudentVO(name, kor, eng, mat);
		boolean successFlag = StudentDAO.studentInsert(studentVO);

		if (successFlag == true) {
			System.out.println("입력처리 성공");
		} else {
			System.out.println("입력처리 실패");
		}
	}

	// 수정
	public static void updateManager() throws SQLException {
		System.out.print("수정할 학생의 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.print("새로운 국어 점수를 입력하세요: ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 영어 점수를 입력하세요: ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 수학 점수를 입력하세요: ");
		int mat = Integer.parseInt(sc.nextLine());

		StudentVO svo = new StudentVO(no, name, kor, eng, mat);
		boolean successFlag = StudentDAO.studentUpdate(svo);

		if (successFlag == true) {
			System.out.println("입력처리 성공");
		} else {
			System.out.println("입력처리 실패");
		}
	}

	// 삭제
	public static void deleteManager() throws SQLException {
		System.out.print("삭제할 학생 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		StudentVO svo = new StudentVO();
		svo.setNo(no);
		boolean successFlag = StudentDAO.studentDelete(svo);
		if (successFlag == true) {
			System.out.println("삭제처리 성공");
		} else {
			System.out.println("삭제처리 실패");
		}

	}

	// 정렬
	public static void sortManager() throws SQLException {
		ArrayList<StudentVO> studentList = null;
		studentList = StudentDAO.studentSort();
		printStudentList(studentList);

	}

	// 전체 학생 리스트를 출력
	public static void printStudentList(ArrayList<StudentVO> studentList) {
	    System.out.println("==========================================================================");
	    System.out.printf("%-6s %-6s %8s %6s %6s %6s %6s %6s%n", 
	                      "학번", "이름", "국어점수", "영어점수", "수학점수", "총점", "평균", "순위");
	    System.out.println("==========================================================================");

	    for (StudentVO sv : studentList) {
	        System.out.printf("%-6d %-6s %8d %8d %8d %8d %8d %6d%n",
	                          sv.getNo(), sv.getName(), sv.getKor(), sv.getEng(), sv.getMat(),
	                          sv.getTotal(), sv.getAve(), sv.getRank());
	    }

	    System.out.println("==========================================================================");
	}



}
