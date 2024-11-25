package kr.co.subjectMVC.model;

import java.sql.Date;

public class StudentAllVO {
	private int no;
	private String num;
	private String name;
	private String id;
	private String passwd;
	private String s_num;
	private String s_name;	
	private String birthday;
	private String phone;
	private String address;
	private String email;
	private Date sdate;
	
	public StudentAllVO(int no, String num, String name, String id, String passwd, String s_num, String s_name,
			String birthday, String phone, String address, String email, Date sdate) {
		super();
		this.no = no;
		this.num = num;
		this.name = name;
		this.id = id;
		this.passwd = passwd;
		this.s_num = s_num;
		this.s_name = s_name;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.sdate = sdate;
	}

	@Override
	public String toString() {
		return "[no=" + no + ", num=" + num + ", name=" + name + ", id=" + id + ", passwd=" + passwd
				+ ", s_num=" + s_num + ", s_name=" + s_name + ", birthday=" + birthday + ", phone=" + phone
				+ ", address=" + address + ", email=" + email + ", sdate=" + sdate + "]";
	}

	
	
}
