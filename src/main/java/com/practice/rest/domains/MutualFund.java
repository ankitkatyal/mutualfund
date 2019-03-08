package com.practice.rest.domains;

import java.util.List;

public class MutualFund {
	
	private List<ShareDetails> sharesContent;
	private String name;
	
	public List<ShareDetails> getTotalShares() {
		return sharesContent;
	}
	public void setTotalShares(List<ShareDetails> totalShares) {
		this.sharesContent = totalShares;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MutualFund [sharesContent=" + sharesContent.toString() + ", name=" + name + "]";
	}
	
	
	

}
