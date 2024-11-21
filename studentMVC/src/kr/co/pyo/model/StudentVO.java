package kr.co.pyo.model;

public class StudentVO {
	private int no; // ----------------pk
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int total;
	private int ave;
	private int rank;

	//디폴트 생성자
	public StudentVO() {}
	
	public StudentVO(int no, String name, int kor, int eng, int mat, int total, int ave, int rank) {
		super();
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.total = total;
		this.ave = ave;
		this.rank = rank;
	}
	
	public StudentVO(int no, String name, int kor, int eng, int mat) {
		super();
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public StudentVO(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAve() {
		return ave;
	}

	public void setAve(int ave) {
		this.ave = ave;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
	//String.format();
	@Override
	public String toString() {
	    return String.format("[학번 = %2d, 이름 = %-5s, 국어점수 = %3d, 영어점수 = %3d, 수학점수 = %3d, 총점 = %3d, 평균 = %3d, 순위 = %2d]",
	            no, name, kor, eng, mat, total, ave, rank);
	    
	}


}
