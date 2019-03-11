package com.practice.rest.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.practice.rest.domains.MutualFund;
import com.practice.rest.domains.MutualFundNotFound;

@Component
public class DaoImpl implements Dao {

	private static Map<String,MutualFund> mutualsFunds = new HashMap<String,MutualFund>();


	
	@Override
	public MutualFund getMutualFundDetails (  String name) throws MutualFundNotFound {
		return mutualsFunds.get(name);
	}

	@Override
	public void insertMutualFund(MutualFund mutualFund){
		mutualsFunds.put(mutualFund.getName(), mutualFund);
	}

	@Override
	public Set<String> getAllMutualFundDetails(){
		return mutualsFunds.keySet();
	}

}
