package com.practice.rest.dao;

import java.util.Set;

import com.practice.rest.domains.MutualFund;
import com.practice.rest.domains.MutualFundNotFound;


public interface Dao {
	
	public MutualFund getMutualFundDetails  (String name) throws MutualFundNotFound ;
	
	public void insertMutualFund(MutualFund mutualFund);
	
	public Set<String> getAllMutualFundDetails();
	

}
