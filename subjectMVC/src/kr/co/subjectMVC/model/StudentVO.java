package kr.co.subjectMVC.model;

import java.sql.Date;

public class StudentVO {
	private int no;
	private String num;
	private String name;
	private String id;
	private String passwd;
	private String s_num;
	private String birthday;
	private String phone;
	private String address;
	private String email;
	private Date sdate;

	public StudentVO() {}

	public StudentVO(int no, String num, String name, String id, String passwd, String s_num, String birthday,
			String phone, String address, String email, Date sdate) {
		super();
		this.no = no;
		this.num = num;
		this.name = name;
		this.id = id;
		this.passwd = passwd;
		this.s_num = s_num;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.sdate = sdate;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getS_num() {
		return s_num;
	}

	public void setS_num(String s_num) {
		this.s_num = s_num;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	@Override
	public String toString() {
		return "StudentVO [no=" + no + ", num=" + num + ", name=" + name + ", id=" + id + ", passwd=" + passwd
				+ ", s_num=" + s_num + ", birthday=" + birthday + ", phone=" + phone + ", address=" + address
				+ ", email=" + email + ", sdate=" + sdate + "]";
	}
	
}
