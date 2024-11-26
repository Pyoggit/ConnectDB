package kr.co.parcelMVC.model;

import java.sql.Date;

public class CustomerVO {
	private String code; //pk 회원코드
	private String id;   //uk 아이디
	private String pwd;  //비밀번호
	private String name; //이름
	private String address;//주소
	private String phone;//전화번호
	private Date cdate; //회원가입일자
	
	public CustomerVO() {}

	public CustomerVO(String code, String id, String pwd, String name, String address, String phone, Date cdate) {
		super();
		this.code = code;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.cdate = cdate;
	}

	public CustomerVO(String id, String pwd, String name, String address, String phone, Date cdate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.cdate = cdate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	@Override
	public String toString() {
		return "[회원코드 = " + code + ", id = " + id + ", passwd = " + pwd + ", 이름 = " + name + ", 주소 = " + address
				+ ", 전화번호 = " + phone + ", 가입일자 = " + cdate + "]";
	}
	

//	@Override
//	public String toString() {
//	    return String.format("[회원코드 = %2s, 아이디 = %-5s, 비밀번호 = %-12s, 이름 = %-3s, 주소 = %-10s, 전화번호 = %-13s, 가입일자 = %tF]", code, id, pwd, name, address, phone, cdate);
//	}

}
