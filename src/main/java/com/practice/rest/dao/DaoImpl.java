package com.practice.rest.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.practice.rest.domains.MutualFund;
import com.practice.rest.domains.ShareDetails;

@Component
public class DaoImpl implements Dao {

	private static Map<String,MutualFund> mutualsFunds = new HashMap<String,MutualFund>();


	static {
		ShareDetails s1 = new ShareDetails();
		s1.setShareName("Tcs");
		s1.setQuantity("10");
		s1.setPrice("1000");


		ShareDetails s2 = new ShareDetails();
		s2.setShareName("Infosys");
		s2.setQuantity("20");
		s2.setPrice("2000");

		List<ShareDetails> shareList = new ArrayList<ShareDetails>();
		shareList.add(s1);
		shareList.add(s2);
		MutualFund mf = new MutualFund();
		mf.setName("BlueChip");
		mf.setTotalShares(shareList);

		mutualsFunds.put("BlueChip",mf);

	}
	@Override
	public MutualFund getMutualFundDetails(String name){
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
