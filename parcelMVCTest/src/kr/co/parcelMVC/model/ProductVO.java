package kr.co.parcelMVC.model;

public class ProductVO {
	private String code; //pk 상품코드
	private String name; //uq 상품명
	private int price;   //가격
	private int remain;  //잔여수량
	
	public ProductVO() {}

	public ProductVO(String code, String name, int price, int remain) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.remain = remain;
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

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	@Override
	public String toString() {
		return "ProductVO [code=" + code + ", name=" + name + ", price=" + price + ", remain=" + remain + "]";
	}

}
