package kr.co.parcelMVC.model;

public class BuyVO {
	private String code;
	private String cust_code;
	private String pro_code;
	private String cop_code;
	private int amount;
	private int total;
	
	public BuyVO() {}
	
	public BuyVO(String code, String cust_code, String pro_code, String cop_code, int amount, int total) {
		super();
		this.code = code;
		this.cust_code = cust_code;
		this.pro_code = pro_code;
		this.cop_code = cop_code;
		this.amount = amount;
		this.total = total;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCust_code() {
		return cust_code;
	}

	public void setCust_code(String cust_code) {
		this.cust_code = cust_code;
	}

	public String getPro_code() {
		return pro_code;
	}

	public void setPro_code(String pro_code) {
		this.pro_code = pro_code;
	}

	public String getCop_code() {
		return cop_code;
	}

	public void setCop_code(String cop_code) {
		this.cop_code = cop_code;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
	    return String.format("[주문코드 = %2s, 회원코드 = %-5s, 상품코드 = %2s, 회사코드 = %2s, 주문수량 = %3d, 총금액 = %3d]", 
	            code, cust_code, pro_code, cop_code, amount, total);
	}

}
