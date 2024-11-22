package kr.co.subjectMVC.model;

public class SubjectVO {

	private int no;
	private String num;
	private String name;
	
	public SubjectVO() {}

	public SubjectVO(String num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public SubjectVO(int no, String num, String name) {
		super();
		this.no = no;
		this.num = num;
		this.name = name;
	}
	
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "SubjectVO [no=" + no + ", num=" + num + ", name=" + name + "]";
	}
	
	
}
