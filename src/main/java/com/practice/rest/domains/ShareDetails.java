package com.practice.rest.domains;

public class ShareDetails {
	
	private String shareName;
	private String quantity;
	private String price;
	
	public ShareDetails(String shareName, String quantity, String price) {
		super();
		this.shareName = shareName;
		this.quantity = quantity;
		this.price = price;
	}
	
	public ShareDetails() {
		
	}

	public String getShareName() {
		return shareName;
	}
	public void setShareName(String shareName) {
		this.shareName = shareName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ShareDetails [shareName=" + shareName + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	 
	
	
	

}
