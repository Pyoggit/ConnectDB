package kr.co.parcelMVC.model;

public class CustomerVO {
	private String code; //pk 회원코드
	private String id;   //uk 아이디
	private String pwd;  //비밀번호
	private String name; //이름
	private String address;//주소
	private String phone;//전화번호
	
	public CustomerVO() {}

	public CustomerVO(String code, String id, String pwd, String name, String address, String phone) {
		super();
		this.code = code;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
		this.phone = phone;
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

	@Override
	public String toString() {
		return "CustomerVO [code=" + code + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + "]";
	}
	

}
