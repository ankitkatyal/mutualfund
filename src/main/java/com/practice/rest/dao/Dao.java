package com.practice.rest.dao;

import java.util.Set;

import com.practice.rest.domains.MutualFund;

public interface Dao {
	
	public MutualFund getMutualFundDetails(String name);
	
	public void insertMutualFund(MutualFund mutualFund);
	
	public Set<String> getAllMutualFundDetails();
	

}
