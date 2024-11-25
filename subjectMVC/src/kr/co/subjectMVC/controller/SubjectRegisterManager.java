package kr.co.subjectMVC.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import kr.co.subjectMVC.model.StudentVO;
import kr.co.subjectMVC.model.SubjectVO;


public class SubjectRegisterManager {

	public static Scanner sc = new Scanner(System.in);

	// 출력 확인
	public static void selectManager() throws SQLException {
		ArrayList<SubjectVO> subjectList = new ArrayList<SubjectVO>();
		SubjectDAO subDAO = new SubjectDAO();
		subjectList = subDAO.subjectSelect();
		if(subjectList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
	
		printSubjectList(subjectList);
	}

	// 입력 확인
	public static void insertManager() throws SQLException {
		SubjectDAO sd = new SubjectDAO();

        String num; // 학과 번호
        String name; // 학과명

        System.out.println("학과 전체 리스트");
        //sd.getSubjectTotalList();
        System.out.println();

        System.out.println("학과 정보 입력 : 학과번호(학과명) : 01(IT), 02(정보통신).....");
        System.out.print("학과번호 : ");
        num = sc.nextLine();
        System.out.print("학과명  : ");
        name = sc.nextLine();

        SubjectVO svo = new SubjectVO(num,name);
        //sd.subjectInsert(svo);
        
        boolean successFlag = sd.subjectInsert(svo);
        if(successFlag == false) {
			System.out.println("입력처리 실패");
			return;
		}

        System.out.println();
        System.out.println("학과 전체 리스트");
        ArrayList<SubjectVO> subjectList = sd.subjectSelect();
        System.out.println();
        
        if (subjectList == null) {
        	System.out.println("학과정보가 없습니다");
        	return;
        } 
        
        printSubjectList(subjectList);

	}

	// 수정
	public static void updateManager() throws SQLException {
		SubjectDAO sd = new SubjectDAO();
		ArrayList<SubjectVO> subjectList = sd.subjectSelect();
		if(subjectList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
		}
		printSubjectList(subjectList); 
		System.out.print("수정할 학과의 번호를 입력하세요: ");
		String num = (sc.nextLine()).trim();
		System.out.print("수정할 학과 이름을 입력하세요: ");
		String name = sc.nextLine();

		SubjectVO svo = new SubjectVO(num, name);
		
		boolean successFlag = sd.subjectUpdate(svo);

		if (successFlag == true) {
			System.out.println("수정처리 성공");
		} else {
			System.out.println("수정처리 실패");
		}
	}

	// 삭제 확인
	public void deleteManager() throws SQLException {
		SubjectDAO sd = new SubjectDAO();
		
		System.out.print("삭제할 학과 번호를 입력하세요: ");
		String num = (sc.nextLine()).trim();
		SubjectVO svo = new SubjectVO();
		svo.setNum(num);
		boolean successFlag = sd.subjectDelete(svo);
		if (successFlag == true) {
			System.out.println("삭제처리 성공");
		} else {
			System.out.println("삭제처리 실패");
		}

	}

	// 정렬
	public void sortManager() throws SQLException {
		SubjectDAO sd = new SubjectDAO();
		ArrayList<SubjectVO> subjectList = null;
		subjectList =sd.subjectSort();
		if(subjectList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		
		printSubjectList(subjectList);

	}

	// 전체 학생 리스트를 출력
	public static void printSubjectList(ArrayList<SubjectVO> subjectList) {
	    System.out.println("==========================================================================");
//	    System.out.printf("%-6s %-6s %8s %6s %6s %6s %6s %6s%n", 
//	                      "학번", "이름", "국어점수", "영어점수", "수학점수", "총점", "평균", "순위");
	    System.out.println("학과 정보");
	    System.out.println("==========================================================================");

	    for (SubjectVO sv : subjectList) {
	        System.out.println(sv.toString());
	    }

	    System.out.println("==========================================================================");
	}



}
