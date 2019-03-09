package com.practice.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.rest.dao.DaoImpl;
import com.practice.rest.domains.MutualFund;

@RestController
public class RequestController {
	
	@Autowired
	private DaoImpl service;
	
	@GetMapping(path = "/mutualfund/{name}")
	public MutualFund getMutualFundDetails(@PathVariable String name) {
		return service.getMutualFundDetails(name);
	}

	//@PostMapping(path = "/mutualfund" )
	@RequestMapping(value = "/mutualfund", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
	public List<String> addMutualFundDetails(@RequestBody MutualFund mutualFund) {
		service.insertMutualFund(mutualFund);
		List<String> response = new ArrayList<String>();
		System.out.println(service.getAllMutualFundDetails());
		System.out.println(mutualFund.getName());
		System.out.println(mutualFund.getTotalShares());
        return response;
	}
	
	
	
}
