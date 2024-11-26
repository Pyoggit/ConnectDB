package kr.co.parcelMVC.model;

public class CompanyVO {
	private String code; //회사코드,pk
	private String name; //배송업체명
	private int price;  //배송비
	
	public CompanyVO() {}
	
	public CompanyVO(String code, String name, int price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
	    return String.format("[회사코드 = %2s, 배송업체명 = %-5s, 배송비 = %3d]", code, name, price);
	}

}
